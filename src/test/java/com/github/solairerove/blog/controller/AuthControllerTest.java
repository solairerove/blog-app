package com.github.solairerove.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.User;
import com.github.solairerove.blog.dto.LoginDTO;
import com.github.solairerove.blog.security.SecurityProvider;
import com.github.solairerove.blog.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by vlad on 09.06.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class AuthControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserService service;

    @Autowired
    private SecurityProvider provider;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
        User user = new User();
        user.setLogin("admin");
        user.setPassword("pass");
        service.save(user);
    }

    @Test
    public void authenticateTest() throws Exception {
        LoginDTO dto = new LoginDTO("admin", "pass");
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token", notNullValue()));
    }

    @Test
    public void authenticateUnknownUserTest() throws Exception {
        LoginDTO dto = new LoginDTO("unknown", "pass");
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void currentUserTest() throws Exception {
        String token = Jwts.builder().setSubject("admin").
                signWith(SignatureAlgorithm.HS512, provider.getTokenKey()).compact();

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/user")
                .accept(MediaType.APPLICATION_JSON)
                .header("Rest-Token", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.login",is("admin")));
    }

    @Test
    public void currentUnauthorizedUserTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/user")
                .accept(MediaType.APPLICATION_JSON)
                .header("Rest-Token", "wrong_token")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void logoutTest() throws Exception {
        String token = Jwts.builder().setSubject("admin").
                signWith(SignatureAlgorithm.HS512, provider.getTokenKey()).compact();

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/logout")
                .accept(MediaType.APPLICATION_JSON)
                .header("Rest-Token", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void logoutUnauthorizedTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/logout")
                .accept(MediaType.APPLICATION_JSON)
                .header("Rest-Token", "wrong_token")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
}

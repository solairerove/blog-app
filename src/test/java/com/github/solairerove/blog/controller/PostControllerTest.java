package com.github.solairerove.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.repository.common.EntityUtils;
import com.github.solairerove.blog.service.PostService;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by vlad on 16.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class PostControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private PostService postService;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
    }

    @Test
    public void findAllPosts() throws Exception {
        postService.deleteAllPosts();
        postService.save(new Post("test title", "test subtitle", "test content", "test date", "test author"));
        postService.save(new Post("another test title", "another test subtitle", "another test content", "" +
                "another test date", "another test author"));

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].title", is("test title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].subtitle", is("test subtitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].content", is("test content")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].date", is("test date")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].author", is("test author")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].title", is("another test title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].subtitle", is("another test subtitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].content", is("another test content")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].date", is("another test date")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].author", is("another test author")));
    }

    @Test
    public void getOnePostById() throws Exception {
        postService.deleteAllPosts();
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/posts/" + saved.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", is(saved.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subtitle", is(saved.getSubtitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", is(saved.getContent())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date", is(saved.getDate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", is(saved.getAuthor())));
    }

    @Test
    public void addNewPost() throws Exception {
        postService.deleteAllPosts();
        Post saved = EntityUtils.generatePost();
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/posts")
                .content(objectMapper.writeValueAsString(saved))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}

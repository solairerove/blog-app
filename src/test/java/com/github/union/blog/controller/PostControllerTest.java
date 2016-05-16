package com.github.union.blog.controller;

import com.github.union.blog.Application;
import com.github.union.blog.domain.Post;
import com.github.union.blog.service.PostService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
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
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class PostControllerTest {
    private final static Logger LOGGER = Logger.getLogger(PostController.class);

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    PostController postController;

    @Autowired
    PostService postService;

    @Before
    public void setup() throws Exception{
        this.mvc =  webAppContextSetup(context).build();
        LOGGER.info("********* SETTING UP SUCCESSFUL *********");
    }

    @Test
    public void findAllPosts() throws Exception{
        postService.deleteAllPosts();
        postService.save(new Post("test title","test subtitle","test content","test date","test author"));
        postService.save(new Post("another test title","another test subtitle","another test content","" +
                "another test date","another test author"));

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/api/post/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title",  is("test title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subtitle", is("test subtitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", is("test content")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date", is("test date")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author", is("test author")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title",  is("another test title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].subtitle", is("another test subtitle")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].content", is("another test content")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].date", is("another test date")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].author", is("another test author")));
    }

}

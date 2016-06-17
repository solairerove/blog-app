package com.github.solairerove.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.dto.CommentDTO;
import com.github.solairerove.blog.repository.common.EntityUtils;
import com.github.solairerove.blog.service.CommentService;
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
 * Created by vlad on 13.06.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class CommentControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CommentService service;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
    }

    @Test
    public void getAllComentsTest() throws Exception {
        Comment comment = EntityUtils.generateComment();
        Comment anotherComment = EntityUtils.generateComment();
        service.save(comment);
        service.save(anotherComment);

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/comments")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(comment.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].author", is(comment.getAuthor())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].review", is(comment.getReview())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].date", is(comment.getDate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id", is(anotherComment.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].author", is(anotherComment.getAuthor())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].review", is(anotherComment.getReview())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].date", is(anotherComment.getDate())));
    }

    @Test
    public void getCommentByIdTest() throws Exception {
        Comment comment = EntityUtils.generateComment();
        service.save(comment);

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/comments/" + comment.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(comment.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", is(comment.getAuthor())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.review", is(comment.getReview())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date", is(comment.getDate())));
    }

    @Test
    public void updateReviewByIdTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Comment comment = EntityUtils.generateComment();
        service.save(comment);

        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setReview("review");

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.PUT, "/api/comments")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(comment.getId().toString()));
    }

    @Test
    public void deleteCommentByIdTest() throws Exception {
        Comment comment = EntityUtils.generateComment();
        service.save(comment);

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.DELETE, "/api/comments/" + comment.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(comment.getId().toString()));
    }
}

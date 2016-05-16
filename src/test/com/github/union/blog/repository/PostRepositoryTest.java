package com.github.union.blog.repository;

import com.github.union.blog.domain.Post;
import com.github.union.blog.service.PostService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vlad on 16.05.16.
 */
public class PostRepositoryTest {
    private final static Logger LOGGER = Logger.getLogger(PostRepository.class);

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;

    @Before
    public void setUp(){
        LOGGER.info("********* SETTING UP SUCCESSFUL *********");
        postService.save(new Post("test title","test subtitle","test content","test date","test author"));
    }

    @After
    public void down(){
        LOGGER.info("********* SETTING DOWN SUCCESSFUL *********");
    }

    @Test
    public void findOneByPostIdTest(){
        LOGGER.info("********* FINDING BY POST ID TEST *********");

    }

}

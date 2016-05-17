package com.github.union.blog.repository;

import com.github.union.blog.Application;
import com.github.union.blog.domain.Post;
import com.github.union.blog.repository.common.EntityUtils;
import com.github.union.blog.service.PostService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vlad on 16.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class PostRepositoryTest {
    private final static Logger LOGGER = Logger.getLogger(PostRepository.class);

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;

    @Before
    public void setUp(){
        postService.save(EntityUtils.generatePost());
        LOGGER.info("********* SETTING UP SUCCESSFUL *********");
    }

    @Test
    public void findOneByPostIdTest(){
        LOGGER.info("********* FINDING BY POST ID TEST *********");
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        Post found = postRepository.findOnePostById(saved.getId());

        Assert.assertEquals(saved,found);
    }

    @Test
    public void updateContentByIdTest(){
        LOGGER.info("********* UPDATING POST CONTENT BY ID TEST *********");
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        postRepository.updateContentById("test content",saved.getId());

        Post found = postRepository.findOnePostById(saved.getId());
        Assert.assertEquals("test content",found.getContent());
    }
}

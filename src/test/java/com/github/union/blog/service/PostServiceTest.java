package com.github.union.blog.service;

import com.github.union.blog.Application;
import com.github.union.blog.domain.Post;
import com.github.union.blog.repository.PostRepository;
import com.github.union.blog.repository.common.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vlad on 16.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class PostServiceTest {
    private final static Logger LOGGER = Logger.getLogger(PostRepository.class);

    @Autowired
    PostService postService;

    @Test
    public void findAllTest(){
        LOGGER.info("********* FINDING ALL POSTS TEST *********");
        List<Post> saved = new LinkedList<>();
        saved.add(EntityUtils.generatePost());
        saved.add(EntityUtils.generatePost());
        postService.deleteAllPosts();
        postService.save(saved.get(0));
        postService.save(saved.get(1));

        List<Post> found = postService.findAll();
        Assert.assertTrue(saved.containsAll(found) && found.containsAll(saved));
    }

    @Test
    public void findOnePostByIdTest(){
        LOGGER.info("********* FIND ONE POST BY ID TEST *********");
        Post saved = EntityUtils.generatePost();
        postService.deleteAllPosts();
        postService.save(saved);

        Assert.assertEquals(postService.findOnePostById(saved.getId()),saved);
    }

    @Test
    public void saveTest(){
        LOGGER.info("********* SAVE POST TEST *********");
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        Assert.assertEquals(postService.findOnePostById(saved.getId()),saved);
    }

    @Test
    public void deletePostByIdTest(){
        LOGGER.info("********* DELETE POST BY ID TEST *********");
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        postService.deletePostById(saved.getId());
        Assert.assertEquals(postService.findOnePostById(saved.getId()), null);
    }




}

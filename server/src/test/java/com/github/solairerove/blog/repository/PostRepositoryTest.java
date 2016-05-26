package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.service.PostService;
import com.github.solairerove.blog.repository.common.EntityUtils;
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
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Before
    public void setUp() {
        postService.save(EntityUtils.generatePost());
    }

    @Test
    public void findOneByPostIdTest() {
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        Post found = postRepository.findOnePostById(saved.getId());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void updateContentByIdTest() {
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        postRepository.updateContentById("test content", saved.getId());

        Post found = postRepository.findOnePostById(saved.getId());
        Assert.assertEquals("test content", found.getContent());
    }
}

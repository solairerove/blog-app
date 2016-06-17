package com.github.solairerove.blog.service;

import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.dto.PostDTO;
import com.github.solairerove.blog.repository.common.EntityUtils;
import org.junit.Assert;
import org.junit.Ignore;
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

    @Autowired
    private PostService postService;

    @Test
    public void findAllTest() {
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
    public void saveTest() {
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        Assert.assertEquals(postService.findOnePostById(saved.getId()), saved);
    }

    @Test
    public void deletePostByIdTest() {
        Post saved = EntityUtils.generatePost();
        postService.save(saved);

        postService.deletePostById(saved.getId());
        Assert.assertEquals(postService.findOnePostById(saved.getId()), null);
    }

    // TODO remove the 5L out of here
    @Test
    @Ignore
    public void updateContentByIdTest() {
        postService.deleteAllPosts();
        Post saved = EntityUtils.generatePost();

        postService.save(saved);

        PostDTO updated = EntityUtils.generatePostDTO();
        updated.setId(5L);
        updated.setContent("test");


        postService.updateContentById(updated);
        Assert.assertEquals("test", postService.findOnePostById(5L).getContent());
    }


    @Test
    public void deleteAllPostsTest() {
        postService.save(EntityUtils.generatePost());
        postService.deleteAllPosts();

        Assert.assertTrue((postService.findAll()).isEmpty());
    }
}

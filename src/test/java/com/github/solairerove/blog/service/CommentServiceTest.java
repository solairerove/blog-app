package com.github.solairerove.blog.service;

import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.repository.common.EntityUtils;
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
 * Created by vlad on 10.06.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @Test
    public void findCommentByIdTest(){
        Comment saved = new Comment("test author","test review","test date");
        commentService.save(saved);

        Assert.assertEquals(commentService.findOneCommentById(saved.getId()),saved);
    }

    @Test
    public void findAllTest() {
        List<Comment> saved = new LinkedList<>();
        saved.add(EntityUtils.generateComment());
        saved.add(EntityUtils.generateComment());
        commentService.save(saved.get(0));
        commentService.save(saved.get(1));

        List<Comment> found = commentService.findAll();
        Assert.assertTrue(saved.containsAll(found) && found.containsAll(saved));
    }

    @Test
    public void findAllCommentsFromPostByIdTest() {
        Comment saved1 = EntityUtils.generateComment();
        Comment saved2 = EntityUtils.generateComment();

        commentService.addNewCommentToPost(0L,saved1);
        commentService.addNewCommentToPost(0L,saved2);

        List<Comment> saved = new LinkedList<>();
        saved.add(saved1);
        saved.add(saved2);

        List<Comment> found = commentService.findAllCommentsFromPostById(0L);
        Assert.assertTrue(saved.containsAll(found) && found.containsAll(saved));
    }
//
//    @Test
//    public void deletePostByIdTest() {
//        Post saved = EntityUtils.generatePost();
//        postService.save(saved);
//
//        postService.deletePostById(saved.getId());
//        Assert.assertEquals(postService.findOnePostById(saved.getId()), null);
//    }
//
//    @Test
//    public void deleteAllPostsTest() {
//        postService.save(EntityUtils.generatePost());
//        postService.deleteAllPosts();
//
//        Assert.assertTrue((postService.findAll()).isEmpty());
//    }
}

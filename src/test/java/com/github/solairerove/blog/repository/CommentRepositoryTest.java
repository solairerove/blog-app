package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 14.06.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void findCommentByIdTest() {
        Comment saved = new Comment("tony", "iron man", "06.06.1976");
        repository.save(saved);

        Comment found = repository.findOneCommentById(saved.getId());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllCommentsFromPostById() {
        Comment saved = new Comment("tony", "iron man", "06.06.1976");
        saved.setPostId(1L);
        repository.save(saved);

        Comment anotherSaved = new Comment("james", "war machine", "07.07.1977");
        anotherSaved.setPostId(1L);
        repository.save(anotherSaved);

        List<Comment> expected = new ArrayList<>();
        expected.add(saved);
        expected.add(anotherSaved);

        Assert.assertEquals(expected, repository.findAllCommentsFromPostById(1L));
    }

}

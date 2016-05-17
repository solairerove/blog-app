package com.github.union.blog.service;

import com.github.union.blog.domain.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by union on 16.05.16.
 */

@Component
public interface CommentService {

    void save(Comment comment);

    void addNewCommentToPost(Integer id, Comment comment);

    List<Comment> findAllCommentsFromPostById(Integer id);
}

package com.github.union.blog.service;

import com.github.union.blog.domain.Comment;
import com.github.union.blog.dto.CommentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by union on 16.05.16.
 */

@Component
public interface CommentService {

    List<Comment> findAll();

    Comment findOneCommentById(Integer id);

    void save(Comment comment);

    void addNewCommentToPost(Integer id, Comment comment);

    List<Comment> findAllCommentsFromPostById(Integer id);

    void updateReviewById(CommentDTO commentDTO);
}

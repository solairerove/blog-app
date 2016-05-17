package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Comment;
import com.github.union.blog.dto.CommentDTO;
import com.github.union.blog.repository.CommentRepository;
import com.github.union.blog.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by union on 16.05.16.
 */

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private static final Logger LOGGER = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        LOGGER.info("Find all comments");
        return commentRepository.findAll();
    }

    @Override
    public Comment findOneCommentById(Integer id) {
        LOGGER.info("Find one comment by id: " + id);
        return commentRepository.findOneCommentById(id);
    }

    @Override
    public void save(Comment comment) {
        LOGGER.info("Save entity:" + comment.toString());
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Integer id) {
        LOGGER.info("Delete entity by id: " + id);
        commentRepository.delete(id);
    }

    @Override
    public void addNewCommentToPost(Integer id, Comment comment) {
        LOGGER.info("Add new comment: " + comment + "to post: " + id);
        comment.setPostId(id);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllCommentsFromPostById(Integer id) {
        LOGGER.info("Find all comment from post by id: " + id);
        return commentRepository.findAllCommentsFromPostById(id);
    }

    @Override
    public void updateReviewById(CommentDTO commentDTO) {
        LOGGER.info("Updating comment review with id: " + commentDTO.getId());
        commentRepository.updateReviewById(commentDTO.getReview(), commentDTO.getId());
    }
}

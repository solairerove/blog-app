package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Comment;
import com.github.union.blog.dto.CommentDTO;
import com.github.union.blog.repository.CommentRepository;
import com.github.union.blog.service.CommentService;
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

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findOneCommentById(Integer id) {
        return commentRepository.findOneCommentById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepository.delete(id);
    }

    @Override
    public void addNewCommentToPost(Integer id, Comment comment) {
        comment.setPostId(id);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllCommentsFromPostById(Integer id) {
        return commentRepository.findAllCommentsFromPostById(id);
    }

    @Override
    public void updateReviewById(CommentDTO commentDTO) {
        commentRepository.updateReviewById(commentDTO.getReview(), commentDTO.getId());
    }
}

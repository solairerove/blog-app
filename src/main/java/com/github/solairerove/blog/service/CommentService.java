package com.github.solairerove.blog.service;

import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.dto.CommentDTO;
import com.github.solairerove.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by union on 16.05.16.
 */
@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment findOneCommentById(Long id) {
        return commentRepository.findOneCommentById(id);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllCommentsFromPostById(Long id) {
        return commentRepository.findAllCommentsFromPostById(id);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.delete(id);
    }

    public void addNewCommentToPost(Long id, Comment comment) {
        comment.setPostId(id);
        commentRepository.save(comment);
    }

    public void updateReviewById(CommentDTO commentDTO) {
        commentRepository.updateReviewById(commentDTO.getReview(), commentDTO.getId());
    }
}

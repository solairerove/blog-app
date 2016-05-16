package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Comment;
import com.github.union.blog.repository.CommentRepository;
import com.github.union.blog.repository.PostRepository;
import com.github.union.blog.service.ManagerPostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by union on 16.05.16.
 */

@Transactional
@Service
public class ManagerPostServiceImpl implements ManagerPostService {
    private Logger logger = Logger.getLogger(ManagerPostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addNewCommentToPost(Integer id, Comment comment) {
        logger.info("add new comment: " + comment + "to post: " + id);
        comment.setPostId(id);
        commentRepository.save(comment);
    }
}

package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Comment;
import com.github.union.blog.repository.CommentRepository;
import com.github.union.blog.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by union on 16.05.16.
 */

@Transactional
@Service
public class CommentServiceImpl implements CommentService {
    private Logger logger = Logger.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        logger.info("Save entity:" + comment.toString());
        commentRepository.save(comment);
    }
}

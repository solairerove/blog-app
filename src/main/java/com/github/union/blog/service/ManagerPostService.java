package com.github.union.blog.service;

import com.github.union.blog.domain.Comment;
import org.springframework.stereotype.Component;

/**
 * Created by union on 16.05.16.
 */

@Component
public interface ManagerPostService {

    void addNewCommentToPost(Integer id, Comment comment);
}

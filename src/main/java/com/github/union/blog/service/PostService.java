package com.github.union.blog.service;

import com.github.union.blog.domain.Post;

import java.util.List;

/**
 * Created by union on 7/05/16.
 */

public interface PostService {

    void save(Post post);

    Post findOnePostById(Integer id);

    List<Post> findAll();
}
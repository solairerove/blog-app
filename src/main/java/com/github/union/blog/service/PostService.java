package com.github.union.blog.service;

import com.github.union.blog.domain.Post;

import java.util.List;

/**
 * Created by union on 7/05/16.
 */

public interface PostService {

    List<Post> findAll();

    Post findOnePostById(Integer id);

    void save(Post post);

    void deletePostById(Integer id);

    void updateContentById(String content,Integer id);
}

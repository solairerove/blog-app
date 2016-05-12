package com.github.union.blog.service;

import com.github.union.blog.domain.Post;
import com.github.union.blog.dto.PostDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by union on 7/05/16.
 */

@Component
public interface PostService {

    List<Post> findAll();

    Post findOnePostById(Integer id);

    void save(Post post);

    void deletePostById(Integer id);

    void updateContentById(PostDTO postDTO);
}

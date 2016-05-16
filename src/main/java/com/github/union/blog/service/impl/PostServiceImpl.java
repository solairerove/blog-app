package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Post;
import com.github.union.blog.dto.PostDTO;
import com.github.union.blog.repository.PostRepository;
import com.github.union.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by union on 7/05/16.
 */

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findOnePostById(Integer id) {
        return postRepository.findOnePostById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Integer id) {
        postRepository.delete(id);
    }

    @Override
    public void updateContentById(PostDTO postDTO){
        postRepository.updateContentById(postDTO.getContent(), postDTO.getId());
    }
}

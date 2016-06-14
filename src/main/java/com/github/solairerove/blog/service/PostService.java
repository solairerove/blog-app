package com.github.solairerove.blog.service;

import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.dto.PostDTO;
import com.github.solairerove.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by union on 7/05/16.
 */
@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findOnePostById(Long id) {
        return postRepository.findOnePostById(id);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deletePostById(Long id) {
        postRepository.delete(id);
    }

    public void updateContentById(PostDTO postDTO) {
        postRepository.updateContentById(postDTO.getContent(), postDTO.getId());
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }
}

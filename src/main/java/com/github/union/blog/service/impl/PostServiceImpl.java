package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Post;
import com.github.union.blog.repository.PostRepository;
import com.github.union.blog.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by union on 7/05/16.
 */

@Service
public class PostServiceImpl implements PostService {
    private Logger logger = Logger.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        logger.info("Find all posts");
        return postRepository.findAll();
    }

    @Override
    public Post findOnePostById(Integer id) {
        logger.info("Find one post by id: " + id);
        return postRepository.findOnePostById(id);
    }

    @Override
    public void save(Post post) {
        logger.info("Save entity:" + post.toString());
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Integer id) {
        logger.info("Delete entity by id: " + id);
        postRepository.delete(id);
    }

    //TODO апдейт ёбана
    @Override
    public void updateContentById(String content, Integer id){
        logger.info("Updating post content with id:" + id);
        postRepository.updateContentById(content,id);
    }
}
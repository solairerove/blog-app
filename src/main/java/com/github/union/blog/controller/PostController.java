package com.github.union.blog.controller;

import com.github.union.blog.domain.Post;
import com.github.union.blog.dto.PostDTO;
import com.github.union.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by union on 7/05/16.
 */

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getOnePostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.findOnePostById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> addNewPost(@RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setSubtitle(postDTO.getSubtitle());
        post.setContent(postDTO.getContent());
        post.setDate(LocalDate.now().toString());
        post.setAuthor(postDTO.getAuthor());
        postService.save(post);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePostById(@PathVariable Integer id) {
        postService.deletePostById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateContentById(@RequestBody PostDTO postDTO){
        postService.updateContentById(postDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/clear",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllPosts(){
        postService.deleteAllPosts();
        return ResponseEntity.ok(HttpStatus.OK);
    }

}

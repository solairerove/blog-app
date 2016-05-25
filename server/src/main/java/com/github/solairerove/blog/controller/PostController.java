package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.dto.CommentDTO;
import com.github.solairerove.blog.dto.PostDTO;
import com.github.solairerove.blog.service.CommentService;
import com.github.solairerove.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by union on 7/05/16.
 */

@Component
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("")
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getOnePostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.findOnePostById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
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

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<?> updateContentById(@RequestBody PostDTO postDTO) {
        postService.updateContentById(postDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllPosts() {
        postService.deleteAllPosts();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    public ResponseEntity<?> addNewCommentToPost(@PathVariable Integer id, @RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setAuthor(commentDTO.getAuthor());
        comment.setReview(commentDTO.getReview());
        comment.setDate(commentDTO.getDate());
        commentService.save(comment);

        commentService.addNewCommentToPost(id, comment);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/comment")
    public ResponseEntity<?> getAllCommentsFromPost(@PathVariable Integer id) {
        return ResponseEntity.ok(commentService.findAllCommentsFromPostById(id));
    }
}

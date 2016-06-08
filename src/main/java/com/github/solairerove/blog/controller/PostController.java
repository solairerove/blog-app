package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.dto.CommentDTO;
import com.github.solairerove.blog.dto.PostDTO;
import com.github.solairerove.blog.service.CommentService;
import com.github.solairerove.blog.service.PostService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Api
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "Get all posts", notes = "This can be done by all users.", position = 1)
    @ApiResponse(code = 200, message = "Ok")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get post by id", notes = "This can be done by all users.", position = 2, response = Post.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Post not found")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOnePostById(
            @ApiParam(value = "Post id", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(postService.findOnePostById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Add new post", notes = "By authenticated users only.", position = 3)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewPost(
            @ApiParam(value = "Created post object", required = true) @RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setSubtitle(postDTO.getSubtitle());
        post.setContent(postDTO.getContent());
        post.setDate(LocalDate.now().toString());
        post.setAuthor(postDTO.getAuthor());
        postService.save(post);
        return new ResponseEntity<>(postDTO.getTitle(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete post by id", notes = "By authenticated users only.", position = 4)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePostById(
            @ApiParam(value = "Post id", required = true) @PathVariable Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @ApiOperation(value = "Update post by id", notes = "By authenticated users only.", position = 5)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateContentById(
            @ApiParam(value = "Updated post object", required = true) @RequestBody PostDTO postDTO) {
        postService.updateContentById(postDTO);
        return new ResponseEntity<>(postDTO.getId(), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete all posts", notes = "By authenticated users only.", position = 6)
    @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllPosts() {
        postService.deleteAllPosts();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Add new comment to post", notes = "By authenticated users only.", position = 7)
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addNewCommentToPost(
            @ApiParam(value = "Post id", required = true) @PathVariable Long id,
            @ApiParam(value = "Created comment object", required = true) @RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setAuthor(commentDTO.getAuthor());
        comment.setReview(commentDTO.getReview());
        comment.setDate(LocalDate.now().toString());
        commentService.save(comment);

        commentService.addNewCommentToPost(id, comment);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all comments from post by id", notes = "By authenticated users only.", position = 8)
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCommentsFromPost(
            @ApiParam(value = "Post id", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(commentService.findAllCommentsFromPostById(id), HttpStatus.OK);
    }
}

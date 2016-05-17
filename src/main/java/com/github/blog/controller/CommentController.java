package com.github.blog.controller;

import com.github.blog.dto.CommentDTO;
import com.github.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by union on 17.05.16.
 */

@Component
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/")
    public ResponseEntity<?> getAllComments() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> getOneCommentById(@PathVariable Integer id) {
        return ResponseEntity.ok(commentService.findOneCommentById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateReviewById(@RequestBody CommentDTO commentDTO) {
        commentService.updateReviewById(commentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommentById(@PathVariable Integer id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

package com.github.union.blog.controller;

import com.github.union.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

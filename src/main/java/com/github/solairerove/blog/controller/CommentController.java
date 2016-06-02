package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.dto.CommentDTO;
import com.github.solairerove.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
//TODO swagger io annotations fo doc
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllComments() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneCommentById(@PathVariable Integer id) {
        return new ResponseEntity<>(commentService.findOneCommentById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateReviewById(@RequestBody CommentDTO commentDTO) {
        commentService.updateReviewById(commentDTO);
        return new ResponseEntity<>(commentDTO.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommentById(@PathVariable Integer id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

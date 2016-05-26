package com.github.solairerove.blog.controller;

import com.github.solairerove.blog.domain.Comment;
import com.github.solairerove.blog.domain.Post;
import com.github.solairerove.blog.dto.CommentDTO;
import com.github.solairerove.blog.dto.PostDTO;
import com.github.solairerove.blog.repository.PostRepository;
import com.github.solairerove.blog.service.CommentService;
import com.github.solairerove.blog.service.PostService;
import com.github.solairerove.blog.web.PageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Component
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    @ResponseBody
    public PageResource<Post> postPageResource(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size, new Sort("id"));

        Page<Post> pageResult = postRepository.findAll(pageable);
        return new PageResource<>(pageResult, "page", "size");
    }

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOnePostById(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.findOnePostById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewPost(@RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setSubtitle(postDTO.getSubtitle());
        post.setContent(postDTO.getContent());
        post.setDate(LocalDate.now().toString());
        post.setAuthor(postDTO.getAuthor());
        postService.save(post);
        return new ResponseEntity<>(postDTO.getTitle(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePostById(@PathVariable Integer id) {
        postService.deletePostById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateContentById(@RequestBody PostDTO postDTO) {
        postService.updateContentById(postDTO);
        return new ResponseEntity<>(postDTO.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllPosts() {
        postService.deleteAllPosts();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST)
    public ResponseEntity<?> addNewCommentToPost(@PathVariable Integer id, @RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setAuthor(commentDTO.getAuthor());
        comment.setReview(commentDTO.getReview());
        comment.setDate(commentDTO.getDate());
        commentService.save(comment);

        commentService.addNewCommentToPost(id, comment);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCommentsFromPost(@PathVariable Integer id) {
        return new ResponseEntity<>(commentService.findAllCommentsFromPostById(id), HttpStatus.OK);
    }
}

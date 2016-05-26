package com.github.solairerove.blog.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {
    private Integer id;
    private String author;
    private String review;
    private String date;
    private Integer postId;

    public CommentDTO() {
    }

    public CommentDTO(Integer id, String author, String review, String date, Integer postId) {
        this.id = id;
        this.author = author;
        this.review = review;
        this.date = date;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "postId=" + postId +
                ", date='" + date + '\'' +
                ", review='" + review + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                '}';
    }
}

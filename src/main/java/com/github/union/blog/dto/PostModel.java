package com.github.union.blog.dto;

/**
 * Created by union on 7/05/16.
 */

public class PostModel {

    private String title;
    private String subtitle;
    private String content;
    private String author;

    public PostModel() {
        super();
        // default constructor
    }

    public PostModel(String title, String subtitle, String content, String author) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

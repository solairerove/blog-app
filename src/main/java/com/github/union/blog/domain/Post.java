package com.github.union.blog.domain;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

/**
 * Created by union on 7/05/16.
 */

@Entity
public class Post implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String subtitle;
    private String content;
    private String date;
    private String author;

    public Post() {
    }

    public Post(String title, String subtitle, String content, String date, String author) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Modifying
    public String getContent() {
        return content;
    }

    @Modifying
    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}


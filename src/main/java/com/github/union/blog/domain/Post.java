package com.github.union.blog.domain;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by union on 7/05/16.
 */

@Entity
//@Table(name = "post")
public class Post implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String content;
    private LocalDate date;
    private String author;

    public Post() {
        super();
        // default entity constructor
    }

    public Post(String name, String description, String content, LocalDate date, String author) {
        super();
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                '}';
    }
}

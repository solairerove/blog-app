package com.github.union.blog.repository;

import com.github.union.blog.domain.Post;
import com.github.union.blog.dto.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by union on 7/05/16.
 */

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT p FROM Post p WHERE p.id = ?1")
    Post findOnePostById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Post p SET p.content = ?1 WHERE p.id = ?2")
    void updateContentById(String content,Integer id);
}
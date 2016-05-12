package com.github.union.blog.repository;

import com.github.union.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by union on 7/05/16.
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT p FROM Post p WHERE p.id = ?1")
    Post findOnePostById(Integer id);

    @Modifying
    @Query(value = "UPDATE Post p SET p.content = ?1 WHERE p.id = ?2")
    void updateContentById(String content,Integer id);
}

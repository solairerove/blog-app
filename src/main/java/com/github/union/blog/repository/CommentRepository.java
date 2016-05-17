package com.github.union.blog.repository;

import com.github.union.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by union on 16.05.16.
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT c FROM Comment c WHERE c.postId = ?1")
    List<Comment> findAllCommentsFromPostById(Integer id);
}

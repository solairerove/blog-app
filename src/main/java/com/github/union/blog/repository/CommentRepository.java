package com.github.union.blog.repository;

import com.github.union.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by union on 16.05.16.
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}

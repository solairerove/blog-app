package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//TODO create some getIdByTitleAndSubtitle
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT p FROM Post p WHERE p.id = ?1")
    Post findOnePostById(Long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Post p SET p.content = ?1 WHERE p.id = ?2")
    void updateContentById(String content, Long id);

    @Modifying
    @Query(value = "DELETE FROM Post p WHERE p.id = ?1")
    void delete(Long id);
}

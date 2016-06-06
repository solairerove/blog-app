package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 22.05.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(Long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE User u SET u.nickname = ?1 WHERE u.id = ?2")
    void changeUserNickname(String nickname, Long id);

    @Query(value = "SELECT u FROM User u WHERE u.nickname = ?1")
    User findUserByNickname(String nickname);

    @Query(value = "SELECT u FROM User u WHERE u.login = ?1")
    User findUserByLogin(String login);
}

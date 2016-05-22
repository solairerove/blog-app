package com.github.union.blog.repository;

import com.github.union.blog.domain.Role;
import com.github.union.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vlad on 22.05.16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(Integer id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE User u SET u.nickname = ?1 WHERE u.id = ?2")
    void changeUserNickname(String nickname, Integer id);

    @Query(value = "SELECT u FROM User u WHERE u.nickname = ?1")
    User findUserByNickname(String nickname);

    @Query(value = "DELETE FROM User WHERE id = ?1")
    void deleteUserById(Integer id);

}

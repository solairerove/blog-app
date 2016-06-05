package com.github.solairerove.blog.service;

import com.github.solairerove.blog.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by union on 5/06/16.
 */
@Component
public interface UserService {

    void save(User user);

    User findUserById(Long id);

    void changeUserNickname(String nickname, Long id);

    User findUserByNickname(String nickname);

    User findUserByLogin(String login);

    void deleteUserById(Integer id);
}

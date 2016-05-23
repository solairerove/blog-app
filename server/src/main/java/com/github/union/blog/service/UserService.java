package com.github.union.blog.service;

import com.github.union.blog.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by vlad on 23.05.16.
 */
@Component
public interface UserService {

    void save(User user);

    User findUserById(Integer id);

    void changeUserNickname(String nickname, Integer id);

    User findUserByNickname(String nickname);

    void deleteUserById(Integer id);

}

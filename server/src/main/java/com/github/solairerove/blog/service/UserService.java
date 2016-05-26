package com.github.solairerove.blog.service;

import com.github.solairerove.blog.domain.User;
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

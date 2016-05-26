package com.github.solairerove.blog.service;

import com.github.solairerove.blog.domain.User;
import com.github.solairerove.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vlad on 23.05.16.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public void changeUserNickname(String nickname, Integer id) {
        userRepository.changeUserNickname(nickname, id);
    }

    public User findUserByNickname(String nickname) {
        return userRepository.findUserByNickname(nickname);
    }

    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }
}

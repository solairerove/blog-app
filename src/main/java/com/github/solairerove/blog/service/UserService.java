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

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public void changeUserNickname(String nickname, Long id) {
        userRepository.changeUserNickname(nickname, id);
    }

    public User findUserByNickname(String nickname) {
        return userRepository.findUserByNickname(nickname);
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByNickname(login);
    }

    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }
}

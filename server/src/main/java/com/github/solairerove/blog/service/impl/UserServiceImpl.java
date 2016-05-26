package com.github.solairerove.blog.service.impl;

import com.github.solairerove.blog.domain.User;
import com.github.solairerove.blog.repository.UserRepository;
import com.github.solairerove.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vlad on 23.05.16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void changeUserNickname(String nickname, Integer id) {
        userRepository.changeUserNickname(nickname, id);
    }

    @Override
    public User findUserByNickname(String nickname) {
        return userRepository.findUserByNickname(nickname);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }
}

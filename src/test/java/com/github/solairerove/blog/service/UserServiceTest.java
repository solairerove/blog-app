//package com.github.solairerove.blog.service;
//
//import com.github.solairerove.blog.Application;
//import com.github.solairerove.blog.domain.Authority;
//import com.github.solairerove.blog.domain.User;
//import com.github.solairerove.blog.service.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Created by vlad on 23.05.16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@Transactional
//@SpringApplicationConfiguration(Application.class)
//public class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void saveTest() {
//        List<Authority> authorities = new LinkedList<>();
//        authorities.add(new Authority("ADMIN"));
//        User saved = new User("stark", "iron@gmail.com", "iron_man_1", "strongpwd", authorities);
//
//        userService.save(saved);
//        Assert.assertEquals(userService.findUserById(saved.getId()), saved);
//    }
//
//    @Test
//    public void changeUserNicknameTest() {
//        List<Authority> authorities = new LinkedList<>();
//        authorities.add(new Authority("ADMIN"));
//        User saved = new User("stark", "iron@gmail.com", "iron_man_1", "strongpwd", authorities);
//        userService.save(saved);
//
//        userService.changeUserNickname("tony", saved.getId());
//
//        Assert.assertEquals("tony", userService.findUserById(saved.getId()).getNickname());
//    }
//
//    @Test
//    public void findUserByNicknameTest() {
//        List<Authority> authorities = new LinkedList<>();
//        authorities.add(new Authority("ADMIN"));
//        User saved = new User("stark", "iron@gmail.com", "iron_man_1", "strongpwd", authorities);
//        userService.save(saved);
//
//        User found = userService.findUserByNickname(saved.getNickname());
//
//        Assert.assertEquals(saved, found);
//    }
//}

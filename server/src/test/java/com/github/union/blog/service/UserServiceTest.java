package com.github.union.blog.service;

import com.github.union.blog.Application;
import com.github.union.blog.domain.Role;
import com.github.union.blog.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vlad on 23.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ADMIN"));
        User saved = new User("stark", "tony_stark", "iron_man_1", roles);

        userService.save(saved);
        Assert.assertEquals(userService.findUserById(saved.getId()), saved);
    }

    @Test
    public void changeUserNicknameTest() {
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ADMIN"));
        User saved = new User("stark", "tony_stark", "iron_man_1", roles);
        userService.save(saved);

        userService.changeUserNickname("tony", saved.getId());

        Assert.assertEquals("tony", userService.findUserById(saved.getId()).getNickname());
    }

    @Test
    public void findUserByNicknameTest() {
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ADMIN"));
        User saved = new User("tony", "tony_stark", "iron_man_1", roles);
        userService.save(saved);

        User found = userService.findUserByNickname(saved.getNickname());

        Assert.assertEquals(saved, found);
    }
}

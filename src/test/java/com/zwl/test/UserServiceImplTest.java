package com.zwl.test;

import com.zwl.pojo.User;
import com.zwl.service.UserService;
import com.zwl.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {

        userService.registUser(new User(null,"Kate","123456","Kate@123.com" ));

    }

    @Test
    public void login() {

        System.out.println(userService.login(new User(null, "admin", "admin", "admin@123.com")));

    }

    @Test
    public void existsUsername() {

        System.out.println(userService.existsUsername("Tom"));

    }
}
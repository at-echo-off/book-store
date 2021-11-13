package com.zwl.test;

import com.zwl.dao.impl.UserDaoImpl;
import com.zwl.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        System.out.println(userDaoImpl.queryUserByUsername("admin"));

    }

    @Test
    public void queryUserByUsernameAndPassword() {

        System.out.println(userDaoImpl.queryUserByUsernameAndPassword("admin", "admin"));

    }

    @Test
    public void saveUser() {

        User tom = new User(null, "Tom", "123456", "Tom@123.com");

        System.out.println(userDaoImpl.saveUser(tom));

    }
}
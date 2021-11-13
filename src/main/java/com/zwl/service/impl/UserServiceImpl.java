package com.zwl.service.impl;

import com.zwl.dao.impl.UserDaoImpl;
import com.zwl.pojo.User;
import com.zwl.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {

        userDao.saveUser(user);

    }

    @Override
    public User login(User user) {

        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {

        return userDao.queryUserByUsername(username) != null;

    }
}

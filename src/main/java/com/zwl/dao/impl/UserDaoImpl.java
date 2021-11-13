package com.zwl.dao.impl;

import com.zwl.dao.BaseDao;
import com.zwl.dao.UserDao;
import com.zwl.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {

        String sql =
                "select `id`,`username`,`password`,`email` " +
                "from t_user " +
                "where `username` = ?";

        return (User) queryForOne(sql,User.class,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {

        String sql =
                "select `id`,`username`,`password`,`email` " +
                "from t_user " +
                "where `username` = ? and password = ?";

        return (User) queryForOne(sql,User.class,username,password);
    }

    @Override
    public int saveUser(User user) {

        String sql =
                "insert into t_user(`username`,`password`,`email`) " +
                "values(?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
    }

}

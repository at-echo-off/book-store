package com.zwl.dao;

import com.zwl.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息<br/>用于用户注册
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public Object queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户对象<br/>用户用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 如果返回null，说明没有这个用户
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user 要保存的用户对象
     * @return
     */
    public int saveUser(User user);

}









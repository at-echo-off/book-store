package com.zwl.service;

import com.zwl.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user 注册的用户对象
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user 登录用户信息
     * @return 如果返回null,表示登录失败<br/>如果有返回值，这登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username 查询的用户名
     * @return 返回true表示用户名已存在，不可用<br/>返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}

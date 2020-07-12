package com.zcgroup.e_management.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.entity.User;


public interface UserService {
    /**
     * 添加一个用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 根据用户account查询User
     * @param account
     * @return
     */
    public User getUserById(String account);

    /**
     * 查询所有用户
     * @return
     */
    public Page<User> getUsers(Page page);
}

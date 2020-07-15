package com.zcgroup.e_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.entity.User;

import java.util.List;


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
    public List<User> getUsers(int current, int size);


    public Integer findAllCount() ;
}

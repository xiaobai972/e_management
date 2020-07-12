package com.zcgroup.e_management.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.entity.User;
import com.zcgroup.e_management.mapper.UserMapper;
import com.zcgroup.e_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {

        int res=-1;
        res=userMapper.insert(user);
        return res;
    }

    @Override
    public User getUserById(String account) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(User.ACCOUNT,account);
        User user=userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public Page<User> getUsers(Page pages) {
        Page<User> page=new Page<>(pages.getCurrent(),pages.getSize());
        userMapper.selectPage(page,null);
        return page;
    }
}

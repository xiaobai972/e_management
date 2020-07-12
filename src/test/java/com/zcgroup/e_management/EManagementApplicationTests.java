package com.zcgroup.e_management;

import com.zcgroup.e_management.entity.User;
import com.zcgroup.e_management.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EManagementApplicationTests {


    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
    }

    @Test
    public void addUserTest(){
        User user=new User();
        user.setAccount("15927263015");
        user.setAddress("幸福花园");
        user.setAge("18");
        user.setName("张三");
        user.setPassWord("123456");
        user.setPersonNumber("123456789");
        user.setSex("男");
        userService.addUser(user);
    }
    @Test
    public void getUserTest(){
       String account="123456";

        User user=userService.getUserById(account);
        System.out.print(user.toString());
    }


}

package com.zcgroup.e_management.controller;


import com.zcgroup.e_management.entity.User;
import com.zcgroup.e_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class UserInfo {
    @Autowired
    UserService userService;
    @RequestMapping("/Users")
    public String  getUsers(Model model){
                  List<User> users = userService.getUsers(1,10);
                   /*将list集合装换成json对象*/
                  model.addAttribute("users",users);
                  return "user";
    }
}

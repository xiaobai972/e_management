package com.zcgroup.e_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWord {
    @RequestMapping(value = "/helloword",method = RequestMethod.GET)
    public String test(){
        return "index";
    }

}

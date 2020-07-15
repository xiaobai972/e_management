package com.zcgroup.e_management.controller;

import com.zcgroup.e_management.dto.DataDto;
import com.zcgroup.e_management.entity.Data;
import com.zcgroup.e_management.service.DataService;
import com.zcgroup.e_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HealthData {
    @Autowired
    private DataService dataService;
    @RequestMapping("/HealthDatas")
    public String  getDatas(Model model){
        List<DataDto> dataDtos=dataService.getHealthDatas();
        model.addAttribute("healthDatas",dataDtos);
        return "healthData";
    }
}

package com.zcgroup.e_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zcgroup.e_management.mapper.**")
public class EManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EManagementApplication.class, args);
    }

}

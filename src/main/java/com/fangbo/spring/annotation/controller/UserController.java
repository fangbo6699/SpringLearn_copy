package com.fangbo.spring.annotation.controller;

import com.fangbo.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public void exec(){
        System.out.println("UserController exec()........./");
        userService.UserService_test();
    }
}

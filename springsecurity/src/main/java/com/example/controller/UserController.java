package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Create by Administrator on 2020/3/6.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/regist")
    public String regist(User user){
        userService.registUser(user);
        return "redirect:/index.html";
    }
}

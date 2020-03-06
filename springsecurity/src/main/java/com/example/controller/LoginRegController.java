package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by Administrator on 2020/3/5.
 */
@Controller
public class LoginRegController {

    @GetMapping("/index.html")
    public String loginPage(HttpServletRequest httpServletRequest){
        System.out.println("loginPage method =" + httpServletRequest.getMethod());
        return "index";
    }

    @GetMapping("/main")
    public String login(HttpServletRequest httpServletRequest){
        System.out.println("login method =" + httpServletRequest.getMethod());
        return "main";
    }

    @GetMapping("/regist")
    public String registPage(HttpServletRequest httpServletRequest){
        System.out.println("registPage method = "+ httpServletRequest.getMethod());
        return "regist";
    }
}

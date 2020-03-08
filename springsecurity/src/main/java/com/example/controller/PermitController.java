package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PermitController {

    @ResponseBody
    @GetMapping("/admin/main")
    public String testMain(HttpServletRequest httpServletRequest){
        System.out.println("testMain method = " + httpServletRequest.getMethod());
        return "hello";
    }

    @GetMapping("/no_permit")
    public String noPermit(HttpServletRequest httpServletRequest){
        System.out.println("noPermit method = " + httpServletRequest.getMethod());
        System.out.println("noPermit URI = " + httpServletRequest.getRequestURI());
        System.out.println("noPermit URL = " + httpServletRequest.getRequestURL());
        return "redirect:/main/no_permit";
    }

    @GetMapping("/main/no_permit")
    public String permit(HttpServletRequest httpServletRequest){
        System.out.println("permit method = " + httpServletRequest.getMethod());
        return "no_permit";
    }
}

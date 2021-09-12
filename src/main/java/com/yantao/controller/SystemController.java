package com.yantao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 *
 * @author YanTao
 * @date 2021/9/12
 * @time 21:34
 */
@Controller
public class SystemController {

    @RequestMapping("/unauthorized.html")
    @ResponseBody
    public String unauthorized(){
        return "<h2>未经授权，禁止访问！</h2>";
    }

    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(){
        return "success";
    }
}

package com.yantao.controller;

import com.yantao.pojo.User;
import com.yantao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public String login(String username, String password, Boolean rememberMe, Model model){
        rememberMe = rememberMe != null;
//        封装该用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        记住我
        token.setRememberMe(rememberMe);
        System.out.println("rememberMe==>" + rememberMe);
//        获取当前的用户
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);   // 执行登录方法 没有异常则登录成功
            return "redirect:book/all";
        }catch (UnknownAccountException e){ //用户名不存在
            model.addAttribute("msg", "User is not found!");
            return "login";
        }catch (IncorrectCredentialsException e){   // 密码错误
            model.addAttribute("msg", "Username or password is error!");
            return "login";
        }
    }

    @RequestMapping("/logout.html")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        return "login";
    }
}

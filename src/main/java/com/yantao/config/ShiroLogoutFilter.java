package com.yantao.config;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by IntelliJ IDEA.
 *
 * @author YanTao
 * @date 2021/9/13
 * @time 22:22
 */
public class ShiroLogoutFilter extends LogoutFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        //登出操作 清除缓存  subject.logout() 可以自动清理缓存信息, 这些代码是可以省略的  这里只是做个笔记 表示这种方式也可以清除
        Subject subject = getSubject(request,response);
        //登出
        subject.logout();

//        获取登出后重定向到的地址
//        String redirectUrl = getRedirectUrl(request,response,subject);
//          重定向
//        issueRedirect(request,response,redirectUrl);
//        返回false
//        return false;

        String redirectUrl="/login.html";
        System.out.println(redirectUrl);

        try {
            subject.logout();
        } catch (SessionException ise) {
            ise.printStackTrace();
        }
        issueRedirect(request, response, redirectUrl);
//        返回false表示不执行后续的过滤器，直接返回跳转到登录页面
        return false;
    }
}

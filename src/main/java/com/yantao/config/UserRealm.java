package com.yantao.config;

import com.yantao.pojo.Role;
import com.yantao.pojo.User;
import com.yantao.service.RoleService;
import com.yantao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 *
 * @author YanTao
 * @date 2021/9/12
 * @time 20:10
 */
public class UserRealm extends AuthorizingRealm {
    private UserService userService;

    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    //    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了==>授权==>doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        Role role = roleService.selectRoleById(currentUser.getRid().toString());
        authorizationInfo.addStringPermission(role.getRprems());
        return authorizationInfo;
    }

    //    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了==>认证==>doGetAuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        从数据库获取用户数据
        User user = userService.selectUserById(token.getUsername());
        if (user == null){  // user 为 null, 则该用户不存在
            return null;    // 返回null，会抛出UnknownAccountException异常
        }

//        密码认证 shiro做
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}

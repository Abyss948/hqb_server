package com.hqb.config;

import com.hqb.pojo.Admin;
import com.hqb.pojo.User;
import com.hqb.service.AdminService;
import com.hqb.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserByUserName(token.getUsername());
        Admin admin = adminService.getAdminByAdminName(token.getUsername());

        if (user == null && admin == null) {
            return null;
        }

        if (admin != null)
            return new SimpleAuthenticationInfo(admin, admin.getPassword(), "");
        else
            return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}

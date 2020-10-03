package com.hqb.controller;

import com.hqb.pojo.Admin;
import com.hqb.pojo.JsonResult;
import com.hqb.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/adminLogin")
    public JsonResult<Object> adminLogin(@RequestParam("adminname") String adminname, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(adminname, password);
        try {
            subject.login(usernamePasswordToken);
            Admin admin = adminService.getAdminByAdminName(adminname);
            return new JsonResult<>(admin.getInfo(), "管理员登陆成功");
        } catch (UnknownAccountException e) {
            return new JsonResult<>("1", "管理员用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return new JsonResult<>("2", "管理员密码错误");
        }
    }


}

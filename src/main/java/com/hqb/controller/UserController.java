package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.pojo.User;
import com.hqb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsernameByUserid")
    public JsonResult<Object> getUsernameByUserid(@RequestParam("userid") int userid) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", userService.getUsernameByUserid(userid));
        return new JsonResult<>(map, "查询成功");
    }

    @GetMapping("/register")
    public JsonResult<Object> register(@RequestParam("username") String username, @RequestParam("idnumber") String idnumber, @RequestParam("bankcard") String bankcard, @RequestParam("phone") String phone, @RequestParam("password") String password){
        User user = userService.getUserByUserName(username);
        if (user!=null){
            return new JsonResult<>("1","用户名重复");
        }
        userService.addUser(username,idnumber,bankcard,phone,password);
        return new JsonResult<>("0","注册成功");
    }

    @PostMapping("/login")
    public JsonResult<Object> login(@RequestParam("username") String username, @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.getUserByUserName(username);
            return new JsonResult<>("登陆成功");
        }catch (UnknownAccountException e){
            return new JsonResult<>("1","用户名不存在");
        }catch (IncorrectCredentialsException e){
            return new JsonResult<>("2","密码错误");
        }
    }
}
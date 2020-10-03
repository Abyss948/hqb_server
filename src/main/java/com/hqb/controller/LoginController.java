package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.pojo.User;
import com.hqb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public JsonResult<Object> register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("wechat") String wechat, @RequestParam("intro") String intro, @RequestParam("question") String question, @RequestParam("answer") String answer,@RequestParam("balance") double balance,@RequestParam("status") int status){
        User user = userService.getUserByUserName(username);
        if (user!=null){
            return new JsonResult<>("1","用户名重复");
        }
        userService.addUser(username,password,email,wechat,intro,question,answer,balance,status);
        return new JsonResult<>("0","注册成功");
    }
}

package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsernameByUserid")
    public JsonResult<Object> getUsernameByUserid(@RequestParam("userid") int userid){
        Map<String,Object> map = new HashMap<>();
        map.put("username",userService.getUsernameByUserid(userid));
        //测试
        return new JsonResult<>(map,"查询成功");
    }
}

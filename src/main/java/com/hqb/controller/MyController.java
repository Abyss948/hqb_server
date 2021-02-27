package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.AccountService;
import com.hqb.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    AccountService accountService;
    @Autowired
    MyService myService;

    @GetMapping("getMyByUserid")
    public JsonResult<Map<String, Object>> getMyByUserid(@RequestParam("userid") int userid) {
        Map<String, Object> map = new HashMap<>();

        map.put("myinfo", myService.getMyByUserid(userid));
        return new JsonResult<>(map, "success");
    }

    @PostMapping("/transferMoney")
    public JsonResult<Map<String, Object>> transferMoney(@RequestParam("code") String code) {
        Map<String, Object> map = new HashMap<>();
        code = "=" + code;
        System.out.println(code);
        map.put("code", code);
        return new JsonResult<>(map);
    }
}

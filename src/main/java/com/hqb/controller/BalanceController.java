package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.BalanceService;
import com.hqb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping("/getBalanceByUserid")
    public JsonResult<Object> getBalanceByUserid(@RequestParam("userid") int userid) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", balanceService.getBalanceByUserid(userid));
        //测试5
        return new JsonResult<>(map, "查询成功");
    }
}
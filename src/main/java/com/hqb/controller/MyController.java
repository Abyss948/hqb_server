package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.pojo.User;
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

    @PostMapping("/transferAction")
    public JsonResult<Map<String, Object>> transferAction(@RequestParam("myid") String myid,
                                                          @RequestParam("code") String code,
                                                          @RequestParam("transferMoney") String transferMoney) {
        String codeOfLast = code.substring(40);
        int loseid = Integer.parseInt(myid);
        int getid = Integer.parseInt(codeOfLast);
        if (loseid <= 0 || getid <= 0) {
            return new JsonResult<>("1", "双方信息错误！");
        }

        if(getid==loseid){
            return new JsonResult<>("3", "不可以自己给自己转账！");
        }

        double money = 0;

        try {
            money = Double.parseDouble(transferMoney);
        } catch (Exception e) {
            return new JsonResult<>("2", "输入金额不正确！");
        }

        return myService.transferMoney(loseid,getid,money);
    }
}

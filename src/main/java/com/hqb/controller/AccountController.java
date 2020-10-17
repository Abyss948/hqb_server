package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;



    @GetMapping("/getOrderByUserid")
    public JsonResult<Map<String, Object>> getOrderByUserid(@RequestParam("userid") int userid)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("needorder",accountService.getNeedOrderByUserid(userid));
        map.put("provideorder",accountService.getProvideOrderByUserid(userid));
        return new JsonResult<>(map);
    }
    @GetMapping("/getTradepartnerByUserid")
    public JsonResult<Object> getTradepartnerByUserid(@RequestParam("userid")int userid)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("record", accountService.getTradepartnerByUserid(userid));
        return new JsonResult<>(map,"success");
    }

    @GetMapping("/getBanlanceInfoByUserid")
    public JsonResult<Object> getBalanceInfoByUserid(@RequestParam("userid")int userid)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("balance", accountService.getBalanceByUserid(userid));
        //测试5
        map.put("income", accountService.getIncomeByUserid(userid));
        map.put("dept", accountService.getDeptByUserid(userid));
        return new JsonResult<>(map, "查询成功");
    }
}
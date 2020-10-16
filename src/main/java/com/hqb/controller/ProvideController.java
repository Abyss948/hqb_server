package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.AdminService;
import com.hqb.service.NeedService;
import com.hqb.service.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProvideController {
    @Autowired
    ProvideService provideService;

    @Autowired
    NeedService needService;

    @Autowired
    AdminService adminService;

    @PostMapping("/provideCalculate")
    public JsonResult<Object> provideCalculate(@RequestParam("goalmoney")double goalmoney,@RequestParam("timelimit")double timelimit,@RequestParam("rate")double rate){
        if(needService.isOverRate(rate)){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("rateMax",adminService.getMaxRate()/100.0);
            map1.put("rateMin",adminService.getMinRate()/100.0);
            return new JsonResult<>(map1,"1","汇率超出范围");
        }
        if(timelimit<0||timelimit>3)
            return new JsonResult<>("2","时间超出范围");
        if(goalmoney<=0)
            return new JsonResult<>("3","金额超出范围");
        Map<String, Object> map = new HashMap<>();
        map.put("goalmoney",goalmoney);
        map.put("rate",rate);
        double interest = goalmoney*rate/100*timelimit;
        map.put("interest",interest);
        double servicefee = provideService.getServicefee(goalmoney,timelimit);
        map.put("servicefee",servicefee);
        return new JsonResult<>(map);
    }


    @PostMapping("/setNewProvide")
    public JsonResult<Object> setNewProvide(@RequestParam("userid") int userid, @RequestParam("rate") double rate, @RequestParam("timelimit") double timelimit, @RequestParam("goalmoney") double goalmoney) {
        provideService.setNewProvide(userid, rate, timelimit, goalmoney);
        return new JsonResult<>();
    }
}

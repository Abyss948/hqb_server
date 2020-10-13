package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.AdminService;
import com.hqb.service.NeedService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NeedController {

    @Autowired
    NeedService needService;

    @Autowired
    AdminService adminService;



    @PostMapping("/needCalculate")
    public JsonResult<Object> needCalculate(@RequestParam("goalmoney")double money,@RequestParam("timelimit")double timelimit,@RequestParam("rate")double rate){
        if(needService.isOverRate(rate)){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("rateMax",adminService.getMaxRate()/100.0);
            map1.put("rateMin",adminService.getMinRate()/100.0);
            return new JsonResult<>(map1,"1","汇率超出范围");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("goalmoney",money);
        map.put("rate",rate);
        double interest = money*rate/100*timelimit;
        map.put("interest",interest);
        double servicerate = adminService.getServiceRate();
        double servicefee = servicerate*money;
        map.put("servicefee",servicefee);
        return new JsonResult<>(map);
    }


    @PostMapping("/setNewNeed")
    public JsonResult<Object> setNewNeed(@RequestParam("userid")int userid,@RequestParam("rate")double rate,@RequestParam("timelimit")double timelimit,@RequestParam("goalmoney")double goalmoney){
        needService.setNewNeed(userid,rate,timelimit,goalmoney);
        return new JsonResult<>();
    }


}

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
    public JsonResult<Object> provideCalculate(@RequestParam("goalmoney") double goalmoney, @RequestParam("timelimit") double timelimit, @RequestParam("rate") double rate) {
        if (needService.isOverRate(rate,timelimit)) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("rateMaxOne", adminService.getMaxRateOne());
            map1.put("rateMinOne", adminService.getMinRateOne());
            map1.put("rateMaxTwo", adminService.getMaxRateTwo());
            map1.put("rateMinTwo", adminService.getMinRateTwo());
            return new JsonResult<>(map1, "1", "汇率超出范围");
        }
        if (timelimit < 0 || timelimit > 3)
            return new JsonResult<>("2", "时间超出范围");
        if (goalmoney <= 0)
            return new JsonResult<>("3", "金额超出范围");
        Map<String, Object> map = new HashMap<>();
        map.put("goalmoney", goalmoney);
        map.put("rate", rate);
        double interest = goalmoney * rate / 100 * timelimit;
        map.put("interest", interest);
        double servicefee = provideService.getServicefee(goalmoney, timelimit);
        map.put("servicefee", servicefee);
        return new JsonResult<>(map);
    }

    @PostMapping("/setNewProvide")
    public JsonResult<Object> setNewProvide(@RequestParam("userid") int userid, @RequestParam("rate") double rate, @RequestParam("timelimit") double timelimit, @RequestParam("goalmoney") double goalmoney) {
        provideService.setNewProvide(userid, rate, timelimit, goalmoney);
        Map<String, Object> map = new HashMap<>();
        map.put("matchList",provideService.getMatchList(userid,rate,timelimit,goalmoney));
        return new JsonResult<>(map);
    }

    @PostMapping("/provideSimulate")
    public JsonResult<Object> provideSimulate(@RequestParam("userid") int userid, @RequestParam("needid") int needid) {
        Map<String, Object> map = provideService.provideSimulate(userid,needid);
        return new JsonResult<>(map);
    }

    @PostMapping("/provideSuccess")
    public JsonResult<Object> provideSuccess(@RequestParam("userid") int userid, @RequestParam("needid") int needid) {
        provideService.provideSuccess(userid,needid);
        return new JsonResult<>();
    }
}

package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.SuccessOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SuccessOrderController {

    @Autowired
    SuccessOrderService successOrderService;

    @GetMapping("/getSuccessOrderByNeedid")
    public JsonResult<Object> getSuccessOrderByNeedid(@RequestParam("needid") int needid) {
        Map<String,Object> map = new HashMap<>();
        map.put("getSuccessOrderByNeedid",successOrderService.getSuccessOrderByNeedid(needid));
        return new JsonResult<>(map);

    }
    @GetMapping("/getSuccessOrderByProvideid")
    public JsonResult<Object> getSuccessOrderByProvideid(@RequestParam("provideidid") int provideid) {
        Map<String,Object> map = new HashMap<>();
        map.put("getSuccessOrderByProvideid",successOrderService.getSuccessOrderByProvideid(provideid));
        return new JsonResult<>(map);

    }



}

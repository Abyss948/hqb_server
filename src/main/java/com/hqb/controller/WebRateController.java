package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebRateController {
    @Autowired
    WebRateService webRateService;
    @GetMapping("/setWebRate")
    public JsonResult<Object> setWebRate(@RequestParam("longminrate") double longminrate,
                                         @RequestParam("longmaxrate")double longmaxrate,
                                         @RequestParam("shortmaxrate") double shortmaxrate,
                                         @RequestParam("shortminrate")double shortminrate)
    {
        webRateService.setWebLongMaxRate(longmaxrate);
        webRateService.setWebLongMinRate(longminrate);
        webRateService.setWebShortMaxRate(shortmaxrate);
        webRateService.setWebShortMinRate(shortminrate);
        return new JsonResult<>( "更新成功");
    }

    @GetMapping("/getWebRate")
    public JsonResult<Object> getWebRate()
    {
        Map<String ,Object> maplong = new HashMap<>();
        maplong.put("15",webRateService.getWebLongRate(1));
        maplong.put("14",webRateService.getWebLongRate(2));
        maplong.put("13",webRateService.getWebLongRate(3));
        maplong.put("12",webRateService.getWebLongRate(4));
        maplong.put("11",webRateService.getWebLongRate(5));
        maplong.put("10",webRateService.getWebLongRate(6));
        maplong.put("9",webRateService.getWebLongRate(7));
        maplong.put("8",webRateService.getWebLongRate(8));
        maplong.put("7",webRateService.getWebLongRate(9));
        maplong.put("6",webRateService.getWebLongRate(10));
        maplong.put("5",webRateService.getWebLongRate(11));
        maplong.put("4",webRateService.getWebLongRate(12));
        maplong.put("3",webRateService.getWebLongRate(13));
        maplong.put("2",webRateService.getWebLongRate(14));
        maplong.put("1",webRateService.getWebLongRate(15));
        Map<String ,Object> mapshort = new HashMap<>();
        mapshort.put("15",webRateService.getWebShortRate(1));
        mapshort.put("14",webRateService.getWebShortRate(2));
        mapshort.put("13",webRateService.getWebShortRate(3));
        mapshort.put("12",webRateService.getWebShortRate(4));
        mapshort.put("11",webRateService.getWebShortRate(5));
        mapshort.put("10",webRateService.getWebShortRate(6));
        mapshort.put("9",webRateService.getWebShortRate(7));
        mapshort.put("8",webRateService.getWebShortRate(8));
        mapshort.put("7",webRateService.getWebShortRate(9));
        mapshort.put("6",webRateService.getWebShortRate(10));
        mapshort.put("5",webRateService.getWebShortRate(11));
        mapshort.put("4",webRateService.getWebShortRate(12));
        mapshort.put("3",webRateService.getWebShortRate(13));
        mapshort.put("2",webRateService.getWebShortRate(14));
        mapshort.put("1",webRateService.getWebShortRate(15));
        Map<String ,Object> map = new HashMap<>();
        map.put("短期",mapshort);
        map.put("长期",maplong);
        return new JsonResult<>(map);


    }
}

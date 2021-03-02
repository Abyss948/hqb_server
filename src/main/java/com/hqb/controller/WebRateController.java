package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebRateController {
    @Autowired
    WebRateService webRateService;

    @PostMapping("/setWebRate")
    public JsonResult<Object> setWebRate(@RequestParam(name = "longmin") double longminrate,
                                         @RequestParam(name = "longmax") double longmaxrate,
                                         @RequestParam(name = "shortmax") double shortmaxrate,
                                         @RequestParam(name = "shortmin") double shortminrate) {

        webRateService.setWebLongMaxRate(longmaxrate);
        webRateService.setWebLongMinRate(longminrate);
        webRateService.setWebShortMaxRate(shortmaxrate);
        webRateService.setWebShortMinRate(shortminrate);
        return new JsonResult<>("更新成功");
    }

    @GetMapping("/getWebRate")
    public JsonResult<Object> getWebRate() {
        ArrayList<Double> arraylong = new ArrayList<>();
        double minrate = 10,maxrate = 0;
        for(int i=0;i<=14;i++){
            Double temp = webRateService.getWebLongRate(15-i);
            if(temp!=null){
                maxrate = Math.max(maxrate,temp);
                minrate = Math.min(minrate,temp);
            }
            arraylong.add(i,temp);
        }
        ArrayList<Double> arrayshort = new ArrayList<>();
        for(int i=0;i<=14;i++){
            Double temp = webRateService.getWebShortRate(15-i);
            if(temp!=null){
                maxrate = Math.max(maxrate,temp);
                minrate = Math.min(minrate,temp);
            }
            arrayshort.add(i,temp);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("arraylong", arraylong);
        map.put("arrayshort", arrayshort);
        map.put("maxrate",maxrate);
        map.put("minrate",minrate);
        return new JsonResult<>(map);

    }
}

package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

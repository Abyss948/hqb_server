package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebSerFeeChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebSerFeeChartController {
    @Autowired
    WebSerFeeChartService webSerFeeChartService;

    @GetMapping("/getWebSerFeeChart")
    public JsonResult<Object> getWebSerFeeChart()
    {
        Map<String ,Object> map = new HashMap<>();
        map.put("1",webSerFeeChartService.getWebSerFeeChart(1));
        map.put("2",webSerFeeChartService.getWebSerFeeChart(2));
        map.put("3",webSerFeeChartService.getWebSerFeeChart(3));
        map.put("4",webSerFeeChartService.getWebSerFeeChart(4));
        map.put("5",webSerFeeChartService.getWebSerFeeChart(5));
        map.put("6",webSerFeeChartService.getWebSerFeeChart(6));
        map.put("7",webSerFeeChartService.getWebSerFeeChart(7));
        map.put("8",webSerFeeChartService.getWebSerFeeChart(8));
        map.put("9",webSerFeeChartService.getWebSerFeeChart(9));
        map.put("10",webSerFeeChartService.getWebSerFeeChart(10));
        map.put("11",webSerFeeChartService.getWebSerFeeChart(11));
        map.put("12",webSerFeeChartService.getWebSerFeeChart(12));
        return new JsonResult<>(map);
    }
}

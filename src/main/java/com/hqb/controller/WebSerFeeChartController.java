package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebSerFeeChartService;
import io.reactivex.internal.util.LinkedArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebSerFeeChartController {
    @Autowired
    WebSerFeeChartService webSerFeeChartService;

    @GetMapping("/getWebSerFeeChart")
    public JsonResult<Object> getWebSerFeeChart()
    {
        ArrayList<Integer> arrayMonth = new ArrayList<>();
        ArrayList<Double> arrayFee = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            arrayMonth.add(i,i+1);
            arrayFee.add(i,fliter(webSerFeeChartService.getWebSerFeeChart(i+1)));
        }



        Map<String ,Object> map = new HashMap<>();
        map.put("arrayMonth",arrayMonth);
        map.put("arrayFee",arrayFee);
        return new JsonResult<>(map);
    }

    public Double fliter(Double d) {
        if (d == null) {
            return d;
        } else {
            return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }
}

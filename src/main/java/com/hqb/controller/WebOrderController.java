package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class WebOrderController {
    @Autowired
    WebOrderService webOrderService;

    @GetMapping("/getWebOrder")
    public JsonResult<Map<String, Object>> getWebOrder(@RequestParam(value="userid",required=false,defaultValue = "")int userid,
                                                       @RequestParam(value="username",required=false,defaultValue = "")String username,
                                                       @RequestParam(value="starttime",required=false,defaultValue = "")String starttime,
                                                       @RequestParam(value="endtime",required=false,defaultValue = "")String endtime,
                                                       @RequestParam(value="timelimit",required=false,defaultValue = "")double timelimit,
                                                       @RequestParam(value="rate",required=false,defaultValue = "")double rate
                                                       ,@RequestParam(value="money",required=false ,defaultValue = "")double money) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date timeStart = null;
        Date timeEnd = null;
        if(null!=starttime&&!starttime.equals("")){
            timeStart=(sdf.parse(starttime));
        }
        if(null!=endtime&&!endtime.equals("")){
            timeEnd=(sdf.parse(endtime));
        }
        System.out.println(username);
        Map<String, Object> map = new HashMap<>();
        map.put("订单",webOrderService.getWebOrder(userid, username,
                timeStart, timeEnd,
                timelimit, rate, money));
        return new JsonResult<>(map, "查询成功");
    }


}

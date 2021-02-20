package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class WebOrderController {
    @Autowired
    WebOrderService webOrderService;

    @PostMapping("/searchOrderByMany")
    public JsonResult<Map<String, Object>> searchOrderByMany(@RequestParam(value = "userid") String userid,
                                                             @RequestParam(value = "username") String username,
                                                             @RequestParam(value = "starttime") String starttime,
                                                             @RequestParam(value = "endtime") String endtime,
                                                             @RequestParam(value = "timelimit") String timelimit,
                                                             @RequestParam(value = "rate") String rate,
                                                             @RequestParam(value = "money") String money) {
/*
        System.out.println("userid:" + userid + "\nusername:" + username + "\nstarttime" + starttime + "\nendtime:" + endtime +
                "\ntimelimit:" + timelimit + "\nrate" + rate + "\nmoney:" + money);
*/

        if((!userid.equals("")) && (!username.equals(""))){
            return new JsonResult<>("1", "用户编号和用户名不可同时查询");
        }

        int useridOfInt = 0;
        if (userid.equals("")) {
            useridOfInt = 0;
        } else {
            try {
                useridOfInt = Integer.parseInt(userid);
            } catch (Exception e) {
                return new JsonResult<>("1", "用户编号输入错误");
            }
        }

        double year = Double.parseDouble(timelimit)/2;
        double rateOfDouble;
        double moneyOfDouble;
        if(rate.equals("")){
            rateOfDouble = 0;
        }else{
            try {
                rateOfDouble=Double.parseDouble(rate);
            }catch (Exception e){
                return new JsonResult<>("1", "交易利率输入错误");
            }
        }
        if(rateOfDouble<0 || rateOfDouble>100){
            return new JsonResult<>("1", "交易利率请输入0-100之间");
        }

        if(money.equals("")){
            moneyOfDouble = 0;
        }else{
            try {
                moneyOfDouble=Double.parseDouble(money);
            }catch (Exception e){
                return new JsonResult<>("1", "金额输入错误");
            }
        }
        Map<String,Object> resultMap = new HashMap();
        List<Map<String, Object>> mapList;
        if(!userid.equals("")) {
            mapList = webOrderService.searchOrderByManyWithUserid(useridOfInt, starttime, endtime, year, rateOfDouble, moneyOfDouble);
        }else if(!username.equals("")){
            mapList = null;
        }else{
            mapList = webOrderService.searchOrderByMany(starttime, endtime, year, rateOfDouble, moneyOfDouble);
        }
        resultMap.put("resultList",mapList);
/*        if(mapList!=null)
        for(int i = 0;i<mapList.size();i++){
            System.out.println(mapList.get(i));
        }
        System.out.println(year);*/
        return new JsonResult<Map<String,Object>>(resultMap);
    }

    @GetMapping("/getWebOrder")
    public JsonResult<Map<String, Object>> getWebOrder(@RequestParam(value = "userid", required = false, defaultValue = "") int userid,
                                                       @RequestParam(value = "username", required = false, defaultValue = "") String username,
                                                       @RequestParam(value = "starttime", required = false, defaultValue = "") String starttime,
                                                       @RequestParam(value = "endtime", required = false, defaultValue = "") String endtime,
                                                       @RequestParam(value = "timelimit", required = false, defaultValue = "") double timelimit,
                                                       @RequestParam(value = "rate", required = false, defaultValue = "") double rate
            , @RequestParam(value = "money", required = false, defaultValue = "") double money) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date timeStart = null;
        Date timeEnd = null;
        if (null != starttime && !starttime.equals("")) {
            timeStart = (sdf.parse(starttime));
        }
        if (null != endtime && !endtime.equals("")) {
            timeEnd = (sdf.parse(endtime));
        }
        System.out.println(username);
        Map<String, Object> map = new HashMap<>();
        map.put("订单", webOrderService.getWebOrder(userid, username,
                timeStart, timeEnd,
                timelimit, rate, money));
        return new JsonResult<>(map, "查询成功");
    }

}

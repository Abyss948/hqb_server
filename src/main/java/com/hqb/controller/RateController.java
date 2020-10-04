package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.RateService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RateController {
    @Autowired
    RateService rateService;

    @GetMapping("/getRate")
    public JsonResult<Map<String,Map<Timestamp,Integer>>> getRate()
    {

        Map<String, Map<Timestamp,Integer>> map = new HashMap<>();
        map.put("ratelist", rateService.getRate());
        return new JsonResult<>(map,"success");
    }

}
package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NeedController {

    @Autowired
    NeedService needService;

    @PostMapping("/setNewNeed")
    public JsonResult<Object> setNewNeed(@RequestParam("userid")int userid,@RequestParam("rate")double rate,@RequestParam("timelimit")double timelimit,@RequestParam("goalmoney")double goalmoney){
        needService.setNewNeed(userid,rate,timelimit,goalmoney);
        return new JsonResult<>();
    }
}

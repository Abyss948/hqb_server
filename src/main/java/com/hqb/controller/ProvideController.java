package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvideController {
    @Autowired
    ProvideService provideService;

    @PostMapping("/setNewProvide")
    public JsonResult<Object> setNewProvide(@RequestParam("userid") int userid, @RequestParam("rate") double rate, @RequestParam("timelimit") double timelimit, @RequestParam("goalmoney") double goalmoney) {
        provideService.setNewProvide(userid, rate, timelimit, goalmoney);
        return new JsonResult<>();
    }
}

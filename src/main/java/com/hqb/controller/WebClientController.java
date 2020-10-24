package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class WebClientController {
    @Autowired
    WebClientService webClientService;

    @GetMapping("/getWebClientByUserid")
    public JsonResult<Map<String, Object>> getWebClientByUserid(@RequestParam("userid")int userid)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("客户信息",webClientService.getWebClientByUserid(userid));
        return new JsonResult<>(map, "查询成功");
    }
}

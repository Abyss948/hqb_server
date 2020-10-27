package com.hqb.controller;

import com.hqb.pojo.Admin;
import com.hqb.pojo.JsonResult;
import com.hqb.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/adminLogin")
    public JsonResult<Object> adminLogin(@RequestParam("adminname") String adminname, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(adminname, password);
        try {
            subject.login(usernamePasswordToken);
            Admin admin = adminService.getAdminByAdminName(adminname);
            Map<String, Object> map = new HashMap<>();
            map.put("admin",admin);
            return new JsonResult<>(map, "管理员登陆成功");
        } catch (UnknownAccountException e) {
            return new JsonResult<>("1", "管理员用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return new JsonResult<>("2", "管理员密码错误");
        }
    }

    @GetMapping("/getRateMinMax")
    public JsonResult<Object> getRateMinMax(){
        Map<String, Object> map = new HashMap<>();
        map.put("shortmin",adminService.getMinRateOne());
        map.put("shortmax",adminService.getMaxRateOne());
        map.put("longmin",adminService.getMinRateTwo());
        map.put("longmax",adminService.getMaxRateTwo());
        return new JsonResult<>(map, "查询成功");
    }

    @PutMapping("/updateRateRapid")
    public JsonResult<Object> updateRate(@RequestParam("rateMin") double rateMin,@RequestParam("rateMax") double rateMax){
        adminService.updateRateOneRapid(rateMin,rateMax);
        return new JsonResult<>();
    }

    @GetMapping("/getSuccessRecord")
    public JsonResult<Object> getSuccessRecord(){
        Map<String, Object> map = new HashMap<>();
        map.put("successRecord",adminService.getSuccessRecord());
        return new JsonResult<>(map);
    }
}

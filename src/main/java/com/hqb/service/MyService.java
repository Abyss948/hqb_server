package com.hqb.service;

import com.hqb.pojo.JsonResult;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface MyService {
    Map<String, Object> getMyByUserid(int userid);


    JsonResult<Map<String, Object>> transferMoney(int loseid, int getid, double money);
}

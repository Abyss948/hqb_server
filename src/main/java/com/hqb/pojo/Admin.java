package com.hqb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private int adminid;
    private String adminname;
    private String password;
    private double ratemin;
    private double ratemax;

    public Map<String,Object> getInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("adminid",adminid);
        map.put("adminname",adminname);
        return map;
    }
}

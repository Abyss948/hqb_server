package com.hqb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userid;
    private String username;
    private String idnumber;
    private String bankcard;
    private String phone;
    private String password;
    private String userimgpath;
    private double balance;
    private double earn;
    private double debt;
    private int tcontract;
    private int credit;
    private int status;

    public Map<String,Object> getInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("username", username);
        map.put("bankcard", bankcard);
        map.put("balance", balance);
        map.put("status", status);
        return map;
    }

}

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
    private String password;
    private String email;
    private String wechat;
    private String userimgpath;
    private String intro;
    private String question;
    private String answer;
    private double balance;
    private int status;
    private int credit;

    public Map<String,Object> getInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("username",username);
        map.put("email",email);
        map.put("wechat",wechat);
        map.put("userimgpath",userimgpath);
        map.put("balance",balance);
        map.put("status",status);
        map.put("credit",credit);
        return map;
    }
}

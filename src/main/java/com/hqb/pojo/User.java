package com.hqb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}

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

}

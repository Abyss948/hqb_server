package com.hqb.service;
import com.hqb.pojo.User;

public interface UserService {

    User getUserByUserName(String username);
    String getUsernameByUserid(int userid);
    void addUser(String username, String idnumber, String bankcard, String phone, String password);

}

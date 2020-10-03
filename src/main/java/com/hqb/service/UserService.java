package com.hqb.service;
import com.hqb.pojo.User;

public interface UserService {

    User getUserByUserName(String username);
    String getUsernameByUserid(int userid);
    void addUser(String username, String password, String email, String wechat, String intro, String question, String answer, double balance, int status);

}

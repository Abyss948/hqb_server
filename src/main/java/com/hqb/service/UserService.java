package com.hqb.service;
import com.hqb.pojo.User;

public interface UserService {

    User getUserByUserName(String username);
    String getUsernameByUserid(int userid);
}

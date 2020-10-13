package com.hqb.service;

import com.hqb.mapper.UserMapper;
import com.hqb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }


    @Override
    public String getUsernameByUserid(int userid) {
        return userMapper.getUsernameByUserid(userid);
    }


    @Override
    public void addUser(String username, String idnumber, String bankcard, String phone, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("idnumber",idnumber);
        map.put("bankcard",bankcard);
        map.put("phone",phone);
        map.put("password",password);
        userMapper.addUser(map);
    }
}

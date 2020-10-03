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
    public void addUser(String username, String password, String email, String wechat, String intro, String question, String answer, double balance, int status) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("email",email);
        map.put("wechat",wechat);
        map.put("intro",intro);
        map.put("question",question);
        map.put("answer",answer);
        map.put("balance",balance);
        map.put("status",status);
        userMapper.addUser(map);
    }
}

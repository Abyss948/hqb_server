package com.hqb.service;

import com.hqb.mapper.UserMapper;
import com.hqb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}

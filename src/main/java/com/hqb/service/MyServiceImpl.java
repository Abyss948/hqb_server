package com.hqb.service;

import com.hqb.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class MyServiceImpl implements MyService{
    @Autowired
    MyMapper myMapper;
    @Override
    public Map<String, Object> getMyByUserid(int userid)
    {
        return myMapper.getMyByUserid(userid);
    }

}

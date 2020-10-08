package com.hqb.service;

import com.hqb.mapper.ProvideMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProvideServicelmpl implements ProvideService{
    @Autowired
    ProvideMapper provideMapper;

    @Override
    public void setNewProvide(int userid, double rate, double timelimit, double goalmoney) {
        int rateint=(int)(rate*100);
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("rate",rateint);
        map.put("timelimit",timelimit);
        map.put("goalmoney",goalmoney);
        provideMapper.updateOldProvide(userid);
        provideMapper.setNewProvide(map);
    }
}

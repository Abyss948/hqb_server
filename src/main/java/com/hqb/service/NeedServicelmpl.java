package com.hqb.service;

import com.hqb.mapper.NeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NeedServicelmpl implements NeedService {
    @Autowired
    NeedMapper needMapper;

    @Override
    public void setNewNeed(int userid, double rate, double timelimit, double goalmoney) {
        int rateint=(int)(rate*100);
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("rate",rateint);
        map.put("timelimit",timelimit);
        map.put("goalmoney",goalmoney);
        needMapper.updateOldNeed(userid);
        needMapper.setNewNeed(map);

    }
}

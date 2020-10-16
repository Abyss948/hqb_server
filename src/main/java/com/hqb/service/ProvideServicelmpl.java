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

    @Override
    public double getServicefee(double goalmoney, double timelimit) {
        if (goalmoney >= 2000e4)
            return 5000;
        double serviceRate = 0;
        if (goalmoney <= 100e4) {
            serviceRate = 0.075e-2;
        } else if (goalmoney <= 800e4) {
            serviceRate = 0.05e-2;
        } else if (goalmoney < 2000e4) {
            serviceRate = 0.03e-2;
        }
        double timeRate = 0;
        if (timelimit <= 0.5) {
            timeRate = 3;
        } else if (timelimit <= 1) {
            timeRate = 2.5;
        } else if (timelimit <= 1.5) {
            timeRate = 2;
        } else if (timelimit <= 2) {
            timeRate = 1.5;
        } else if (timelimit <= 2.5) {
            timeRate = 1.25;
        } else if (timelimit <= 3) {
            timeRate = 1;
        }
        return goalmoney*serviceRate*timeRate;
    }
}

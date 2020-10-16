package com.hqb.service;

import com.hqb.mapper.AdminMapper;
import com.hqb.mapper.NeedMapper;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NeedServicelmpl implements NeedService {
    @Autowired
    NeedMapper needMapper;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public void setNewNeed(int userid, double rate, double timelimit, double goalmoney) {
        int rateint = (int) (rate * 100);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("rate", rateint);
        map.put("timelimit", timelimit);
        map.put("goalmoney", goalmoney);
        needMapper.updateOldNeed(userid);
        needMapper.setNewNeed(map);

    }

    @Override
    public boolean isOverRate(double rate) {
        double rateMin = adminMapper.getMinRate() / 100.0;
        double rateMax = adminMapper.getMaxRate() / 100.0;
        return !(rate >= rateMin) || !(rate <= rateMax);

    }

    @Override
    public double getServicefee(double goalmoney, double timelimit) {
        if (goalmoney >= 2000e4)
            return 30000;
        double serviceRate = 0;
        if (goalmoney <= 100e4) {
            serviceRate = 0.06e-2;
        } else if (goalmoney <= 800e4) {
            serviceRate = 0.1e-2;
        } else if (goalmoney < 2000e4) {
            serviceRate = 0.15e-2;
        }
        double timeRate = 0;
        if (timelimit <= 0.5) {
            timeRate = 1;
        } else if (timelimit <= 1) {
            timeRate = 1.25;
        } else if (timelimit <= 1.5) {
            timeRate = 1.5;
        } else if (timelimit <= 2) {
            timeRate = 2.0;
        } else if (timelimit <= 2.5) {
            timeRate = 2.5;
        } else if (timelimit <= 3) {
            timeRate = 3;
        }
        return goalmoney*serviceRate*timeRate;
    }
}

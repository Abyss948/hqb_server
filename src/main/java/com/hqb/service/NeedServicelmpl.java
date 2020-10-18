package com.hqb.service;

import com.hqb.mapper.AdminMapper;
import com.hqb.mapper.NeedMapper;
import com.hqb.mapper.ProvideMapper;
import com.hqb.pojo.Provide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NeedServicelmpl implements NeedService {
    @Autowired
    NeedMapper needMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    ProvideMapper provideMapper;

    @Override
    public void setNewNeed(int userid, double rate, double timelimit, double goalmoney) {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("rate", rate);
        map.put("timelimit", timelimit);
        map.put("goalmoney", goalmoney);
        needMapper.updateOldNeed(userid);
        needMapper.setNewNeed(map);

    }

    @Override
    public boolean isOverRate(double rate, double timelimit) {
        double rateMin;
        double rateMax;
        if (timelimit <= 1) {
            rateMin = adminMapper.getMinRateOne();
            rateMax = adminMapper.getMaxRateOne();
        }else{
            rateMin = adminMapper.getMinRateTwo();
            rateMax = adminMapper.getMaxRateTwo();
        }
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
        return goalmoney * serviceRate * timeRate;
    }

    @Override
    public List<Map<String, Object>> getMatchList(int userid, double rate, double timelimit, double goalmoney) {
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("timelimit",timelimit);
        map.put("rate",rate);
        List<Map<String, Object>> list1 = needMapper.getTimeRateMatchList(map);
        List<Map<String, Object>> list2 = needMapper.getTimeMatchList(map);
        List<Map<String, Object>> list3 = needMapper.getRateMatchList(map);
        list1.addAll(list2);
        list1.addAll(list3);
        return list1;
    }

    @Override
    public Map<String, Object> needSimulate(int userid, int provideid) {
        double needMoney = needMapper.getMoneyByUserid(userid);
        Provide provide = provideMapper.getProvideByProvideid(provideid);
        double successMoney = Math.min(needMoney,provide.getGoalmoney()-provide.getNowmoney());
        double rate = provide.getRate();
        double timelimit = provide.getTimelimit();
        double servicefee = getServicefee(successMoney, timelimit);
        Map<String,Object> map = new HashMap<>();
        map.put("successMoney",successMoney);
        map.put("rate",rate);
        map.put("timelimit",timelimit);
        map.put("servicefee",servicefee);
        return map;
    }
}

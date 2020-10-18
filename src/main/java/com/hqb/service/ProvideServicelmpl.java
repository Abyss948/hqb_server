package com.hqb.service;

import com.hqb.mapper.NeedMapper;
import com.hqb.mapper.ProvideMapper;
import com.hqb.pojo.Need;
import com.hqb.pojo.Provide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProvideServicelmpl implements ProvideService {
    @Autowired
    ProvideMapper provideMapper;

    @Autowired
    NeedMapper needMapper;

    @Override
    public void setNewProvide(int userid, double rate, double timelimit, double goalmoney) {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("rate", rate);
        map.put("timelimit", timelimit);
        map.put("goalmoney", goalmoney);
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
        return (Math.round(goalmoney * serviceRate * timeRate*100)/100.0);
    }

    @Override
    public List<Map<String, Object>> getMatchList(int userid, double rate, double timelimit, double goalmoney) {
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("timelimit",timelimit);
        map.put("rate",rate);
        List<Map<String, Object>> list1 = provideMapper.getTimeRateMatchList(map);
        List<Map<String, Object>> list2 = provideMapper.getTimeMatchList(map);
        List<Map<String, Object>> list3 = provideMapper.getRateMatchList(map);
        list1.addAll(list2);
        list1.addAll(list3);
        return list1;
    }

    @Override
    public Map<String, Object> provideSimulate(int userid, int needid) {
        double provideMoney = provideMapper.getMoneyByUserid(userid);
        Need need = needMapper.getNeedByNeedid(needid);
        double successMoney = Math.min(provideMoney,need.getGoalmoney()-need.getNowmoney());
        double rate = need.getRate();
        double timelimit = need.getTimelimit();
        double servicefee = getServicefee(successMoney, timelimit);
        Map<String,Object> map = new HashMap<>();
        map.put("successMoney",successMoney);
        map.put("rate",rate);
        map.put("timelimit",timelimit);
        map.put("servicefee",servicefee);
        return map;
    }
}

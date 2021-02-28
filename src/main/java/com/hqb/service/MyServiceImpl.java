package com.hqb.service;

import com.hqb.mapper.MyMapper;
import com.hqb.pojo.JsonResult;
import com.hqb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    MyMapper myMapper;

    @Override
    public Map<String, Object> getMyByUserid(int userid) {
        return myMapper.getMyByUserid(userid);
    }

    @Override
    public JsonResult<Map<String, Object>> transferMoney(int loseid, int getid, double money) {

        User loseUser = myMapper.getUserByUerid(loseid);
        User getUser = myMapper.getUserByUerid(getid);

        if (money > loseUser.getBalance()) {
            return new JsonResult<>("3", "余额不足！");
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("losename", loseUser.getUsername());
        map.put("loseid", loseUser.getUserid());
        map.put("getname", getUser.getUsername());
        map.put("getid", getUser.getUserid());
        map.put("transfermoney", money);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        map.put("transfertime", currentTime);

        myMapper.addNewTransfer(map);

        BigDecimal b1 = new BigDecimal(loseUser.getBalance() - money);
        double losemoney = b1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal b2 = new BigDecimal(getUser.getBalance() + money);
        double getmoney = b2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();


        setBalance(loseid, losemoney);
        setBalance(getid, getmoney);

        return new JsonResult<>("0", "转账成功！");
    }

    public void setBalance(int userid, double money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("balance", money);
        myMapper.setBalance(map);
    }
}

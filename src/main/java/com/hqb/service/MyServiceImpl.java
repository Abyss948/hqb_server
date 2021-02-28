package com.hqb.service;

import com.hqb.mapper.MyMapper;
import com.hqb.pojo.JsonResult;
import com.hqb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        setBalance(loseid, loseUser.getBalance() - money);
        setBalance(getid, getUser.getBalance() + money);

        return new JsonResult<>("0", "转账成功！");
    }

    public void setBalance(int userid, double money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("balance", money);
        myMapper.setBalance(map);
    }
}

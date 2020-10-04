package com.hqb.service;

import com.hqb.mapper.BalanceMapper;
import com.hqb.mapper.UserMapper;
import com.hqb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService{

    @Autowired
    BalanceMapper balanceMapper;



    @Override
    public Double getBalanceByUserid(int userid) {
        return balanceMapper.getBalanceByUserid(userid);
    }


}

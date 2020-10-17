package com.hqb.service;


import com.hqb.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccoutServiceImpl  implements AccountService{

    @Autowired
    AccountMapper accountMapper;
    @Override
    public Double getBalanceByUserid(int userid)
    {
        return accountMapper.getBalanceByUserid(userid);
    }

    @Override
    public Double getIncomeByUserid(int userid)
    {
        return accountMapper.getIncomeByUserid(userid);
    }

    @Override
    public Double getDeptByUserid(int userid)
    {
        return accountMapper.getDeptByUserid(userid);
    }
    @Override
    public List<Map<String, Object>> getProvideOrderByUserid(int userid)
    {
        return accountMapper.getProvideOrderByUserid(userid);
    }
    @Override
    public List<Map<String, Object>> getNeedOrderByUserid(int userid)
    {
        return accountMapper.getNeedOrderByUserid(userid);
    }
    @Override
    public Map<String,Integer> getTradepartnerByUserid(int userid)
    {
        return accountMapper.getTradepartnerByUserid(userid);
    }
}

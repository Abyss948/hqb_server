package com.hqb.service;

import com.hqb.mapper.WebOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WebOrderServiceImpl implements WebOrderService{
    @Autowired
    WebOrderMapper webOrderMapper;
    @Override
    public List<Map<String, Object>> getWebOrder(int userid, String username,
                                                 Date starttime, Date endtime,
                                                 double timelimit, double rate, double money)
    {
        return webOrderMapper.getWebOrder(userid, username,
             starttime, endtime,
           timelimit,  rate,  money);
    }
}

package com.hqb.service;

import org.springframework.stereotype.Service;
import com.hqb.mapper.RateMapper;
import com.hqb.pojo.Success;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateMapper rateMapper;

    @Override
    public  List<Map<Timestamp,Integer>> getRate()
    {

        return rateMapper.getRate();
    }


}

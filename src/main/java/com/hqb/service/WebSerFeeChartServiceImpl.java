package com.hqb.service;

import com.hqb.mapper.WebSerFeeChartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSerFeeChartServiceImpl implements WebSerFeeChartService {
    @Autowired
    WebSerFeeChartMapper webSerFeeChartMapper;
    @Override
    public Double getWebSerFeeChart(int month)
    {
        return webSerFeeChartMapper.getWebSerFeeChart(month);
    }
}

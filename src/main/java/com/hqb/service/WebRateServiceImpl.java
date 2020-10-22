package com.hqb.service;

import com.hqb.mapper.WebRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebRateServiceImpl implements WebRateService {
    @Autowired
    WebRateMapper webRateMapper;
    @Override
    public void setWebLongMaxRate(Double longmaxrate)
    {
        webRateMapper.setWebLongMaxRate(longmaxrate);
    }
    @Override
    public void setWebLongMinRate(Double longminrate)
    {
         webRateMapper.setWebLongMinRate(longminrate);
    }
    @Override
    public void setWebShortMaxRate(Double shortmaxrate)
    {
        webRateMapper.setWebShortMaxRate(shortmaxrate);
    }
    @Override
    public void setWebShortMinRate(Double shortminrate)
    {
        webRateMapper.setWebShortMinRate(shortminrate);
    }
}

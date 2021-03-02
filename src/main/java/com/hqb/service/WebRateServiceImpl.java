package com.hqb.service;

import com.hqb.mapper.WebRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class WebRateServiceImpl implements WebRateService {
    @Autowired
    WebRateMapper webRateMapper;

    @Override
    public void setWebLongMaxRate(Double longmaxrate) {
        webRateMapper.setWebLongMaxRate(longmaxrate);
    }

    @Override
    public void setWebLongMinRate(Double longminrate) {
        webRateMapper.setWebLongMinRate(longminrate);
    }

    @Override
    public void setWebShortMaxRate(Double shortmaxrate) {
        webRateMapper.setWebShortMaxRate(shortmaxrate);
    }

    @Override
    public void setWebShortMinRate(Double shortminrate) {
        webRateMapper.setWebShortMinRate(shortminrate);
    }

    public Double getWebShortRate(int day) {
        Double d = webRateMapper.getWebShortRate(day);
        if(d == null){
            return d;
        }else{
            return new BigDecimal(d).setScale(2, RoundingMode.UP).doubleValue();
        }
    }

    public Double getWebLongRate(int day) {
        Double d = webRateMapper.getWebLongRate(day);
        if(d == null){
            return d;
        }else{
            return new BigDecimal(d).setScale(2, RoundingMode.UP).doubleValue();
        }
    }
}

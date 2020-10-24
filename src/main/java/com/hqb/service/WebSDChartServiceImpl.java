package com.hqb.service;

import com.hqb.mapper.WebSDChartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSDChartServiceImpl implements WebSDChartService {
    @Autowired
    WebSDChartMapper webSDChartMapper;

    @Override
    public Double getWebProvideChart(int day)
    {
        return webSDChartMapper.getWebProvideChart(day);
    }
   public  Double getWebNeedChart(int day)
   {
       return webSDChartMapper.getWebNeedChart(day);
   }
   public  Double getWebSuccessChart(int day){return webSDChartMapper.getWebSuccessChart(day);}
}

package com.hqb.service;

import com.hqb.mapper.WebClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class WebClientServiceImpl implements WebClientService{
    @Autowired
    WebClientMapper webClientMapper;

    public Map<String, Object> getWebClientByUserid(int userid)
    {
        return webClientMapper.getWebClientByUserid(userid);
    }
}

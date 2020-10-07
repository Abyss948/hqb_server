package com.hqb.service;

import com.hqb.mapper.SuccessOrderMapper;
import com.hqb.pojo.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessOrderServiceImpl implements SuccessOrderService {
    @Autowired SuccessOrderMapper successOrderMapper;
    @Override
    public List<Success> getSuccessOrderByProvideid(int provideid)
    {
        return successOrderMapper.getSuccessOrderByProvideid(provideid);
    }
    @Override
    public List<Success> getSuccessOrderByNeedid(int needid)
    {
        return successOrderMapper.getSuccessOrderByNeedid(needid);
    }
}

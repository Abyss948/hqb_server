package com.hqb.service;

import com.hqb.mapper.AdminMapper;
import com.hqb.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServicelmpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getAdminByAdminName(String adminname) {
        return adminMapper.getAdminByAdminName(adminname);
    }

    @Override
    public double getMinRateOne() {
        return adminMapper.getMinRateOne();
    }

    @Override
    public double getMaxRateOne() {
        return adminMapper.getMaxRateOne();
    }

    @Override
    public double getMinRateTwo() {
        return adminMapper.getMinRateTwo();
    }

    @Override
    public double getMaxRateTwo() {
        return adminMapper.getMaxRateTwo();
    }

    @Override
    public void updateRateOneRapid(double rateMin, double rateMax) {
        adminMapper.updateRateOneRapid(rateMin, rateMax);
    }

    @Override
    public List<Map<String, Object>> getSuccessRecord() {
        return adminMapper.getSuccessRecord();
    }


}

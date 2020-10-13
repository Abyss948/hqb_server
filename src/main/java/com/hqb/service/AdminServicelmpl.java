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
    public int getMinRate() {
        return adminMapper.getMinRate();
    }

    @Override
    public int getMaxRate() {
        return adminMapper.getMaxRate();
    }

    @Override
    public void updateRateRapid(int rateMin, int rateMax) {
        adminMapper.updateRateRapid(rateMin, rateMax);
    }

    @Override
    public List<Map<String, Object>> getSuccessRecord() {
        return adminMapper.getSuccessRecord();
    }

    @Override
    public double getServiceRate() {
        return 0.01;
    }
}

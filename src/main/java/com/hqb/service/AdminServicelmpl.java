package com.hqb.service;

import com.hqb.mapper.AdminMapper;
import com.hqb.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class AdminServicelmpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    NeedService needService;

    @Autowired
    ProvideService provideService;

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

    @Override
    public Double getSumNeed() {
        return adminMapper.getSumNeed();
    }

    @Override
    public Double getSumProvide() {
        return adminMapper.getSumProvide();
    }

    @Override
    public Double getSumNeedOfBank() {
        return adminMapper.getSumNeedOfBank();
    }

    @Override
    public Double getSumProvideOfBank() {
        return adminMapper.getSumProvideOfBank();
    }

    @Override
    public boolean isOutRate(Double sumNeed, Double sumProvide, double v) {
        return sumNeed / sumProvide > v || sumProvide - sumNeed > v;
    }

    @Override
    public void needGTprovide(Double sumNeed, Double sumProvide) {
        double diff = sumNeed - sumProvide;
        int userid = 1;
        double rate = getAvgRateNeed() + getAvgRateProvide() / 2;
        rate = fliter(rate, 1);
        double timelimit1 = 0.5;
        //double timelimit2 = 1;
        double goalmoney = fliter(diff, 2);
        provideService.setNewProvide(userid, fliter(rate, 2), timelimit1, goalmoney);
    }

    @Override
    public void provideGTneed(Double sumNeed, Double sumProvide) {
        double diff = sumProvide - sumNeed;
        int userid = 1;
        double rate = getAvgRateNeed() + getAvgRateProvide() / 2;
        rate = fliter(rate, 1);
        double timelimit1 = 0.5;
        /*double timelimit2 = 1;*/
        double goalmoney = fliter(diff, 2);
        needService.setNewNeed(userid, rate, timelimit1, goalmoney);
    }

    public Double getAvgRateNeed() {
        return adminMapper.getAvgRateNeed();
    }

    public Double getAvgRateProvide() {
        return adminMapper.getAvgRateProvide();
    }

    @Override
    public Double fliter(Double v, int t) {
        return new BigDecimal(v).setScale(t, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}

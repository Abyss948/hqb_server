package com.hqb.service;

import com.hqb.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin getAdminByAdminName(String adminname);

    double getMinRateOne();
    double getMaxRateOne();
    double getMinRateTwo();
    double getMaxRateTwo();

    void updateRateOneRapid(double rateMin, double rateMax);
    List<Map<String,Object>> getSuccessRecord();

    Double getSumNeed();
    Double getSumProvide();

    boolean isOutRate(Double sumNeed, Double sumProvide, double v);

    void needGTprovide(Double sumNeed, Double sumProvide);
    void provideGTneed(Double sumNeed, Double sumProvide);

    Double fliter(Double v,int t);

    Double getSumNeedOfBank();
    Double getSumProvideOfBank();
}

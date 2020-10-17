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


}

package com.hqb.service;

import com.hqb.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin getAdminByAdminName(String adminname);

    int getMinRateOne();
    int getMaxRateOne();
    int getMinRateTwo();
    int getMaxRateTwo();

    void updateRateOneRapid(int rateMin, int rateMax);
    List<Map<String,Object>> getSuccessRecord();


}

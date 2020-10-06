package com.hqb.service;

import com.hqb.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin getAdminByAdminName(String adminname);

    int getMinRate();
    int getMaxRate();

    void updateRateRapid(int rateMin, int rateMax);
    List<Map<String,Object>> getSuccessRecord();
}

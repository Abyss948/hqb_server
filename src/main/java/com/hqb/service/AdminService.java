package com.hqb.service;

import com.hqb.pojo.Admin;

public interface AdminService {
    Admin getAdminByAdminName(String adminname);

    int getMinRate();
    int getMaxRate();

    void updateRateRapid(int rateMin, int rateMax);
}

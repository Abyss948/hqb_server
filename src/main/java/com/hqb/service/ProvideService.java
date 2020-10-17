package com.hqb.service;

import java.util.List;
import java.util.Map;

public interface ProvideService {
    void setNewProvide(int userid, double rate, double timelimit, double goalmoney);

    double getServicefee(double goalmoney, double timelimit);

    List<Map<String,Object>> getMatchList(int userid, double rate, double timelimit, double goalmoney);
}

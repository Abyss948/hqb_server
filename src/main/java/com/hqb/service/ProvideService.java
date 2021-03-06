package com.hqb.service;

import java.util.List;
import java.util.Map;

public interface ProvideService {
    void setNewProvide(int userid, double rate, double timelimit, double goalmoney);

    double getServicefee(double goalmoney, double timelimit);

    List<Map<String,Object>> getMatchList(int userid, double rate, double timelimit, double goalmoney);

    Map<String, Object> provideSimulate(int userid, int needid);

    void provideSuccess(int userid, int needid);

    List<Map<String,Object>> getProvideMatchList(int userid);
}

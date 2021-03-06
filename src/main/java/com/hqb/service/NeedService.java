package com.hqb.service;

import com.hqb.pojo.Need;

import java.util.List;
import java.util.Map;

public interface NeedService {
    void setNewNeed(int userid, double rate, double timelimit, double goalmoney);

    boolean isOverRate(double rate,double timelimit);

    double getServicefee(double goalmoney,double timelimit);

    List<Map<String,Object>> getMatchList(int userid, double rate, double timelimit, double goalmoney);

    Map<String, Object> needSimulate(int userid, int provideid);
    void needSuccess(int userid, int provideid);

    List<Map<String,Object>> getNeedMatchList(int userid);

}

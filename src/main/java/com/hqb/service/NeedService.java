package com.hqb.service;

public interface NeedService {
    void setNewNeed(int userid, double rate, double timelimit, double goalmoney);

    boolean isOverRate(double rate);
}

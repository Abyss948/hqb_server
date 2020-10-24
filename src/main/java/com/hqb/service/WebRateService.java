package com.hqb.service;

public interface WebRateService {
    void setWebLongMaxRate(Double longmaxrate);
    void setWebLongMinRate(Double longminrate);
    void setWebShortMaxRate(Double shortmaxrate);
    void setWebShortMinRate(Double shortminrate);
    Double getWebShortRate(int day);
    Double getWebLongRate(int day);
}

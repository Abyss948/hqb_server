package com.hqb.service;
import com.hqb.pojo.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface RateService {

    Map<Timestamp,Integer> getRate();
}

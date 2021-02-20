package com.hqb.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WebOrderService {

    List<Map<String, Object>> getWebOrder(int userid, String username,
                                          Date starttime, Date endtime,
                                          double timelimit, double rate, double money);

    List<Map<String, Object>> searchOrderByManyWithUserid(int userid,
                                                String starttime,String endtime,
                                                double timelimit,double rate,double money);

    List<Map<String, Object>> searchOrderByMany(String starttime,String endtime,
                                                double timelimit,double rate,double money);

    }

package com.hqb.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WebOrderService {

    List<Map<String, Object>> getWebOrder(int userid, String username,
                                          Date starttime, Date endtime,
                                          double timelimit, double rate, double money);
}

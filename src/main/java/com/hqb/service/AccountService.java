package com.hqb.service;

import java.util.List;
import java.util.Map;

public interface AccountService {

    Double getBalanceByUserid(int userid);
    Double getIncomeByUserid(int userid);
    Double getDeptByUserid(int userid);
    List<Map<String, Object>> getOrderByUserid(int userid);
    Map<String,Integer> getTradepartnerByUserid(int userid);
}

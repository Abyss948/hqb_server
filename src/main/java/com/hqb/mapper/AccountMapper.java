package com.hqb.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AccountMapper {

    Double getBalanceByUserid(int userid);
    Double getIncomeByUserid(int userid);
    Double getDeptByUserid(int userid);
    List<Map<String, Object>> getProvideOrderByUserid(int userid);
    List<Map<String, Object>> getNeedOrderByUserid(int userid);
    Map<String,Integer> getTradepartnerByUserid(int userid);
}

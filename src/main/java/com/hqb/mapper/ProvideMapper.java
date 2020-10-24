package com.hqb.mapper;

import com.hqb.pojo.Provide;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProvideMapper {
    void updateOldProvide(int userid);
    void setNewProvide(Map<String, Object> map);

    List<Map<String, Object>> getTimeRateMatchList(Map<String, Object> mapTime);
    List<Map<String, Object>> getTimeMatchList(Map<String, Object> map);
    List<Map<String, Object>> getRateMatchList(Map<String, Object> map);

    Provide getProvideByProvideid(int provideid);
    Provide getProvideByUserid(int userid);

    double getMoneyByUserid(int userid);

    void updateNowMoney(Map<String, Object> map);

    void updateProvide(int provideid);
}
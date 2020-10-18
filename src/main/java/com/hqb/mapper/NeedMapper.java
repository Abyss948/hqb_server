package com.hqb.mapper;

import com.hqb.pojo.Need;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NeedMapper {
    void setNewNeed(Map<String, Object> map);
    void updateOldNeed(int userid);

    List<Map<String, Object>> getTimeRateMatchList(Map<String, Object> mapTime);
    List<Map<String, Object>> getTimeMatchList(Map<String, Object> map);
    List<Map<String, Object>> getRateMatchList(Map<String, Object> map);

    double getMoneyByUserid(int userid);

    Need getNeedByNeedid(int needid);
}

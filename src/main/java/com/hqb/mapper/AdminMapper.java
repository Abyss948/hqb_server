package com.hqb.mapper;

import com.hqb.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminMapper {
    Admin getAdminByAdminName(String adminname);

    double getMinRateOne();
    double getMaxRateOne();
    double getMinRateTwo();
    double getMaxRateTwo();

    void updateRateOneRapid(double rateMin, double rateMax);
    List<Map<String, Object>> getSuccessRecord();

    Double getSumNeed();

    Double getSumProvide();

    Double getAvgRateNeed();
    Double getAvgRateProvide();

    Double getSumNeedOfBank();
    Double getSumProvideOfBank();
}

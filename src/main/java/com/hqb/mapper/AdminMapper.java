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

    int getMinRateOne();
    int getMaxRateOne();
    int getMinRateTwo();
    int getMaxRateTwo();

    void updateRateOneRapid(int rateMin, int rateMax);
    List<Map<String, Object>> getSuccessRecord();


}

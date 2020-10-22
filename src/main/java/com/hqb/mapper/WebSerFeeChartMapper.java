package com.hqb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebSerFeeChartMapper {
    Double getWebSerFeeChart(int month);
}

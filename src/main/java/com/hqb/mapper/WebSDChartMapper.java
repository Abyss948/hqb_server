package com.hqb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebSDChartMapper {
    Double getWebProvideChart(int day);
    Double getWebNeedChart(int day);
    Double getWebSuccessChart(int day);
}

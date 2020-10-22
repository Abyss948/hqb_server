package com.hqb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebRateMapper {
    void setWebLongMaxRate(Double longmaxrate);
    void setWebLongMinRate(Double longminrate);
    void setWebShortMaxRate(Double shortmaxrate);
    void setWebShortMinRate(Double shortminrate);

}

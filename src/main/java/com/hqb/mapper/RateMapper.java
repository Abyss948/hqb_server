package com.hqb.mapper;

import com.hqb.pojo.Success;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RateMapper {
    List<Map<Timestamp,Integer>> getRate();
}

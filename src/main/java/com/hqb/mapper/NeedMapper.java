package com.hqb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface NeedMapper {
    void setNewNeed(Map<String, Object> map);
    void updateOldNeed(int userid);

}

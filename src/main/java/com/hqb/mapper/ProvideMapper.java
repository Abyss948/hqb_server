package com.hqb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface ProvideMapper {
    void updateOldProvide(int userid);
    void setNewProvide(Map<String, Object> map);


}
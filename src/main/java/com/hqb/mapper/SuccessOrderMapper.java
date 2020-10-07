package com.hqb.mapper;

import com.hqb.pojo.Success;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SuccessOrderMapper {


    List<Success> getSuccessOrderByProvideid(int provideid);
    List<Success> getSuccessOrderByNeedid(int needid);
}

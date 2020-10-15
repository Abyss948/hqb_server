package com.hqb.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MyMapper {


    Map<String, Object> getMyByUserid(int userid);

}

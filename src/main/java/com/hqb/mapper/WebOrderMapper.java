package com.hqb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface WebOrderMapper {
    List<Map<String, Object>> getWebOrder(@Param("userid") int userid, @Param("username") String username,
                                          @Param("starttime") Date starttime, @Param("endtime") Date endtime,
                                          @Param("timelimit")double timelimit, @Param("rate") double rate,
                                          @Param("money") double money);
}

package com.hqb.mapper;

import com.hqb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BalanceMapper {

    Double getBalanceByUserid(int userid);

}

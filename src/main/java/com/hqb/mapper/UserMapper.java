package com.hqb.mapper;

import com.hqb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    User getUserByUserName(String username);

    String getUsernameByUserid(int userid);
    void addUser(Map<String, Object> map);
}

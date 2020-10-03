package com.hqb.mapper;

import com.hqb.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    Admin getAdminByAdminName(String adminname);
}

package com.hqb.mapper;
import com.hqb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MyMapper {


    Map<String, Object> getMyByUserid(int userid);

    User getUserByUerid(int loseid);

    void addNewTransfer(HashMap<String, Object> map);

    void setBalance(HashMap<String, Object> map);
}

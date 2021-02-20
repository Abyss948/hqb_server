package com.hqb.service;

import com.hqb.mapper.WebOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebOrderServiceImpl implements WebOrderService{
    @Autowired
    WebOrderMapper webOrderMapper;
    @Override
    public List<Map<String, Object>> getWebOrder(int userid, String username,
                                                 Date starttime, Date endtime,
                                                 double timelimit, double rate, double money)
    {
        return webOrderMapper.getWebOrder(userid, username,
             starttime, endtime,
           timelimit,  rate,  money);
    }

    @Override
    public List<Map<String, Object>> searchOrderByManyWithUserid(int userid, String starttime, String endtime, double timelimit, double rate, double money) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stime = starttime+" 00:00:00";
        String etime = endtime+" 23:59:59";
        HashMap<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        map.put("starttime",stime);
        map.put("endtime",etime);
        map.put("timelimit",timelimit);
        map.put("rate",rate);
        map.put("money",money);
        List<Map<String,Object>> mapList =  webOrderMapper.searchOrderByManyWithUserid(map);
        mapList = addName(mapList);
        return mapList;
    }

    public List<Map<String, Object>> addName(List<Map<String, Object>> mapList){
        if(mapList==null){
            return mapList;
        }
        for(int i = 0;i< mapList.size();i++){
            Map map = mapList.get(i);
            map.put("nName", webOrderMapper.getNameById((int)map.get("nid")));
            map.put("pName", webOrderMapper.getNameById((int)map.get("pid")));
            map.put("starttime",map.get("starttime").toString().substring(0,10));
            map.put("endtime",map.get("endtime").toString().substring(0,10));
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> searchOrderByMany(String starttime, String endtime, double timelimit, double rate, double money) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stime = starttime+" 00:00:00";
        String etime = endtime+" 23:59:59";
        HashMap<String,Object> map = new HashMap<>();
        map.put("starttime",stime);
        map.put("endtime",etime);
        map.put("timelimit",timelimit);
        map.put("rate",rate);
        map.put("money",money);
        List<Map<String,Object>> mapList =  webOrderMapper.searchOrderByMany(map);
        mapList = addName(mapList);
        return mapList;
    }
}

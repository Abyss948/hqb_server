package com.hqb.controller;

import com.hqb.mapper.NeedMapper;
import com.hqb.mapper.UserMapper;
import com.hqb.pojo.JsonResult;
import com.hqb.pojo.User;
import com.hqb.service.NeedService;
import com.hqb.service.ProvideService;
import com.hqb.service.UserService;
import com.hqb.testChain.BlockChainTest;
import com.hqb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.RemoteFunctionCall;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TempController {

    @Autowired
    UserService userService;

    @Autowired
    NeedMapper needMapper;

    @Autowired
    NeedService needService;

    @Autowired
    ProvideService provideService;

    @GetMapping("/temp1")
    public JsonResult<Object> temp1() throws Exception {

        Map<String, Object> map = new HashMap<>();
        BigInteger id = new BigInteger("100");
        BigInteger balance = new BigInteger("2999");
        BlockChainTest.loadContract(id, balance);
        return new JsonResult<>(map, "success");
    }

    @GetMapping("/temp2")
    public JsonResult<Object> temp2() throws Exception {

        Map<String, Object> map = new HashMap<>();
        BigInteger id = new BigInteger("100");
        RemoteFunctionCall<BigInteger> bigIntegerRemoteFunctionCall = BlockChainTest.getinfoContract(id);

        map.put("this", bigIntegerRemoteFunctionCall.send());
        return new JsonResult<>(map, "success");
    }

    @PostMapping("/zAddUser")
    public JsonResult<Object> zAddUser(@RequestParam("name") String name) {
        name = name.replace(" ", "");
        int length = name.length();
        for (int i = 0; i < length / 4; i++) {
            String username = name.substring(4 * i, 4 * i + 4);
            User user = userService.getUserByUserName(username);
            if (user != null) {
                continue;
            }
            Random random = getRandom();
            int num = random.nextInt(2);
            boolean male;
            male = num == 0;
            String idnumber = StringUtils.getIdNo(male);
            String bankcard = "6210" + getRandomNumberString(12);
            String phone = "1" + getRandomNumberString(10);
            String password = "test123";
            userService.addUser(username, idnumber, bankcard, phone, password);
        }
        return new JsonResult<>("success");
    }

    @PostMapping("/zAddNeed")
    public JsonResult<Object> zAddNeed() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse("2021-02-13 15:31:31");
        } catch (Exception e) {
            return new JsonResult<>("1", "fail");
        }
        c.setTime(date);
        String dateString;
        Random random = new Random();
        for (int i = 0; i < 109; i++) {             //2-13到6-01的每天
            dateString = sdf.format(c.getTime());
            c.add(Calendar.DATE, 1);
            for (int j = 1; j <= 6; j++) {          //0.5年到3年
                double timelimit = j * 0.5;
                int userid = random.nextInt(126) + 2;      //userid  2--127
                double rate = fliter(2 + 0.05 * random.nextInt(41), 2); //利率2-4
                double goalmoney = (5 + random.nextInt(16)) * 10000; //金额5-20
                Map<String, Object> map = new HashMap<>();
                map.put("userid", userid);
                map.put("rate", rate);
                map.put("timelimit", timelimit);
                map.put("goalmoney", goalmoney);
                map.put("starttime", dateString);
                needMapper.zsetNewNeed(map);
            }
        }
        return new JsonResult<>("success");
    }

    @PostMapping("/zAddProvide")
    public JsonResult<Object> zAddProvide() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse("2021-02-13 15:31:31");
        } catch (Exception e) {
            return new JsonResult<>("1", "fail");
        }
        c.setTime(date);
        String dateString;
        Random random = new Random();
        for (int i = 0; i < 109; i++) {             //2-13到6-01的每天
            dateString = sdf.format(c.getTime());
            c.add(Calendar.DATE, 1);
            for (int j = 1; j <= 6; j++) {          //0.5年到3年
                double timelimit = j * 0.5;
                int userid = random.nextInt(126) + 2;      //userid  2--127
                double rate = fliter(2 + 0.05 * random.nextInt(41), 2); //利率2-4
                double goalmoney = (5 + random.nextInt(16)) * 10000; //金额5-20
                Map<String, Object> map = new HashMap<>();
                map.put("userid", userid);
                map.put("rate", rate);
                map.put("timelimit", timelimit);
                map.put("goalmoney", goalmoney);
                map.put("starttime", dateString);
                needMapper.zsetNewProvide(map);
            }
        }
        return new JsonResult<>("success");
    }

    @PostMapping("/zAddSuccess")
    public JsonResult<Object> zAddSuccess() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse("2021-02-13 15:31:31");
        } catch (Exception e) {
            return new JsonResult<>("1", "fail");
        }
        c.setTime(date);
        String dateString;
        Random random = new Random();
        for (int i = 0; i < 109; i++) {             //2-13到6-01的每天
            dateString = sdf.format(c.getTime());
            c.add(Calendar.DATE, 1);

            for (int j = 0; j <= 1; j++) {
                double timelimit;
                if (j == 0) {
                    timelimit = 0.5 + 0.5 * random.nextInt(2); //0.5-1
                } else {
                    timelimit = 1.5 + 0.5 * random.nextInt(4); //1.5-3
                }
                int needid = 1 + random.nextInt(650); //1-650
                int provideid = 1 + random.nextInt(650);
                int nid = random.nextInt(126) + 2;      //userid  2--127
                int pid = random.nextInt(126) + 2;
                double rate = fliter(2 + 0.05 * random.nextInt(41), 2); //利率2-4
                String starttime = dateString;
                String endtime = getNextDateString(dateString,timelimit);
                double goalmoney = (5 + random.nextInt(16)) * 10000; //金额5-20
                double nservicefee = needService.getServicefee(goalmoney,timelimit);
                double pservicefee = provideService.getServicefee(goalmoney,timelimit);
                Map<String, Object> map = new HashMap<>();
                map.put("needid",needid);
                map.put("provideid",provideid);
                map.put("nid",nid);
                map.put("pid",pid);
                map.put("rate",rate);
                map.put("timelimit",timelimit);
                map.put("starttime",starttime);
                map.put("endtime",endtime);
                map.put("money",goalmoney);
                map.put("nservicefee",nservicefee);
                map.put("pservicefee",pservicefee);
                needMapper.addSuccess(map);
            }
        }
        return new JsonResult<>("success");
    }

    public static Random getRandom() {
        Random random = new Random();
        return random;
    }

    public static String getRandomNumberString(int length) {
        String str = "0123456789";
        Random random = getRandom();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public Double fliter(Double v, int t) {
        return new BigDecimal(v).setScale(t, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public String getNextDateString(String starttime, Double year) {
        int numMonth = (int) (year * 12);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(starttime);
        } catch (Exception e) {
            return starttime;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, numMonth);
        return sdf.format(c.getTime());
    }
}

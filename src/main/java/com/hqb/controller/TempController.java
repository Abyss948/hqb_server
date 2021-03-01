package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.testChain.BlockChainTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.RemoteFunctionCall;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TempController {
    @GetMapping("/temp1")
    public JsonResult<Object> temp1() throws Exception {

        Map<String,Object> map = new HashMap<>();
        BigInteger id =new BigInteger("99");
        BigInteger balance =new BigInteger("299");
        BlockChainTest.loadContract(id,balance);
        return new JsonResult<>(map,"success");
    }

    @GetMapping("/temp2")
    public JsonResult<Object> temp2() throws Exception {

        Map<String,Object> map = new HashMap<>();
        BigInteger id =new BigInteger("99");
        RemoteFunctionCall<BigInteger> bigIntegerRemoteFunctionCall = BlockChainTest.getinfoContract(id);

        map.put("this", bigIntegerRemoteFunctionCall.send());
        return new JsonResult<>(map,"success");
    }
}

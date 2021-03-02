package com.hqb.testChain;
import lombok.extern.slf4j.Slf4j;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Slf4j(topic = "c.BlockChainTest")
public class BlockChainTest {
    public static void main() throws Exception {
        loadContract(new BigInteger("1"), new BigInteger("0"));
    }

    //加载已经在链上的合约，并且调用方法
    public static void loadContract(BigInteger _id, BigInteger _balance) throws Exception {
        //建立私链连接，infura节点
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/9e238311088f45db8823a1e563af522a"));
        //加载钱包账户,需要从geth的data文件中拷贝出来keysotre文件夹里的内容
        Credentials credentials = WalletUtils.loadCredentials("123456", "src/main/resources/templates/UTC--2021-03-01T12-50-59.510320200Z--5440d6424be0cfa01edd3f255ac49f5dfaecc45b.json");
        //加载合约
        String contractAddr = "0x633809f97ecB9A1f7b53D87eEE9E5Ac0f4F10823";//合约地址
        AWMain contract = AWMain.load(contractAddr, web3j, credentials, BigInteger.valueOf(3000000), BigInteger.valueOf(3000000));
        log.debug("{}",contract);
        BigInteger id=_id;
        BigInteger balance=_balance;
        contract._setbalance(id,balance);
    }

    public static RemoteFunctionCall<BigInteger> getinfoContract(BigInteger _id) throws Exception {
        //建立私链连接，infura节点
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/9e238311088f45db8823a1e563af522a"));
        //加载钱包账户,需要拷贝出来walllet文件夹里的内容
        Credentials credentials = WalletUtils.loadCredentials("123456", "src/main/resources/templates/UTC--2021-03-01T12-50-59.510320200Z--5440d6424be0cfa01edd3f255ac49f5dfaecc45b.json");
        //加载合约
        String contractAddr = "0x633809f97ecB9A1f7b53D87eEE9E5Ac0f4F10823";//合约地址
        AWMain contract = AWMain.load(contractAddr, web3j, credentials, BigInteger.valueOf(3000000), BigInteger.valueOf(3000000));
        log.debug("{}",contract);
        BigInteger id=_id;
        return contract._getinfo(id);
    }

}
package com.hqb.testChain;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class AWMain extends Contract {
    private static final String BINARY = "6080604052602060405190810160405280600060ff16815250600090600161002892919061003b565b5034801561003557600080fd5b506100a6565b82611f3f8101928215610070579160200282015b8281111561006f578251829060ff1690559160200191906001019061004f565b5b50905061007d9190610081565b5090565b6100a391905b8082111561009f576000816000905550600101610087565b5090565b90565b610124806100b56000396000f3006080604052600436106049576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806319dba38914604e578063b6ceb978146082575b600080fd5b348015605957600080fd5b506080600480360381019080803590602001909291908035906020019092919050505060c0565b005b348015608d57600080fd5b5060aa6004803603810190808035906020019092919050505060dc565b6040518082815260200191505060405180910390f35b80600060018401611f3f8110151560d357fe5b01819055505050565b60008060018301611f3f8110151560ef57fe5b015490509190505600a165627a7a723058204e423ea158fec39c0744126d7bd667897131e1242c2d2354011df59ff9f351d70029";

    public static final String FUNC__SETBALANCE = "_setbalance";

    public static final String FUNC__GETINFO = "_getinfo";

    @Deprecated
    protected AWMain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AWMain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AWMain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AWMain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> _setbalance(BigInteger _id, BigInteger _balance) {
        final Function function = new Function(
                FUNC__SETBALANCE, 
                Arrays.<Type>asList(new Uint256(_id),
                new Uint256(_balance)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> _getinfo(BigInteger _id) {
        final Function function = new Function(FUNC__GETINFO, 
                Arrays.<Type>asList(new Uint256(_id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static AWMain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AWMain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AWMain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AWMain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AWMain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AWMain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AWMain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AWMain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AWMain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AWMain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AWMain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AWMain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AWMain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AWMain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AWMain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AWMain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}

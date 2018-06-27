package client.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Marketplace extends Contract {
    private static final String BINARY = "6080604052600060025534801561001557600080fd5b5060008054600160a060020a0319163317905561079e806100376000396000f3006080604052600436106100c45763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632c28fdf881146100c95780633a84a0e2146100d65780634fa04901146100fd578063550a778b1461012e5780635f7952e9146101695780636856dbcd1461018a5780636cc7660c146101a25780638546d002146101bd5780638610f3d6146101e95780638da5cb5b146101fc578063abff011014610211578063bf0d021314610226578063f2fde38b14610247575b600080fd5b6100d4600435610268565b005b3480156100e257600080fd5b506100eb610399565b60408051918252519081900360200190f35b34801561010957600080fd5b5061011261039f565b60408051600160a060020a039092168252519081900360200190f35b34801561013a57600080fd5b506101466004356103ae565b60408051600160a060020a03909316835260208301919091528051918290030190f35b34801561017557600080fd5b506100d4600160a060020a03600435166103d3565b34801561019657600080fd5b506100d4600435610464565b3480156101ae57600080fd5b506100d46004356024356104b6565b3480156101c957600080fd5b506101d5600435610509565b604080519115158252519081900360200190f35b6100d46004803560248101910135610526565b34801561020857600080fd5b50610112610626565b34801561021d57600080fd5b50610112610635565b34801561023257600080fd5b506100d4600160a060020a0360043516610644565b34801561025357600080fd5b506100d4600160a060020a03600435166106d5565b60008181526001602052604090208054600160a060020a0316151561028c57600080fd5b600181015434101561029d57600080fd5b600480548254604080517f23b872dd000000000000000000000000000000000000000000000000000000008152600160a060020a039283169481019490945233602485015260448401869052519116916323b872dd91606480830192600092919082900301818387803b15801561031357600080fd5b505af1158015610327573d6000803e3d6000fd5b505082546001840154604051600160a060020a03909216935080156108fc029250906000818181858888f19350505050158015610368573d6000803e3d6000fd5b505060009081526001602081905260408220805473ffffffffffffffffffffffffffffffffffffffff191681550155565b60025481565b600454600160a060020a031681565b60016020819052600091825260409091208054910154600160a060020a039091169082565b600054600160a060020a03163314610435576040805160e560020a62461bcd02815260206004820152601660248201527f596f7520617265206e6f7420746865206f776e65722e00000000000000000000604482015290519081900360640190fd5b6004805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600081815260016020526040902054600160a060020a0316331461048757600080fd5b60009081526001602081905260408220805473ffffffffffffffffffffffffffffffffffffffff191681550155565b60408051808201825233815260208082019384526000948552600190819052919093209251835473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039091161783559051910155565b600090815260016020526040902054600160a060020a0316151590565b60025434811115610581576040805160e560020a62461bcd02815260206004820152601160248201527f4e6f7420656e6f756768206d6f6e65792e000000000000000000000000000000604482015290519081900360640190fd5b60048054604080517f3d02d0c9000000000000000000000000000000000000000000000000000000008152339381018481526024820192835260448201879052600160a060020a0390931693633d02d0c99390928892889291906064018484808284378201915050945050505050600060405180830381600087803b15801561060957600080fd5b505af115801561061d573d6000803e3d6000fd5b50505050505050565b600054600160a060020a031681565b600354600160a060020a031681565b600054600160a060020a031633146106a6576040805160e560020a62461bcd02815260206004820152601660248201527f596f7520617265206e6f7420746865206f776e65722e00000000000000000000604482015290519081900360640190fd5b6003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600054600160a060020a03163314610737576040805160e560020a62461bcd02815260206004820152601660248201527f596f7520617265206e6f7420746865206f776e65722e00000000000000000000604482015290519081900360640190fd5b600160a060020a0381161561076f576000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383161790555b505600a165627a7a723058207e9d28ba06d327e1544b48d5ba7b13a54130b712c973339faf38abe259843d6c0029";

    public static final String FUNC_BUYFISH = "buyFish";

    public static final String FUNC_NEWFISHPRICE = "newFishPrice";

    public static final String FUNC_FISHBASE = "fishBase";

    public static final String FUNC_SALEOF = "saleOf";

    public static final String FUNC_SETFISHBASE = "setFishBase";

    public static final String FUNC_REMOVEFISHSELL = "removeFishSell";

    public static final String FUNC_OFFERFISH = "offerFish";

    public static final String FUNC_ISFORSALE = "isForSale";

    public static final String FUNC_BUYNEWFISH = "buyNewFish";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_BROKER = "broker";

    public static final String FUNC_SETBROKER = "setBroker";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event SALE_EVENT = new Event("Sale", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected Marketplace(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Marketplace(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> buyFish(BigInteger _tokenId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYFISH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> newFishPrice() {
        final Function function = new Function(FUNC_NEWFISHPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> fishBase() {
        final Function function = new Function(FUNC_FISHBASE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple2<String, BigInteger>> saleOf(BigInteger param0) {
        final Function function = new Function(FUNC_SALEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setFishBase(String _newAddress) {
        final Function function = new Function(
                FUNC_SETFISHBASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeFishSell(BigInteger _tokenId) {
        final Function function = new Function(
                FUNC_REMOVEFISHSELL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> offerFish(BigInteger _tokenId, BigInteger _price) {
        final Function function = new Function(
                FUNC_OFFERFISH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isForSale(BigInteger _tokenId) {
        final Function function = new Function(FUNC_ISFORSALE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> buyNewFish(String _name, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYNEWFISH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> broker() {
        final Function function = new Function(FUNC_BROKER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setBroker(String _newAddress) {
        final Function function = new Function(
                FUNC_SETBROKER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Marketplace> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Marketplace.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Marketplace> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Marketplace.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<SaleEventResponse> getSaleEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SALE_EVENT, transactionReceipt);
        ArrayList<SaleEventResponse> responses = new ArrayList<SaleEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SaleEventResponse typedResponse = new SaleEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.price = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SaleEventResponse> saleEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SaleEventResponse>() {
            @Override
            public SaleEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SALE_EVENT, log);
                SaleEventResponse typedResponse = new SaleEventResponse();
                typedResponse.log = log;
                typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.price = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SaleEventResponse> saleEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SALE_EVENT));
        return saleEventObservable(filter);
    }

    public static Marketplace load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Marketplace(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Marketplace load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Marketplace(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class SaleEventResponse {
        public Log log;

        public String seller;

        public String buyer;

        public BigInteger tokenId;

        public BigInteger price;
    }
}
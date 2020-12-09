package com.btc.connect;


import org.apache.http.HttpStatus;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//Service: 服务
public class BTCService {

    private static  Map<String, String> map = new HashMap();
    static {
        map.put("Authorization","Basic "+BcRPCUtils.base64Encode(Constants.RPCUSER+":"+Constants.RPCPASSWOED));
    }

    //获取当前区块的
    public void getBlockChainInfo(){
        String json = BcRPCUtils.prepareJSON("getblockchaininfo");
        Result result = BcRPCUtils.sendPost(map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return;
        }
    }

    public String getBestBlockHash(){
        String json = BcRPCUtils.prepareJSON("getbestblockhash");
        Result result = BcRPCUtils.sendPost(map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;

    }

    //获取比特币节点的区块总数
    public int getBlockCount() {
        String json = BcRPCUtils.prepareJSON("getblockcount");
        Result result = null;
        result = BcRPCUtils.sendPost(map, json);
        //System.out.println(result.getCode());
        if (result.getCode() == HttpStatus.SC_OK) {
           String countStr = result.getData().getResult();
           int count = Integer.parseInt(countStr);
           return count;
        }else {
            return -1;
        }
    }
}

package com.btc.connect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.btc.connect.entity.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

//service：服务
//rpc服务：命令
public class BTCService {

    private static Map<String, String> map = new HashMap();

    static {
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
    }



    //新需求：生成比特币的地址

    /**
     * 生成一个新的比特币对的地址
     *
     */
    public String getNewAddress(String label,ADDRES_TYPE address_type) {
        String type = Constants.getAddressType(address_type);
        String json = BcRPCUtils.prepareJSON(Constants.GETNEWADDRESS, label, address_type);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 根据区块hash值获取指定区块的信息
     *
     * @param hash 区块的hash
     * @return 区块的信息，查询失败返回null
     */
    public BlockData getBlockByHash(String hash) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCK, hash);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return JSON.parseObject(result.getData().getResult(), BlockData.class);
        }
        return null;
    }

    /**
     * 获取指定高度的区块的hash值
     *
     * @param height 指定高度
     * @return 区块的hash值，请求失败返回null
     */
    public String getBlockHashByHeight(int height) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKHASH, height);
       // System.out.println(json);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }


    /**
     * 获取当前区块链的信息
     * 命令：getblockchaininfo
     *
     * @return 返回查询节点的区块链的信息，查询失败返回null
     */
    public BlockChainInfo getBlockChainInfo() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCHAININFO);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {//正常
            String info = result.getData().getResult();
            return JSON.parseObject(info, BlockChainInfo.class);
        }
        return null;
    }


    /**
     * 获取最新区块的hash值
     *
     * @return 返回最新区块的hash，查询失败返回null
     */
    public String getBestBlockHash() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBESTBLOCKHASH);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 获取比特币节点的区块总数
     *
     * @return 返回比特币节点的区块总数，int类型
     */
    public int getBlockCount() {
        //1.json
        //2.post请求
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCOUNT);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null) {
            return -1;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String countStr = result.getData().getResult();
            return Integer.parseInt(countStr);
        } else {
            return -1;//-1代表查询失败
        }
    }

    //命令ping
    public String ping(String ping) {
        String json = BcRPCUtils.prepareJSON(Constants.PING);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return ping;
        }
        return null;
    }

    //获取余额
    public Balance getBalance() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBALANCES);
        Result result = BcRPCUtils.sendPost(map, json);
        if (result == null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String  getbalance = result.getData().getResult();
            return JSON.parseObject(getbalance, Balance.class);
        }
        return null;
    }

    //获取链接提示
    public String getChainTips(){
        String tips = BcRPCUtils.prepareJSON(Constants.GETCHAINTIPS);
        Result result = BcRPCUtils.sendPost(map, tips);
        if (result == null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String  getchaintips = result.getData().getResult();
            return getchaintips;
        }
        return null;
    }

    //连接总数
    public String getConnectionCount(){
        String json = BcRPCUtils.prepareJSON(Constants.GETCOUNNECTIONCOUNT);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }

    //添加的节点信息
    public JSONObject getAddedNodeInfo(String node){
        String json = BcRPCUtils.prepareJSON(Constants.GETADDEDNODEINFO,node);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSON.parseObject(result.getData().getResult());
        }
        return null;
    }

    //内存池信息
    public String getMemPoolInfo(){
        String json = BcRPCUtils.prepareJSON(Constants.GETMEMPOOLINFO);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            String  info= result.getData().getResult();
            return info;
        }else{
            return null;
        }
    }

    //区块过滤
    public JSONObject getBlockFilter(String blockHash , String filterType){
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKFILTER,blockHash,filterType);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            String filter = result.getData().getResult();
            return JSONObject.parseObject(filter);
        }
        return null;
    }

    //通过txoutset信息得到的高度
    public JSONObject getTxOutsetInfo(){
        String json = BcRPCUtils.prepareJSON(Constants.GETTXOUTSETINFO);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result ==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSONObject.parseObject(result.getData().getResult());
        }
        return null;
    }
}

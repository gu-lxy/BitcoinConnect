package com.btc.connect;

import com.btc.connect.entity.Balance;

/**
 * 常量
 */
public class Constants {
    //rpc服务协议
    public static final String RPCUSER = "user";//rpc用户名
    public static final String RPCPASSWORD = "pwd";//rpc用户密码
    public static final String RPCURL = "http://127.0.0.1:8333";//rpc的链接
    //地址类型
    public static final String ADDRESS_LEGAGCY = "legacy";
    public static final String ADDRESS_P2SH_SEGWIT = "p2sh-segwit";
    public static final String ADDRES_BECH32 = "bech32";
    //rpc服务命令
    //获取区块的总数
    public static final String GETBLOCKCOUNT = "getblockcount";
    //获取最新区块的hash
    public static final String GETBESTBLOCKHASH = "getbestblockhash";
    //获取区块信息
    public static final String GETBLOCKCHAININFO = "getblockchaininfo";
    //获取新的区块的高度
    public static final String GETBLOCKHASH = "getblockhash";
    //获取新的区块
    public static final String GETBLOCK = "getblock";
    //获取新地址
    public static final String GETNEWADDRESS = "getnewaddress";
    //平，声音
    public static final String PING = "ping";
    //获取余额
    public static final String GETBALANCES = "getbalances";
    //获取链接提示
    public static final String GETCHAINTIPS = "getchaintips";
    //连接总数
    public static final String GETCOUNNECTIONCOUNT ="getconnectioncount";
    //添加的节点信息
    public static final String GETADDEDNODEINFO = "getaddednodeinfo";
    //获取TX内存池
    public static final String GETMEMPOOLINFO = "getmempoolinfo";
    //检索特定区块
    public static final String GETBLOCKFILTER = "getblockfilter";
    //通过txoutset信息得到的高度
    public static final String GETTXOUTSETINFO="gettxoutsetinfo";
    /**
     * 该方法用于根据枚举类型返回对应的比特币的类型对应的字符串
     *
     * @param type  枚举
     * @return   比特币地址类型字符串形式
     */
    public static String getAddressType(ADDRES_TYPE type) {
        switch (type) {
            case P2SH_SEGWIT:
                return ADDRESS_P2SH_SEGWIT;
            case LEGACY:
                return ADDRESS_LEGAGCY;
            case BECH32:
                return ADDRES_BECH32;
            default:
                return null;
        }
    }

}

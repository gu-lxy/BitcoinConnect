package com.btc.connect;

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
    //
    public static final String GETBLOCKHASH = "getblockhash";
    //
    public static final String GETBLOCK = "getblock";
    //
    public static final String GETNEWADDRESS = "getnewaddress";
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

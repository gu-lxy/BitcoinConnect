package com.btc.connect;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static sun.net.ftp.FtpDirEntry.Permission.USER;


public class Text {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //测试：生成一个新地址
        BTCService service = new BTCService();
        int count = service.getBlockCount();
        System.out.println("比特币节点的区块书数：" + count);
       //测试：获取最新区块的hash
        String hash = service.getBestBlockHash();
        System.out.println("最新区块的hash：" + hash);
    }
}

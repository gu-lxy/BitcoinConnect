package com.btc.connect;


import com.btc.connect.entity.Bip;
import com.btc.connect.entity.BlockChainInfo;
import com.btc.connect.entity.BlockData;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        //测试：获取区块的总数
        BTCService service = new BTCService();
        int count = service.getBlockCount();
        System.out.println("比特币节点的区块数：" + count);
        //测试:获取最新区块的hash值
        String hash = service.getBestBlockHash();
        System.out.println("最新区块的hash：" + hash);
        //测试：获取区块链节点信息
        BlockChainInfo chainInfo = service.getBlockChainInfo();
        if (chainInfo != null) {
            String chain = chainInfo.getChain();
            System.out.println(chain);
            System.out.println(chainInfo.getDifficulty());
            List<Bip> bipList = chainInfo.getSoftforks();
            //需求：取出集合中的每一个成员 -> 遍历
            for (Bip bip : bipList) {
                System.out.println(bip.getId());
            }
        }

        //测试:获取特定高度的区块的hash
        String hash0 = service.getBlockHashByHeight(0);
        System.out.println("特定高度的区块hash值:" + hash0);

        //测试：根据区块的hash值获取特定区块的信息
        BlockData data = service.getBlockByHash(hash0);
        System.out.println("结果:" + data.getHash());

        //测试：生成一个新的比特币的地址
        String address = service.getNewAddress("gjh", "ergou");
        System.out.println(address);



    }
}

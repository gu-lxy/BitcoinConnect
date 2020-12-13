package com.btc.connect;


import com.alibaba.fastjson.JSONObject;
import com.btc.connect.entity.Balance;
import com.btc.connect.entity.Bip;
import com.btc.connect.entity.BlockChainInfo;
import com.btc.connect.entity.Mine;

import java.util.List;
import java.util.Set;

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
//        BlockData data = service.getBlockByHash(hash0);
//        System.out.println("结果:" + data.getHash());

        //测试：生成一个新的比特币的地址
        String address = service.getNewAddress("gjh", ADDRES_TYPE.LEGACY);
        System.out.println(address);
        //测试,声音
        String ping = service.ping("ping");
        System.out.println(ping);
        //获取余额
        Balance balance = service.getBalance();
        System.out.println("{\"trusted\": "+balance.getMine().getImmature()+",\"untrusted_pending\":"+balance.getMine().getTrusted()+",\"immature\":"+balance.getMine().getUntrusted()+"}");
        //获取链接提示
        String getchaintips = service.getChainTips();
        System.out.println(getchaintips);
        //连接总数
        String connectionCount = service.getConnectionCount();
        System.out.println(connectionCount);
        //添加的节点信息
        JSONObject nodeinfo = service.getAddedNodeInfo("info");
        System.out.println(nodeinfo);
        //内存池信息
        String memPool = service.getMemPoolInfo();
        System.out.println(memPool);
        //区块过滤
        JSONObject blockFilter = service.getBlockFilter("blockhash",("filtertype"));
        System.out.println(blockFilter);
        //通过txoutset信息得到的高度
        JSONObject txoutset = service.getTxOutsetInfo();
        System.out.println(txoutset);
    }
}


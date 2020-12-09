package com.btc.connect;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.btc.connect.BcRPCUtils.base64Encode;

public class BTCConnect {
    //RPC服务的用户名，应该与比特币客户端节点的配置文件bitcoin.conf中配置的一样
    private static final String RPCUSER = "user";
    //RPC服务的用户密码，应该与比特币客户端节点的配置文件bitcoin.conf中配置的一样
    private static final String RPCPASSWORD = "pwd";
    private static final String RPCURL = "http://127.0.0.1:8332";

    //maven：管理和构建项目的依赖和配置
    //依赖的配置：xml文件
    //例如：配置mysql数据库
    //
    public static void main(String[] args) {
        System.out.println("hello world");

        /**
         * 1、准备json-rpc通信的json数据
         *      fastjson.jar
         * 2、使用java网络通信进行rpc链接
         *      httpclient、httpcore
         *      请求类型：GET、POST、
         * 3、接收java中的http形式的rpc链接的响应
         * 4、处理结果
         */

        JSONObject object = new JSONObject();
        object.put("id", System.currentTimeMillis() + "");
        object.put("jsonrpc", "2.0");//rpc服务协议版本
        object.put("method", "getblockcount");
//        object.put("params","");//调用命令的传参
//        object.put("Authorization", "Basic " + base64Encode(RPCUSER + ":" + RPCPASSWORD));

        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

        //2、发起一个post类型的网络请求，将第一步准备好的json格式数据发送给rpc服务器
        //tcp三次握手：client -> server(rpc服务)
        DefaultHttpClient client = new DefaultHttpClient();
        //www.baidu.com -> dns,ip
        HttpPost post = new HttpPost(RPCURL);
        //client执行一个post的请求
        try{
            //设置请求头
            post.addHeader("Encoding","UTF-8");
            post.addHeader("Content-Type","appliction/jison");
            post.addHeader("Authorization","Basic "+base64Encode(RPCUSER+":"+RPCPASSWORD));
            //entity: 实体,
            StringEntity entity = new StringEntity(jsonRpcStr);
            post.setEntity(entity);//设置请求数据
            HttpResponse response = client.execute(post);
            //请求状态码, 200是成功
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                //UNAUTHORIZED:401 未被授权
                System.out.println("rpc请求连接成功");
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }else{
                System.out.println("rpc请求连接失败,状态码："+code);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

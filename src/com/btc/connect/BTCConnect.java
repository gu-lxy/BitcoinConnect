package com.btc.connect;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.btc.connect.BcRPCUtils.base64Encode;

public class BTCConnect {

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
        object.put("method", "getblockhash");
//        object.put("method", "getblockhash");
        int[] arr = new int[1];
        arr[0] = 0;
        object.put("params", arr);//调用命令时的传参

        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

        //2、发起一个post类型的网络请求，将第一步准备好的json格式数据发送给rpc服务器
        //tcp三次: client -> server(rpc服务）
        DefaultHttpClient client = new DefaultHttpClient();
        //www.baidu.com -> dns,ip
        HttpPost post = new HttpPost(Constants.RPCURL);
        //client执行一个post请求
        try {
            //设置请求头
            post.addHeader("Encoding", "UTF-8");
            post.addHeader("Content-Type", "application/json");
            post.addHeader("Authorization", "Basic " + base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
            //entity：实体，
            StringEntity entity = new StringEntity(jsonRpcStr);
            post.setEntity(entity);//设置请求的数据
            HttpResponse response = client.execute(post);//执行网络，阻塞在当前行
            //请求状态码 200是OK
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                System.out.println("rpc请求连接成功");
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            } else {
                System.out.println("rpc请求连接失败，状态码是：" + code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

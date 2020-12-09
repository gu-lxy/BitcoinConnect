package com.btc.connect;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        //Map: Key --> Value
        Map<String, String> map = new HashMap();
        //向map中存数据
        map.put("name","傻瓜");
        map.put("age","18");
        map.put("sex","male");

        //从map中取数据，如何取出全部
//        for(int i=0;i<map.size();i++){
//            Object o = map.get(i);
//            System.out.println(o);
        //for循环在Java中无法遍历，因为map是无序的

        //取出单个
        String name = map.get("name");
        System.out.println(name);

        Set<String> keys = map.keySet();//把全部的key取出来

        //通过keys循环取key
        for (String key : keys) {
            System.out.println(key);
            String value = map.get(key);//根据key取值
            System.out.println(value);
        }
    }
}

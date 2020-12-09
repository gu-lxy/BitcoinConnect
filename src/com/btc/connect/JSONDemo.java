package com.btc.connect;

import com.alibaba.fastjson.JSONObject;
import java.rmi.StubNotFoundException;

public class JSONDemo {
    public static void main(String[] args) {
        System.out.println("hello world");
        Student student = new Student();
        student.setName("隔壁老王");
        student.setAge(18);
        student.setSex("male");

        System.out.println("学生姓名：" + student.name);
        System.out.println("学生年龄：" + student.age);
        System.out.println("学生性别：" + student.sex);

        //序列化操作
        JSONObject object = (JSONObject) JSONObject.toJSON(student);
        String objStr = object.toJSONString();
        System.out.println(objStr);

        //反序列化操作
        Student laowang = JSONObject.parseObject(objStr, Student.class);
        System.out.println(laowang.name);

        //第二种序列化的方式
        //例如：实例化一个程序员实例json格式
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "于洪伟");
        jsonObject.put("sex", "男");
        jsonObject.put("slgan", "我变秃了，也变强了!");
        jsonObject.put("languages", "java,go,python");
        String coderJson = jsonObject.toJSONString();
        System.out.println(coderJson);
    }

    static class Student {
        private String name;//姓名
        private int age;//年龄
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}

package com.example.springjpa.serialize;

import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectInput;
import org.apache.dubbo.common.serialize.hessian2.Hessian2ObjectOutput;
import org.apache.dubbo.common.serialize.hessian2.Hessian2Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 兼容性较好,即使新增字段序列化也可以
 * 跨语言 扩展好，性能较低于kryo(为什么）序列化方式不同feild+compation
 */
public class HessianMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Hessian2Serialization hessian2Serialization=new Hessian2Serialization();
        //seriliaze();
        unseialize();
    }


    public static void seriliaze() throws IOException {
        DemoVo demoVo=new DemoVo("2");
        ConcurrentHashMap chm=new ConcurrentHashMap();
        chm.put("123","abc");
        demoVo.setHashMap(chm);
        ArrayList list=new ArrayList<>();
        list.add("222");
        demoVo.setList(list);
        LinkedHashMap lhm =new LinkedHashMap();
        lhm.put("a",1);
        demoVo.setLinkedHashMap(lhm);

        DemoChildVo demoChildVo=new DemoChildVo();
        demoChildVo.setHashMap(chm);
        ArrayList list3=new ArrayList<>();
        list3.add("444");
        demoChildVo.setListchild(list3);
        demoVo.setDemoChildVo(demoChildVo);

        OutputStream outputStream=new FileOutputStream("demo.txt");
        Hessian2ObjectOutput objectOutput=new Hessian2ObjectOutput(outputStream);

        objectOutput.writeObject(demoVo);

        objectOutput.flushBuffer();
        outputStream.close();
    }

    public static void unseialize() throws IOException, ClassNotFoundException {
        Hessian2ObjectInput objectOutput=new Hessian2ObjectInput(new FileInputStream("demo.txt"));
        DemoVo demoVo=objectOutput.readObject(DemoVo.class);
        System.out.println(demoVo.toString());
    }
}

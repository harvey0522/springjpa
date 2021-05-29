package com.example.springjpa.athic;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * -XX:MetaspaceSize=3m -XX:MaxMetaspaceSize=3m -Xms3m -Xmx3m
 * 打印内存结构
 */
public class CurrentHashMapDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
                 current()       ;

    }

    public static void current(){
        ConcurrentHashMap chm =new ConcurrentHashMap();

        Thread t1=new Thread(()->{
            for(int i=0;i<200000;i++){
                Thread.yield();
                chm.put("age"+i,"lisi"+i);
            }
        },"t1");
        t1.start();

        Thread t2=new Thread(()->{
            for(int i=0;i<200000;i++){
                /*try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                chm.put("name"+i,"zhangsan"+i);
            }
        },"t2");
        t2.start();

        Thread t3=new Thread(()->{
            for(int i=0;i<200000;i++){
                Thread.yield();
                chm.remove("age"+i);
            }
        },"t3");
        t3.start();

        Thread t4=new Thread(()->{
            for(int i=0;i<200000;i++){
                System.out.println(chm.get("name"+i));
            }
        },"t4");
        t4.start();

    }


    public static void testHashMapAndCurrentHashMap(int max){
        ConcurrentHashMap chm =new ConcurrentHashMap();
        chm.put("name","zhangsan");

        long date= System.currentTimeMillis();
        System.out.println();
        for(int i=0;i<max;i++){
            chm.put("name"+i,"zhangsan"+i);
        }
        System.out.println((System.currentTimeMillis()-date));

        long date1= System.currentTimeMillis();
        HashMap hashMap =new HashMap();
        for(int i=0;i<max;i++){
            hashMap.put("agel"+i,"lisisss"+i);
        }
        System.out.println((System.currentTimeMillis()-date1));
        /*chm.forEach((key,val)->{
            System.out.println(key.toString()+"---"+val.toString());
        });*/
        //System.out.println(chm.get("age"));
    }

    public static void get(){
        String a="abc";
        String b="bef";
        String x=a+b;//使用stringbuild.toString (new String)
        String c="abcbef";
        System.out.println(x==c);
        /**
         * StringBuilder sb =new StringBuilder();
         *         sb.append(a);
         *         sb.append("d");
         *         d=sb.toString();
         *         四步流程 完成字符串变量拼接。字符串字面量拼接正常。但实际开发过程中都是变量拼接。
         */
        /*String a="a";
        String d=a+"d";*/

        //final char[] val={'a','b','c'};
        //System.out.println(val);
    }
}

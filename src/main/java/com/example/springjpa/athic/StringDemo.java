package com.example.springjpa.athic;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * -XX:MetaspaceSize=3m -XX:MaxMetaspaceSize=3m -Xms3m -Xmx3m
 * 打印内存结构
 */
public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        String comp="1";
        Comparable<? super String> sort= (Comparable<? super String>) comp;

        //int s = ((Comparable<?>) sort).compareTo();
        //System.out.println(s);

        StringBuilder sb=new StringBuilder();
        int i=0;
        //1个字符 两字节 1m 2m 8k 1k 1k。
        String a="我是你的好朋友没有一";//30 byte 300次 6kb
        //String a="@2";
        System.out.println("------->>"+a.getBytes().length);
        while(i<100000){
            sb.append(a);
            i++;
        }
        //Thread.sleep(600000);
        String stringpool=sb.toString();
        System.out.println(stringpool.getBytes().length);
        sb=null;
        stringpool.intern();

    }
}

package com.example.springjpa.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Common {
    public static void main(String[] args) {
        System.out.println(16&15);
        final char[] ar={'b','a','1'};
        ar[0]='c';
        System.out.println("----><"+Arrays.toString(ar));
        StringBuilder sb=new StringBuilder("234");
        StringBuilder sb2=sb;
        System.out.println("----><"+sb2.toString());
        Object oj=null;
        sb.append(oj);
        System.out.println("----><"+sb2.toString());
        /*List arrayList=new ArrayList(5);
        arrayList.add("123");
        *//*arrayList.add(new Object());
        arrayList.add(new int[2]);*//*
        arrayList.add(2,"111");
        arrayList.add(1,new Byte(String.valueOf(127)));
        arrayList.add(0,new Integer(1));
        arrayList.add(0,new Integer(1));*/
        System.out.println("........");
    }
}

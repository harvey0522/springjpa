package com.example.springjpa.test;

import java.util.Arrays;
import java.util.HashMap;

public class Common1 {
    public static void main(String[] args) {
        System.out.println(16<<2);

        HashMap hashMap=new HashMap();
        for(int i=1;i<17;i++) {
            int a=16<<i;
            hashMap.put(a,a);
        }
        hashMap.put(1,1);
        hashMap.put(17,17);
        hashMap.put(49,49);
        hashMap.put(113,49);
        System.out.println("........");
        HashMap hashMap1= (HashMap) hashMap.clone();
        System.out.println(hashMap.hashCode());
        System.out.println(hashMap1.get(32));
    }
}

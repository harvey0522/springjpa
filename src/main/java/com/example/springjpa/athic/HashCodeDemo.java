package com.example.springjpa.athic;

import java.util.*;


public  class HashCodeDemo {
    //31*hashcode+object.hashCode;
    private String a=new String("abc");
    private String b="def";
    private static HashMap hashMap=new HashMap();
    //1607521710
    public void getName(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeDemo that = (HashCodeDemo) o;
        return Objects.equals(a, that.a) && Objects.equals(b, that.b);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(a, b,hashMap);
    }*/

    public static void main(String[] args) {
        //test1(new int[]{1,2,3});
        //test2();

        TreeSet treeMap=new TreeSet();
        treeMap.add(1);
        treeMap.add("a");
        treeMap.add(true);

        treeMap.forEach(key-> System.out.println(key));
    }


    public static void test2(){
        int[][] array = new int[64 * 1024][1024];
        long curr=System.currentTimeMillis();

// 横向遍历
        for(int i = 0; i < 64 * 1024; i ++)
            for(int j = 0; j < 1024; j ++)
                array[i][j] ++;
        System.out.println(System.currentTimeMillis()-curr);
        curr=System.currentTimeMillis();
// 纵向遍历
        for(int i = 0; i < 1024; i ++)
            for(int j = 0; j < 64 * 1024; j ++)
                array[j][i] ++;
        System.out.println(System.currentTimeMillis()-curr);
    }

    public static void test1(int ...x){

        HashMap map=new HashMap();
        int a=1;
        while (a<2000){
            map.put("bcd"+a,2);

            a++;
        }

       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Thread th=new Thread(()->{int i=1;
            while (i<500){
                map.put("abc"+i,2);
                Thread.yield();
                i++;
            }

        },"t1");

        th.start();

        Thread th1=new Thread(()->{
            map.get(1);
            Set<Map.Entry> set= map.entrySet();
           Iterator<Map.Entry> iterator= set.iterator();
           while (iterator.hasNext()){
               try {
                   Thread.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(iterator.next().getKey());
           }
            /*map.forEach((key,val)->{
                System.out.println(key);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });*/
        },"t2");
        th1.start();
    }

    public void test1(){
        byte a=-1;
        System.out.println(a>>>1);//不考虑符号位 变为整数。
        System.out.println(a<<2);//符号位不变 如果-1则 右移无变化 右移除以2 左移乘以2.
        HashCodeDemo hc=new HashCodeDemo();
        HashCodeDemo hc1=new HashCodeDemo();
        System.out.println(hc.hashCode());
        System.out.println(hc1.hashCode());

        char[] chars={};
        System.out.println(chars.hashCode());
        hashMap.put(hc,"123");
        hashMap.put(hc,"123");

        System.out.println(hashMap.hashCode());

        System.out.println((131072>>>16));
        System.out.println((65537^(65537>>>16)));
        System.out.println((65538^(65538>>>16)));
        System.out.println((131072^(131072>>>16)));
        System.out.println((131073^(131073>>>16)));
        System.out.println((610010^(610010>>>16)) & 15);
    }
}

package com.example.springjpa.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnsafeDemo {
    private String name;
    private double age;
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, NoSuchMethodException, NoSuchFieldException {
        Class<?> unsafecls=Class.forName("sun.misc.Unsafe");
        System.out.println(Unsafe.ADDRESS_SIZE);
        System.out.println(unsafecls.getName());
        Constructor constructors=unsafecls.getDeclaredConstructor(null);
        constructors.setAccessible(true);
        Unsafe unsafe1= (Unsafe) constructors.newInstance();
       Class unsafeDemo= UnsafeDemo.class;
        System.out.println("....name..."+unsafe1.objectFieldOffset(unsafeDemo.getDeclaredField("name")));
        System.out.println("...."+unsafe1.objectFieldOffset(unsafeDemo.getDeclaredField("age")));
        unsafe1.unpark(Thread.currentThread());
        //unsafe1.allocateMemory(1024*1024*100);
        //Thread.sleep(600000);
        System.out.println(unsafe1.pageSize());
    }
}

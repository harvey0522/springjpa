package com.example.springjpa.athic.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) throws Throwable {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Car carimpl=new CarImpl();
        MyInvocation myInvocation=new MyInvocation();
        myInvocation.setObject(carimpl);
        Car proxys=(Car)myInvocation.createProxy();
        proxys.say("zzzz");

        Car carblack=new BlackCarImpl();
        MyInvocation myInvocation2=new MyInvocation();
        myInvocation2.setObject(carblack);
        Car proxys2=(Car)myInvocation2.createProxy();
        proxys2.stop("3333");

        //proxys.stop("000000");

        /*JTCarProxy jtCarProxy=new JTCarProxy(carimpl);
        jtCarProxy.say("999999999999");*/


        /*Method[] method=BlackCarImpl.class.getMethods();
        Object[] objs=new Object[1];
        objs[0]="11111";
        myInvocation.invoke(carimpl,method[1],objs);*/
    }
}

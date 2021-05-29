package com.example.springjpa.athic;


import com.example.springjpa.athic.proxy.CGLIBFather;
import com.example.springjpa.athic.proxy.CGlibMethodInterceptor;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBMain {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\jdProgram");

        CGlibMethodInterceptor interceptor=new CGlibMethodInterceptor();

        CGLIBFather proxy= (CGLIBFather) interceptor.createProxyCglib(CGLIBFather.class);
        proxy.sayHello(123);
    }
}

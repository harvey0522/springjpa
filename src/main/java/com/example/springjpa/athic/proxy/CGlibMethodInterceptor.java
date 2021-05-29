package com.example.springjpa.athic.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("mycglib start ..");
        Object obj =methodProxy.invokeSuper(o,objects);
        System.out.println("mycglib end..");
        return obj;
    }

    public Object createProxyCglib(Class cls){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }
}

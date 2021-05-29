package com.example.springjpa.athic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocation implements InvocationHandler {

    private Object object;

    public void setObject(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始打印日志");
        Object obj=method.invoke(object,args);
        System.out.println("结束打印日志");
        return obj;
    }

    public Object createProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(),this);
    }
}

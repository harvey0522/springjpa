package com.example.springjpa.athic.proxy;

public class JTCarProxy{
    private Car car;
    public JTCarProxy(Car car){
        this.car=car;
    }
    public void say(String param) {
        System.out.println("静态代理。。。开始");
        car.say(param);
        System.out.println("静态代理。。。结束");
    }
    public void stop(String param) {

    }
}

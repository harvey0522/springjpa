package com.example.springjpa.spi;

public class SpiService2Impl implements SpiDemoService{
    @Override
    public void say(String para) {
        System.out.println("SpiService2Impl this is :"+para);
    }
}

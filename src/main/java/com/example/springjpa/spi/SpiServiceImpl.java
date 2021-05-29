package com.example.springjpa.spi;

public class SpiServiceImpl implements SpiDemoService{

    private SpiOrderService orderService;

    @Override
    public void say(String para) {
        System.out.println("SpiServiceImpl this is :"+para);
    }
}

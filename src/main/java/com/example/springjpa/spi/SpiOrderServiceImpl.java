package com.example.springjpa.spi;

public class SpiOrderServiceImpl implements SpiOrderService{
    @Override
    public void commit() {
        System.out.println("SpiOrderServiceImpl...commit");
    }
}

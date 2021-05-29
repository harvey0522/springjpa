package com.example.springjpa.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface SpiDemoService {
    public void say(String para);
}

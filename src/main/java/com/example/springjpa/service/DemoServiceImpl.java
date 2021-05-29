package com.example.springjpa.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
public class DemoServiceImpl implements DemoService{

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public void say(String name) {
        log.info("rpc service name:{}",serviceName);

    }
}

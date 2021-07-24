package com.example.springjpa.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class SpringbootRocketMq {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void send(){
        rocketMQTemplate.convertAndSend("hello world");
        log.info("3333333");
    }
}

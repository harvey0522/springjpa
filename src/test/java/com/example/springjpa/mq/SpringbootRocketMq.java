package com.example.springjpa.mq;

import com.example.springjpa.SpringjpaApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
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

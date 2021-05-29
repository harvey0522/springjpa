package com.example.springjpa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListern implements ApplicationListener {
    Logger log= LoggerFactory.getLogger(MyListern.class);
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("我是MyListern-->>>>>>>>{}",event.getSource().toString());
    }
}

package com.example.springjpa.config;


import com.example.springjpa.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyAwareContext implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext.publishEvent(new ApplicationEvent("。。。自定义事件"){});
        log.info("ioc容器 :{}",applicationContext.getApplicationName());
        /*log.info("ioc web 容器:{}",applicationContext.getParent());
        ProductService productService=applicationContext.getBean(ProductService.class);
        log.info("aware productService:{}",productService);
        log.info("aware ParentBeanFactory:{}",applicationContext.getParentBeanFactory());
        log.info("applicationContext===>>>>{}",applicationContext.toString());*/
    }
}

package com.example.springjpa.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.util.EventListener;

@Configuration
@Slf4j
public class MyServletConfig {

    @Bean
    public ServletListenerRegistrationBean lisrenerForServletAttr(){

        EventListener eventListenerVar=new ServletContextAttributeListener(){
            @Override
            public void attributeAdded(ServletContextAttributeEvent scae) {
                log.info("属性添加{},{}",scae.getName(),scae.getValue());
            }

            @Override
            public void attributeRemoved(ServletContextAttributeEvent scae) {
                log.info("属性删除{},{}",scae.getName(),scae.getValue());
            }

            @Override
            public void attributeReplaced(ServletContextAttributeEvent scae) {
                log.info("属性修改{},{}",scae.getName(),scae.getValue());
            }
        };
        ServletListenerRegistrationBean slrb=new ServletListenerRegistrationBean();

        slrb.setListener(eventListenerVar);
        return slrb;
    }

    @Bean
    public ServletListenerRegistrationBean lisrenerForServlet(){
        EventListener eventListener=new ServletContextListener(){
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                ServletContext context=sce.getServletContext();

                context.setAttribute("hello","world");
                //AnnotationConfigServletWebServerApplicationContext ac=(AnnotationConfigServletWebServerApplicationContext)context.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
                //ac.close();
                log.info("ServletContextListener sevlet 初始化事件：{}",sce.toString());
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                log.info("ServletContextListener sevlet 销毁事件：{}",sce.getSource().toString());
            }
        };
        ServletListenerRegistrationBean slrb=new ServletListenerRegistrationBean();

        slrb.setListener(eventListener);
        return slrb;
    }


}

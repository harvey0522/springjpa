package com.example.springjpa.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.springjpa.entry.Product;
import com.example.springjpa.jpa.ProductJpa;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DubboService
public class ProductService implements ProductInter {
    Logger log= LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductJpa productJpa;

    @Autowired
    DruidDataSource druidDatasource;


    @Transactional
     public List<Product> query(Product product){
         Example example= Example.of(product);
         log.info("条件:{}",example);
        try {
           return productJpa.findAll(example);
        }catch (Exception exception){
            log.error(">>>>>",exception);
        }

       return null;
    }

    public Product get(Integer id){
        return productJpa.findById(id).get();
    }

    @Transactional
    public  void update(Product product){
        productJpa.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  int delete(Integer id){
        log.info("druidDatasource:---->>>>{}",druidDatasource.toString());
        log.info("条件:{}",id);
        try {
            productJpa.deleteById(id);
            return 0;
        }catch (Exception exception){
            log.error(">>>>>",exception);
            return -1;
        }
    }
}

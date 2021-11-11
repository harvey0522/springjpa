package com.example.springjpa.web;


import com.example.springjpa.entry.ConsignmentCommodity;
import com.example.springjpa.entry.Product;
import com.example.springjpa.jpa.ConsignmentCommodityJpa;
import com.example.springjpa.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@Slf4j
public class CommodityController {

    //@Qualifier("productService")
    @Autowired
    ConsignmentCommodityJpa consignmentCommodityJpa;

    @RequestMapping("/commodity/add")
    public String add(ConsignmentCommodity product){
        ConsignmentCommodity add=new ConsignmentCommodity();
        BeanUtils.copyProperties(product,add);
        add.setCommodityNo(UUID.randomUUID().toString());
        add.setConsignmentNo(UUID.randomUUID().toString());
        add.setCreateTime(new Date());
        add.setModifyTime(new Date());
        add.setDelFlag((byte)0);
        SnowflakeShardingKeyGenerator snow=new SnowflakeShardingKeyGenerator();
        System.out.println();
        Random random=new Random();
        int i = random.nextInt(5);
        Long id = (Long) snow.generateKey()-i;
        System.out.println("ddddddddddddd:"+id);
        add.setId(id);
        consignmentCommodityJpa.save(add);
        return "";
    }

    @RequestMapping("/commodity/{id}")
    public ConsignmentCommodity query(@PathVariable(value = "id") Long id){
        return consignmentCommodityJpa.getOne(id);
    }
}

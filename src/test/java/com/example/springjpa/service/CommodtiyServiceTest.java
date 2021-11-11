package com.example.springjpa.service;

import com.alibaba.fastjson.JSONObject;
import com.example.springjpa.entry.ConsignmentCommodity;
import com.example.springjpa.jpa.ConsignmentCommodityJpa;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CommodtiyServiceTest {
    
    @Resource
    private ConsignmentCommodityJpa consignmentCommodityJpa;
    
    @Test
    public void testGet(){
        List<Long> ids=new ArrayList<>();
        ids.add(3l);
        ids.add(4l);
        ids.add(5l);
        ids.add(6l);
        System.out.println("......"+JSONObject.toJSONString(consignmentCommodityJpa.findAllById(ids)));



    }
    @Test
    public void getPage(){
        Page<ConsignmentCommodity> all = consignmentCommodityJpa.findAll(PageRequest.of(0, 15));
        all.get().forEach(data->{
            log.info(JSONObject.toJSONString(data));
                }

                );
        log.info("sss:{}",all.getTotalElements());
    }

    @Test
    public void add(){
        ConsignmentCommodity add=new ConsignmentCommodity();
        add.setCommodityNo(UUID.randomUUID().toString());
        add.setConsignmentNo(UUID.randomUUID().toString());
        add.setCreateTime(new Date());
        add.setModifyTime(new Date());
        add.setDelFlag((byte)0);
        SnowflakeShardingKeyGenerator snow=new SnowflakeShardingKeyGenerator();
        System.out.println();
        Long id = (Long) snow.generateKey();
        System.out.println("ddddddddddddd:"+id);
        add.setId(id);
        ConsignmentCommodity save = consignmentCommodityJpa.saveAndFlush(add);

        log.info("sss:{}",JSONObject.toJSONString(save));
    }

    @Test
    public void testGetOne(){
        ConsignmentCommodity one = consignmentCommodityJpa.getOne(4l);
        log.info(JSONObject.toJSONString(one));
    }
}

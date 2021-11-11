package com.example.springjpa.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@Slf4j
@ComponentScan(basePackages = "com.xb.dubbo.spring")
@Configuration
@EnableTransactionManagement
//@PropertySource(value={"classpath:application.properties"})
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.url1}")
    private String url1;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pwd;
    @Value(("${spring.datasource.filters}"))
    private String filters;

    @Bean
    public DataSource dateSource(){
        try {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setDriverClassName(driver);
        dataSource1.setUrl(url);
        dataSource1.setUsername(user);
        dataSource1.setPassword(pwd);
        dataSource1.setFilters(filters);
        dataSourceMap.put("dev",dataSource1);


        /*DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName(driver);
        dataSource2.setUrl(url1);
        dataSource2.setUsername(user);
        dataSource2.setPassword(pwd);
        dataSourceMap.put("dev1",dataSource2);*/


        // 配置Order表规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("t_consignment_commodity","dev.t_consignment_commodity${0..1}");

        // 配置分库 + 分表策略
        //orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("age", "dev${age % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "t_consignment_commodity${id % 2}"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
        shardingRuleConfig.setDefaultKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE","id"));
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(">>>>>>"+e.getMessage());
        }
        return null;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dateSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dateSource());
    }

}

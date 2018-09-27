package com.duke.core.druid;

import javax.sql.DataSource;
 


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
 
/**
 * 多数据源，集成druid
 * @author shoje
 *
 */
@Configuration
public class DruidConfig {
//	@Bean  
//	 @ConfigurationProperties(prefix = "spring.datasource")  
//	 public DataSource druidDataSource() {  
//	     DruidDataSource druidDataSource = new DruidDataSource();  
//	     return druidDataSource;  
//	 }
//    @Bean(name = "primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
// 
//    @Bean(name = "secondaryJdbcTemplate")
//    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
//    @Bean(name = "thirdJdbcTemplate")
//    public JdbcTemplate thirdJdbcTemplate(@Qualifier("thirdDataSource")DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
}
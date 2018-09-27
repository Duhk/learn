package com.duke.core;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Component
public class Initalized implements InitializingBean, ApplicationContextAware  {
	private ApplicationContext applicationContext;
	@Resource
	private JdbcTemplate jdbc;
	@Value("${spring.datasource.name}")
	String databaseName;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
		AppContext.setApplicationContext(applicationContext);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("初始化：对象加载中……");
		List<Map<String,Object>> tables=jdbc.queryForList("SELECT table_name from information_schema.TABLES where table_type='BASE TABLE' and table_schema=? order by table_name asc",new  Object[]{databaseName});
		for(Map<String,Object> map:tables){ 
			AppContext.crateDaoBean(map.get("table_name").toString());
		}
		System.out.println("初始化：对象加载完毕……");
	}

}

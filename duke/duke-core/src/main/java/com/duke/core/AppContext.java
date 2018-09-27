package com.duke.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import com.duke.core.action.DaoEvent;
import com.duke.core.dao.GeneratedDao;
import com.duke.core.domain.Model;

/**
 * Hello world!
 *
 */
public class AppContext{
	private static ApplicationContext applicationContext; // Spring应用上下文环境

	public static void setApplicationContext(
		ApplicationContext applicationContext) {
		AppContext.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) throws BeansException {
		return applicationContext.getBean(clazz);
	}
	
	public static <T> T getBean(String name,Class<T> clazz) throws BeansException {
		return applicationContext.getBean(name,clazz);
	}

	public static void crateDaoBean(String name) throws BeansException {
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(GeneratedDao.class);  
		
		beanDefinitionBuilder.addPropertyValue("entity",name);  
		defaultListableBeanFactory.registerBeanDefinition(name+"Dao", beanDefinitionBuilder.getBeanDefinition());  
	}

	public static void crateBean(String name,Class clazz,Map<String,Object> param) throws BeansException {
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);  
		Set<String> keys = param.keySet();
		for(String key :keys){
			beanDefinitionBuilder.addPropertyValue(key,param.get(key));  
		}
		defaultListableBeanFactory.registerBeanDefinition(name+"Dao", beanDefinitionBuilder.getBeanDefinition());  
	}
	public void refresh(){
		
	}
}

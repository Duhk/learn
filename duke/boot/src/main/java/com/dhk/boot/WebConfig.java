package com.dhk.boot;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.duke.core.Interceptor.TestInterceptor;
import com.duke.core.dao.GeneratedDao;
import com.duke.core.listener.TestListener;


@Configuration
public class WebConfig {
//	@Bean
//	public ServletRegistrationBean servletRegistrationBean() {
//		//注册servlet
//	    return new ServletRegistrationBean(new ServletTest(),"/servletTest");
//	}

//	@Bean
//	public FilterRegistrationBean<Filter> TestFilter() {
//		//注册过滤器
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		
//		TestFilter testFilter = new TestFilter();
//		registrationBean.setFilter(testFilter);
//		
//		List<String> urls = new ArrayList();
//		urls.add("/*");
//		registrationBean.setUrlPatterns(urls);
//		
//		return registrationBean;
//	}
//	
//	@Bean
//	public ServletListenerRegistrationBean<TestListener> servletListenerRegistrationBean() {
//		//注册监听器
//	    return new ServletListenerRegistrationBean<TestListener>(new TestListener());
//	}
//
	
	//拦截器配置
    @Autowired
    private TestInterceptor testInterceptor;
	@Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 添加拦截器
             * @param registry
             */
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(testInterceptor).addPathPatterns("/**");
            }
        };
    }
}
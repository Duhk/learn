package com.duke.core.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duke.core.dao.GeneratedDao;

@Controller
public class MainController {
	@Resource
	JdbcTemplate jdbc;
	private Logger log = Logger.getLogger(MainController.class);
	@RequestMapping(value = "/")  
	public String index(Map<String,Object> map){
		log.info("hello world");
		map.put("msg", "Hello Thymeleaf");
        return "index";
    }
}
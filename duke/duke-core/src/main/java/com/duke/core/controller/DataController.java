package com.duke.core.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duke.core.AppContext;
import com.duke.core.dao.GeneratedDao;

@RestController
@RequestMapping("e")
public class DataController {
	@RequestMapping(value = {"/{entity}"})  
	public List<Map<String,Object>> index1 (HttpServletRequest request,HttpSession session,@PathVariable String entity){
		GeneratedDao dao = AppContext.getBean(entity+"Dao",GeneratedDao.class);
        return dao.queryPage(0, 5);
    }
	@RequestMapping(value = "/d", method = RequestMethod.POST)  
	public Map<String,Object> index (HttpServletRequest request,HttpSession session){
        return null;
    }
}

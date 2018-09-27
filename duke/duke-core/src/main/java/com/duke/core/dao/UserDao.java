package com.duke.core.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.duke.core.ToModel;
import com.duke.core.domain.User;

public class UserDao implements IDao<User>{

	@Resource
	JdbcTemplate jdbc;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select ");
		sb.append("*,");
		sb.append("'tduke_user' as system_entity_code ");
		sb.append("from tduke_user");
        return jdbc.query(sb.toString(),new ToModel<User>());
	}

	@Override
	public List<User> queryAll(String... values) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select ");
		for(String value : values){
			sb.append(value).append(",");
		}
		sb.append("'tduke_user' as system_entity_code ");
		sb.append("from tduke_user");
		return null;
	}

	@Override
	public List<User> queryPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryPage(int page, int size, String... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}

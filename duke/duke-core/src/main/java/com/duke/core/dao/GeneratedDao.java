package com.duke.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Before;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import com.duke.core.AppContext;
import com.duke.core.action.DaoEvent;

public class GeneratedDao implements IDao<Map<String,Object>>{
	@Resource
	JdbcTemplate jdbc;

	List<Map<String,String>> keys = new ArrayList<Map<String,String>>();
	private String entity="";
	
	//查询所有
	public List<Map<String, Object>> queryAll() {
		StringBuffer sb=new StringBuffer("select ");
		sb.append("*,");
		sb.append("'" + entity + "' as system_entity_code ");
		sb.append("from ").append(entity);
		after(sb.toString());
        return jdbc.queryForList(sb.toString());
    }
	public List<Map<String, Object>> queryAll(String... values) {
		StringBuffer sb=new StringBuffer("select ");
		for(String value : values){
			sb.append(value).append(",");
		}
		sb.append("'" + entity + "' as system_entity_code ");
		sb.append("from ").append(entity);
		after(sb.toString());
        return jdbc.queryForList(sb.toString());
    }
	//分页查询
	public List<Map<String, Object>> queryPage(int page,int size) {
		StringBuffer sb=new StringBuffer("select ");
		sb.append("*,");
		sb.append("'" + entity + "' as system_entity_code ");
		sb.append("from ").append(entity);
		sb.append(" limit ").append(page*size).append(",").append(size);
		after(sb.toString());
        return jdbc.queryForList(sb.toString());
    }
	public List<Map<String, Object>> queryPage(int page,int size,String... values) {
		StringBuffer sb=new StringBuffer("select ");
		for(String value : values){
			sb.append(value).append(",");
		}
		sb.append("'" + entity + "' as system_entity_code ");
		sb.append("from ").append(entity);
		sb.append(" limit ").append(page*size).append(",").append(size);
		after(sb.toString());
        return jdbc.queryForList(sb.toString());
    }
	//查询条数
	public int getCount(){
		after("select count(*) from "+entity);
        return jdbc.queryForObject("select count(*) from "+entity,int.class);
    }
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
		
		//设置表名时根据表名获取表结构。
		SqlRowSet sqlRowSet=jdbc.queryForRowSet("select * from "+entity );
		SqlRowSetMetaData sqlRsmd =sqlRowSet.getMetaData();
		for(int i = 1;i<=sqlRsmd.getColumnCount();i++){
			Map<String, String> field = new HashMap<String, String>();
			field.put("name", sqlRsmd.getColumnName(i));
			field.put("type", String.valueOf(sqlRsmd.getColumnTypeName(i)));
			keys.add(field);
		}
	}
	
	public List<Map<String, String>> getKeys() {
		return keys;
	}
	public void setKeys(List<Map<String, String>> keys) {
		this.keys = keys;
	}
	
	private void after(String sql){
        AppContext.getApplicationContext().publishEvent(new DaoEvent(this, sql));
	}
}

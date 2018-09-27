package com.duke.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import com.duke.core.AppContext;
import com.duke.core.action.DaoEvent;

public interface IDao<T> {
	public List<T> queryAll();
	public List<T> queryAll(String... values);
	//分页查询
	public List<T> queryPage(int page,int size);
	public List<T> queryPage(int page,int size,String... values);
	//查询条数
	public int getCount();
}

package com.duke.core.action;

import org.springframework.context.ApplicationEvent;

public class DaoEvent extends ApplicationEvent{
	/**
	 *  数据库对象操作监听
	 */
	private static final long serialVersionUID = -8037023206300416550L;

	private String sql;
	public DaoEvent(Object source,String sql) {
		super(source);
		this.sql=sql;
	}
	public String getSql() {
		return sql;
	}
}
package com.duke.core.listener;

import org.springframework.context.ApplicationListener;

import com.duke.core.action.DaoEvent;

public class DaoListener implements ApplicationListener<DaoEvent> {

	@Override
	public void onApplicationEvent(DaoEvent event) {
		// TODO Auto-generated method stub
        System.out.println("Dao监听:" + event.getSql());
	}
}

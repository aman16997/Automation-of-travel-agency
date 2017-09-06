package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.DriverBean;


public interface DriverBeanDao {
	
	String createDriver(DriverBean bean);
	int deleteDriver(ArrayList<String> li);
	boolean updateDriver(DriverBean bean);
	DriverBean findByID(String UserId);
	ArrayList<DriverBean> findAll();


}

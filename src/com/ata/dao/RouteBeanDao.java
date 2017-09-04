package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.RouteBean;

public interface RouteBeanDao {

	String createVehicle(RouteBean bean);
	int deleteRoute(ArrayList<String> li);
	boolean updateCredentials(RouteBean bean);
	RouteBean findByID(String UserId);
	ArrayList<RouteBean> findAll();
}

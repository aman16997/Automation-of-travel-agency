package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.RouteBean;

public interface RouteBeanDao {

	String createRoute(RouteBean bean);
	int deleteRoute(ArrayList<String> li);
	boolean updateRoute(RouteBean bean);
	RouteBean findByID(String UserId);
	ArrayList<RouteBean> findAll();
}

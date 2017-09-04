package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.VehicleBean;



public interface VehicleBeanDao {

	String createVehicle(VehicleBean bean);
	int deleteVehicle(ArrayList<String> li);
	boolean updateCredentials(VehicleBean bean);
	VehicleBean findByID(String UserId);
	ArrayList<VehicleBean> findAll();
}

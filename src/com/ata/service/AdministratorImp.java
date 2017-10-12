package com.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public class AdministratorImp implements Administrator {

	@Override
	public String addVehicle(VehicleBean vehicleBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteVehicle(ArrayList<String> vehicleID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VehicleBean viewVehicle(String vehicleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyVehicle(VehicleBean vehicleBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String addDriver(DriverBean driverBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDriver(ArrayList<String> driverID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean allotDriver(String reservationID, String driverID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyDriver(DriverBean driverBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String addRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteRoute(ArrayList<String> routeID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RouteBean viewRoute(String routeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}

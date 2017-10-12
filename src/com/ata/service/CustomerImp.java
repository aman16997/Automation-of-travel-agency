package com.ata.service;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public class CustomerImp implements Customer {

	@Override
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RouteBean> viewAllRoutes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bookVehicle(ReservationBean reservationBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelBooking(String userID, String reservationID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReservationBean viewBookingDetails(String reservationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationBean printBookingDetails(String reservationID) {
		// TODO Auto-generated method stub
		return null;
	}

}

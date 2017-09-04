package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;

public interface ReservationBeanDao {
	
	String createVehicle(ReservationBean bean);
	int deleteReservation(ArrayList<String> li);
	boolean updateCredentials(ReservationBean bean);
	ReservationBean findByID(String UserId);
	ArrayList<ReservationBean> findAll();

}

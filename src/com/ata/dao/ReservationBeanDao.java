package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;

public interface ReservationBeanDao {
	
	String createReservation(ReservationBean bean);
	int deleteReservation(ArrayList<String> li);
	boolean updateReservation(ReservationBean bean);
	ReservationBean findByID(String UserId);
	ArrayList<ReservationBean> findAll();

}

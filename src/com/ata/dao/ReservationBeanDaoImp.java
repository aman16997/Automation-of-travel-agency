package com.ata.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.util.DBUtil;

public class ReservationBeanDaoImp implements ReservationBeanDao {

	// For Connection to database
	static Connection con = DBUtil.getConnection();

	@Override
	public String createReservation(ReservationBean bean) {

		try {
			PreparedStatement ps = con.prepareStatement("SELECT MAX(reservation) FROM ATA_TBL_ID");
			ResultSet rs = ps.executeQuery();
			rs.last();
			int max = rs.getInt(4);
			String id = bean.getUserID() + rs.getInt(4);
			System.out.println(id);

			PreparedStatement ps1 = con.prepareStatement("UPDATE ATA_TBL_ID SET RESERVATION = ? WHERE RESERVATION = ?");
			ps1.setInt(1, max + 1);
			ps1.setInt(2, max);
			int a = ps1.executeUpdate();
			System.out.println(a);

			PreparedStatement ps3 = con.prepareStatement("INSERT INTO ATA_TBL_RESERVATION (?,?,?,?,?,?,?,?,?,?,?)");
			ps3.setString(1, id);
			ps3.setString(2, bean.getUserID());
			ps3.setString(3, bean.getVehicleID());
			ps3.setString(4, bean.getRouteID());
			ps3.setDate(5, (Date) bean.getBookingDate());
			ps3.setDate(6, (Date) bean.getJourneyDate());
			ps3.setString(7, bean.getDriverID());
			ps3.setString(8, bean.getBookingStatus());
			ps3.setDouble(9, bean.getTotalFare());
			ps3.setString(10, bean.getBoardingPoint());
			ps3.setString(11, bean.getDropPoint());
			int result = ps3.executeUpdate();

			if (result > 0) {
				return "Reservation Booked";
			} else {
				return "Reservation is not Booked";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}

	@Override
	public int deleteReservation(ArrayList<String> li) {
		String id = li.get(0);

		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM ATA_TBL_RESERVATION WHERE RESERVATIONID = ?");
			ps.setString(1, id);
			int a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean updateReservation(ReservationBean bean) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ATA_TBL_RESERVATION SET VEHICLEID=?,ROUTEID=?, BOOKINGDATE=?, JOURNEYDATE=?, DRIVERID=?, BOOKINGSTATUS=?, TOTALFARE=?, BOARDINGPOINT=?, DROPPOINT=? where RESERVATIONID=?");
			ps.setString(1, bean.getVehicleID());
			ps.setString(2, bean.getRouteID());
			ps.setDate(3, (Date) bean.getBookingDate());
			ps.setDate(4, (Date) bean.getJourneyDate());
			ps.setString(5, bean.getDriverID());
			ps.setString(6, bean.getBookingStatus());
			ps.setDouble(7, bean.getTotalFare());
			ps.setString(8, bean.getBoardingPoint());
			ps.setString(9, bean.getDropPoint());
			ps.setString(10, bean.getReservationId());
			int a = ps.executeUpdate();
			if(a > 0)
				return true;
			else
				return false;	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ReservationBean findByID(String UserId) {
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_RESERVATION WHERE RESERVATIONID = ?");
			ResultSet rs = ps.executeQuery();
			rs.next();
			ReservationBean rb = new ReservationBean();
			rb.setReservationId(rs.getString(1));
			rb.setUserID(rs.getString(2));
			rb.setVehicleID(rs.getString(3));
			rb.setRouteID(rs.getString(4));
			rb.setBookingDate(rs.getDate(5));
			rb.setJourneyDate(rs.getDate(6));
			rb.setDriverID(rs.getString(7));
			rb.setBookingStatus(rs.getString(8));
			rb.setTotalFare(rs.getDouble(9));
			rb.setBoardingPoint(rs.getString(10));
			rb.setDropPoint(rs.getString(11));
			return rb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<ReservationBean> findAll() {
			ArrayList<ReservationBean> li = new ArrayList<ReservationBean>();
			
			try {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_RESERVATION");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{	
					ReservationBean rb = new ReservationBean();
					rb.setReservationId(rs.getString(1));
					rb.setUserID(rs.getString(2));
					rb.setVehicleID(rs.getString(3));
					rb.setRouteID(rs.getString(4));
					rb.setBookingDate(rs.getDate(5));
					rb.setJourneyDate(rs.getDate(6));
					rb.setDriverID(rs.getString(7));
					rb.setBookingStatus(rs.getString(8));
					rb.setTotalFare(rs.getDouble(9));
					rb.setBoardingPoint(rs.getString(10));
					rb.setDropPoint(rs.getString(11));
					li.add(rb);
					
				}
				return li;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
	}

}

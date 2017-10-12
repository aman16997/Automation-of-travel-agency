package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.RouteBean;
import com.ata.util.DBUtil;

public class RouteBeanDaoImp implements RouteBeanDao {

	// For Connection to database
	static Connection con = DBUtil.getConnection();

	@Override
	public String createRoute(RouteBean bean) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT MAX(route) FROM ATA_TBL_ID");
			ResultSet rs = ps.executeQuery();
			rs.last();
			int id = rs.getInt(5);

			PreparedStatement ps1 = con.prepareStatement("UPDATE ATA_TBL_ID SET ROUTE = ? WHERE ROUTE = ?");
			ps1.setInt(1, id + 1);
			ps1.setInt(2, id);
			int a = ps1.executeUpdate();

			PreparedStatement ps2 = con.prepareStatement("INSERT INTO ATA_TBL_ROUTE (?,?,?,?,?)");
			ps2.setString(1, id + "");
			ps2.setString(2, bean.getSource());
			ps2.setString(3, bean.getDestination());
			ps2.setInt(4, bean.getDistance());
			ps2.setInt(5, bean.getTravelDuration());
			int result = ps2.executeUpdate();

			if (result > 0)
				return "Route Created";
			else
				return "Failed";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}

	@Override
	public int deleteRoute(ArrayList<String> li) {
		String id = li.get(0);

		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM ATA_TBL_ROUTE WHERE ROUTEID = ?");
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
	public boolean updateRoute(RouteBean bean) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ATA_TBL_ROUTE SET SOURCE = ?, DESTINATION = ?, DISTANCE = ?, TRAVELDURATION = ? WHERE ROUTEID = ?");
			ps.setString(1, bean.getSource());
			ps.setString(2, bean.getDestination());
			ps.setInt(3, bean.getDistance());
			ps.setInt(4, bean.getTravelDuration());
			ps.setString(5, bean.getRouteID());
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
	public RouteBean findByID(String UserId) {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_ROUTE WHERE ROUTEID = ?");
			ps.setString(1, UserId);
			ResultSet rs = ps.executeQuery();
			RouteBean rb = new RouteBean();
			rb.setRouteID(rs.getString(1));
			rb.setSource(rs.getString(2));
			rb.setDestination(rs.getString(3));
			rb.setDistance(rs.getInt(4));
			rb.setTravelDuration(rs.getInt(5));
			return rb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<RouteBean> findAll() {
		ArrayList<RouteBean> li = new ArrayList<RouteBean>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_ROUTE");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				RouteBean rb = new RouteBean();
				rb.setRouteID(rs.getString(1));
				rb.setSource(rs.getString(2));
				rb.setDestination(rs.getString(3));
				rb.setDistance(rs.getInt(4));
				rb.setTravelDuration(rs.getInt(5));
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

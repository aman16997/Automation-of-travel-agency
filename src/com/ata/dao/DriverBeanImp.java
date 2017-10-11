package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.DriverBean;
import com.ata.util.DBUtil;

public class DriverBeanImp implements DriverBeanDao {

	// For Connection to database
	static Connection con = DBUtil.getConnection();

	@Override
	public String createDriver(DriverBean bean) {

		try {

			PreparedStatement ps = con.prepareStatement("SELECT MAX(driver) FROM ATA_TBL_ID");
			ResultSet rs = ps.executeQuery();
			rs.last();
			int max = rs.getInt(1);

			PreparedStatement ps2 = con.prepareStatement("UPDATE ATA_TBL_ID SET DRIVER = ? WHERE DRIVER = ?");
			ps2.setInt(1, max + 1);
			ps2.setInt(2, max);
			int a = ps2.executeUpdate();

			String driverId = bean.getName().substring(0, 2) + (max + 1);

			PreparedStatement ps3 = con.prepareStatement("INSERT INTO ATA_TBL_DRIVER (?,?,?,?,?,?,?,?,?)");
			ps3.setString(1, driverId);
			ps3.setString(2, bean.getName());
			ps3.setString(3, bean.getStreet());
			ps3.setString(4, bean.getLocation());
			ps3.setString(5, bean.getCity());
			ps3.setString(6, bean.getState());
			ps3.setString(7, bean.getPincode());
			ps3.setString(8, bean.getMobileNo());
			ps3.setString(9, bean.getLicenseNumber());

			int result = ps3.executeUpdate();

			if (result > 0) {
				return "Driver Created";
			} else
				return "Driver is not Created";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}

	@Override
	public int deleteDriver(ArrayList<String> li) {
		String driverId = li.get(0);

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM ATA_TBL_DRIVER WHERE DRIVERID = ?");
			ps.setString(1, driverId);
			int result = ps.executeUpdate();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean updateDriver(DriverBean bean) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ATA_TBL_DRIVER SET NAME = ?, STREET = ?, LOCATION = ?, CITY = ?, STATE = ?, PINCODE = ?, MOBILENO = ?, LICENSENUMBER = ? WHERE DRIVERID = ?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getStreet());
			ps.setString(3, bean.getLocation());
			ps.setString(4, bean.getCity());
			ps.setString(5, bean.getState());
			ps.setString(6, bean.getPincode());
			ps.setString(7, bean.getMobileNo());
			ps.setString(8, bean.getLicenseNumber());
			ps.setString(9, bean.getDriverId());
			int a = ps.executeUpdate();
			if(a > 0)
				return true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public DriverBean findByID(String UserId) {
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_DRIVER WHERE DRIVERID = ?");
			ps.setString(1, UserId);
			ResultSet rs = ps.executeQuery();
			DriverBean bean = new DriverBean();
			bean.setDriverId(rs.getString(1));
			bean.setName(rs.getString(2));
			bean.setStreet(rs.getString(3));
			bean.setLocation(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setState(rs.getString(6));
			bean.setPincode(rs.getString(7));
			bean.setMobileNo(rs.getString(8));
			bean.setLicenseNumber(rs.getString(9));	
			return bean;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<DriverBean> findAll() {
		ArrayList<DriverBean> li = new ArrayList<DriverBean>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_DRIVER");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				DriverBean db = new DriverBean();
				db.setDriverId(rs.getString(1));
				db.setName(rs.getString(2));
				db.setStreet(rs.getString(3));
				db.setLocation(rs.getString(4));
				db.setCity(rs.getString(5));
				db.setState(rs.getString(6));
				db.setPincode(rs.getString(7));
				db.setMobileNo(rs.getString(8));
				db.setLicenseNumber(rs.getString(9));
				li.add(db);
			}
			return li;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

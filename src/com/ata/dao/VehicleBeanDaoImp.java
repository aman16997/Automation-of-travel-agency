package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.VehicleBean;
import com.ata.util.DBUtil;

public class VehicleBeanDaoImp implements VehicleBeanDao {

	// For Connection to database
	static Connection con = DBUtil.getConnection();

	@Override
	public String createVehicle(VehicleBean bean) {

		try {
			PreparedStatement ps = con.prepareStatement("SELECT MAX FROM ATA_TBL_ID");
			ResultSet rs = ps.executeQuery();
			rs.last();
			int max = rs.getInt(2);

			PreparedStatement ps1 = con.prepareStatement("INSERT INTO ATA_TBL_VEHICLE (?,?,?,?,?,?)");
			ps1.setString(1, max + "1");
			ps1.setString(2, bean.getName());
			ps1.setString(3, bean.getType());
			ps1.setString(4, bean.getRegistrationNumber());
			ps1.setInt(5, bean.getSeatingCapacity());
			ps1.setDouble(6, bean.getFarePerKM());

			int result = ps1.executeUpdate();

			if (result != 0) {
				return "Vehicle Updated";
			} else {
				return "Failed";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Entered Catch";
	}

	@Override
	public int deleteVehicle(ArrayList<String> li) {
		String vehicleId = li.get(0);

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM ATA_TBL_VEHICLE WHERE VEHICLEID = ?");
			ps.setString(1, vehicleId);
			int result = ps.executeUpdate();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean updateVehicle(VehicleBean bean) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ATA_TBL_VEHICLE SET NAME = ?, TYPE = ?, REGISTRATIONNUMBER = ?, SEATINGCAPACITY=?, FAREPERKM = ? WHERE VEHICLEID = ?");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getType());
			ps.setString(3, bean.getRegistrationNumber());
			ps.setInt(4, bean.getSeatingCapacity());
			ps.setDouble(5, bean.getFarePerKM());
			ps.setString(6, bean.getVehicleID());
			int a = ps.executeUpdate();
			if (a > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public VehicleBean findByID(String UserId) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM ATA_TBL_VEHICLE WHERE VEHICLEID = ?");
			ps.setString(1, UserId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			VehicleBean vb = new VehicleBean();
			vb.setName(rs.getString(2));
			vb.setType(rs.getString(3));
			vb.setRegistrationNumber(rs.getString(4));
			vb.setSeatingCapacity(rs.getInt(5));
			vb.setFarePerKM(rs.getInt(6));
			return vb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ArrayList<VehicleBean> findAll() {
			ArrayList<VehicleBean> li = new ArrayList<VehicleBean>();
			
			try {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_VEHICLE");
				ResultSet rs = ps.executeQuery();
				VehicleBean vb = new VehicleBean();
				while(rs.next())
				{
				vb.setVehicleID(rs.getString(1));
				vb.setName(rs.getString(2));
				vb.setType(rs.getString(3));
				vb.setRegistrationNumber(rs.getString(4));
				vb.setSeatingCapacity(rs.getInt(5));
				vb.setFarePerKM(rs.getInt(6));
				li.add(vb);
				}
				return li;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

}

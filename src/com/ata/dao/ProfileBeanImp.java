package com.ata.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.util.DBUtil;

public class ProfileBeanImp implements ProfileBeanDao {
	
	// For Connection to database 
	static Connection con=DBUtil.getConnection();

	@Override
	public String createProfile(ProfileBean pbean) {
		try 
		{
			PreparedStatement ps=
					con.prepareStatement("INSERT INTO ATA_TBL_USER_PROFILE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pbean.getUserId());
			ps.setString(2, pbean.getFirstName());
			ps.setString(3, pbean.getLastName());
			ps.setString(4, pbean.getDateOfBirth());
			ps.setString(5, pbean.getGender());
			ps.setString(6, pbean.getStreet());
			ps.setString(7, pbean.getLocation());
			ps.setString(8, pbean.getCity());
			ps.setString(9, pbean.getState());
			ps.setString(10, pbean.getPincode());
			ps.setString(11, pbean.getMobileNo());
			ps.setString(12, pbean.getEmailId());
			int a = ps.executeUpdate();
			if(a != 0) 
			{
				return "Profile Created";
			}
			else 
			{
				return "Failed";
			}
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "Error";
	}

	@Override
	public int deleteProfile(ArrayList<String> li)
	{
		String userId = li.get(0);		
		try
		{
			PreparedStatement ps = con.prepareStatement("DELETE FROM ATA_TBL_USER_PROFILE WHERE USERID = ?");
			ps.setString(1, userId);
			int a = ps.executeUpdate();
			return a;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public boolean updateProfile(ProfileBean bean)
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement("UPDATE ATA_TBL_USER_PROFILE SET FIRSTNAME = ?, LASTNAME = ?, DATEOFBIRTH = ?, GENDER = ?, STREET = ?, LOCATION = ?, CITY = ?, STATE = ?, PINCODE = ?, MOBILENO = ?, EMAIL = ? WHERE USERID = ?");
			
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getDateOfBirth());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getStreet());
			ps.setString(6, bean.getLocation());
			ps.setString(7, bean.getCity());
			ps.setString(8, bean.getState());
			ps.setString(9, bean.getPincode());
			ps.setString(10, bean.getMobileNo());
			ps.setString(11, bean.getEmailId());
			ps.setString(12, bean.getUserId());
			ps.executeUpdate();
			return true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public ProfileBean findByID(String UserId)
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_USER_PROFILE WHERE USERID = ?");
			ps.setString(1, UserId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ProfileBean pb = new ProfileBean();
			pb.setUserId(rs.getString(1));
			pb.setFirstName(rs.getString(2));
			pb.setLastName(rs.getString(3));
			pb.setDateOfBirth(rs.getString(4));
			pb.setGender(rs.getString(5));
			pb.setStreet(rs.getString(6));
			pb.setLocation(rs.getString(7));
			pb.setCity(rs.getString(8));
			pb.setState(rs.getString(9));
			pb.setPincode(rs.getString(10));
			pb.setMobileNo(rs.getString(11));
			pb.setEmailId(rs.getString(12));
			return pb;			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ProfileBean> findAll() {
		ArrayList<ProfileBean> li = new ArrayList<ProfileBean>();
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_USER_PROFILE");
			ResultSet rs = ps.executeQuery();
			
			ProfileBean pb = new ProfileBean();
			while(rs.next())
			{
			pb.setUserId(rs.getString(1));
			pb.setFirstName(rs.getString(2));
			pb.setLastName(rs.getString(3));
			pb.setDateOfBirth(rs.getString(4));
			pb.setGender(rs.getString(5));
			pb.setStreet(rs.getString(6));
			pb.setLocation(rs.getString(7));
			pb.setCity(rs.getString(8));
			pb.setState(rs.getString(9));
			pb.setPincode(rs.getString(10));
			pb.setMobileNo(rs.getString(11));
			pb.setEmailId(rs.getString(12));
			li.add(pb);
			}
			return li;
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

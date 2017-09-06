package com.ata.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;

public class ProfileBeanImp implements ProfileBeanDao {

	@Override
	public String createProfile(ProfileBean pbean) {

		
		try {
			
			String [] s=pbean.getDateOfBirth().split("-");
			java.sql.Date date = new Date(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			
			PreparedStatement ps=
					con.prepareStatement("INSERT INTO ATA_TBL_USER_PROFILE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, id);
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
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
		
		return null;
	}

	@Override
	public int deleteProfile(ArrayList<String> li) {
		
		return 0;
	}

	@Override
	public boolean updateProfile(ProfileBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProfileBean findByID(String UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProfileBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

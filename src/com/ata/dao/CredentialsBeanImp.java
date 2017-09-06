package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.util.DBUtil;

public class CredentialsBeanImp implements CredentialsBeanDao {

	// For Connection to database 
		static Connection con=DBUtil.getConnection();
		
	@Override
	public String createCredentials(CredentialsBean cbean) {
		
		try {
			// Auto Generated Id 
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_ID");
			
			ResultSet rs = ps.executeQuery();
			rs.last();
			
			ProfileBean pb = new ProfileBean();
			String id = pb.getFirstName().substring(0,2)+rs.getInt(2);
			
			PreparedStatement ps1=con.prepareStatement("UPDATE ATA_TBL_ID SET SVAL= SVAL+1");
			ps1.executeUpdate();
			// End of Auto Generated Id Code
			
//			Add the Information into Credentials Table
			
			PreparedStatement ps2 = con.prepareStatement("INSERT INTO ATA_TBL_USER_CREDENTIALS VALUES(?,?,?,?)");
			ps2.setString(1, id);
			ps2.setString(2, cbean.getPassword());
			ps2.setString(3, cbean.getUserType());
			ps2.setInt(4, 0);
			// to do 
			ps2.executeQuery();
			return id;
			}
			catch (SQLException e) 
			{
			e.printStackTrace();
			return "FAIL";
			}
	}

	@Override
	public int deleteCredentials(ArrayList<String> li) {
		String userId = li.get(0);		// Why use of get(0)
		
		try
		{
			PreparedStatement ps = con.prepareStatement("DELETE FROM ATA_TBL_USER_CREDENTIALS WHERE USERID = ?");
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
	public boolean updateCredentials(CredentialsBean bean) {
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("UPDATE ATA_TBL_USER_CREDENTIALS SET PASSWORD = ? WHERE USERID = ?");
			ps.setString(1, bean.getPassword());
			ps.setString(2, bean.getUserId());
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
	public CredentialsBean findByID(String UserId) {
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_USER_CREDENTIALS WHERE USERID = ?");
			ps.setString(1, UserId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			CredentialsBean cb = new CredentialsBean();
			cb.setUserId(rs.getString(1));
			cb.setPassword(rs.getString(2));
			cb.setLoginStatus(rs.getInt(3));
			cb.setUserType(rs.getString(4));
			return cb;			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CredentialsBean> findAll() {
		ArrayList<CredentialsBean> li = new ArrayList<CredentialsBean>();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ATA_TBL_USER_CREDENTIALS");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				CredentialsBean cb = new CredentialsBean();
				cb.setUserId(rs.getString(1));
				cb.setPassword(rs.getString(2));
				cb.setLoginStatus(rs.getInt(3));
				cb.setUserType(rs.getString(4));
				li.add(cb);
			}
			return li;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}

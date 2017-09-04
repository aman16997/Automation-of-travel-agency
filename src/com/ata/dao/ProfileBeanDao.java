package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ProfileBean;

public interface ProfileBeanDao {
	
	String createVehicle(ProfileBean bean);
	int deleteProfile(ArrayList<String> li);
	boolean updateCredentials(ProfileBean bean);
	ProfileBean findByID(String UserId);
	ArrayList<ProfileBean> findAll();

}

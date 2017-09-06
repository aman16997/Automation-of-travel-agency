package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.ProfileBean;

public interface ProfileBeanDao {
	
	String createProfile(ProfileBean pbean);
	int deleteProfile(ArrayList<String> li);
	boolean updateProfile(ProfileBean bean);
	ProfileBean findByID(String UserId);
	ArrayList<ProfileBean> findAll();

}

package com.ata.dao;

import java.util.ArrayList;

import com.ata.bean.CredentialsBean;

public interface CredentialsBeanDao {
	
	String createCredentials(CredentialsBean cbean);
	int deleteCredentials(ArrayList<String> li);
	boolean updateCredentials(CredentialsBean bean);
	CredentialsBean findByID(String UserId);
	ArrayList<CredentialsBean> findAll();
	
}

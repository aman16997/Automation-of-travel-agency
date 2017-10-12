package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialsBeanImp;

public class AuthenticationImp implements Authentication {

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		
		String id = credentialsBean.getUserId();
		CredentialsBeanImp cb = new CredentialsBeanImp();
		CredentialsBean cd = cb.findByID(id);
		if(cd.getUserId().equalsIgnoreCase(id))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String authorize(String userID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

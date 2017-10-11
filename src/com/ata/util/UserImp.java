package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.CredentialsBeanImp;
import com.ata.dao.ProfileBeanImp;

public class UserImp implements User {

	@Override
	public String login(CredentialsBean credentialsBean) {
		 
		CredentialsBeanImp cb = new CredentialsBeanImp();	// Create the object of Credentials Interface
		
		
		return null;
	}

	@Override
	public boolean logout(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String register(ProfileBean profileBean, CredentialsBean credentialsBean) {
		
		CredentialsBeanImp cb = new CredentialsBeanImp();	// Create the object of Credentials Interface
		ProfileBeanImp pb = new ProfileBeanImp();			// Create the object of Profile Interface
		
		credentialsBean.setProfile(profileBean);	// Set the all values to the profile bean using profile fun in Credentials
		credentialsBean.setUserType("C");			// Set the user Type to Customer
		
		String id = cb.createCredentials(credentialsBean);	// Getting the auto-generated Id
		
		profileBean.setUserId(id);	// Set the auto generated id to the profile bean
		
		String ps = pb.createProfile(profileBean);
		
		if(id != null && ps != null)
		{
			return id;
		}
		else
		{
			return "Fail";
		}
		
	}

}

package com.ata.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.CredentialsBeanImp;
import com.ata.dao.ProfileBeanDao;
import com.ata.dao.ProfileBeanImp;



public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Output in the form of Html
		response.setContentType("text/html");
	// Print Object
		PrintWriter out = response.getWriter();	
			
		
		// Get the input from Signup Page
		
		String firstName = request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String street = request.getParameter("street");
		String location = request.getParameter("location");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String phone = request.getParameter("mobileNumber");
		
		// Object of Profile Bean Class
				ProfileBean pbean = new ProfileBean();
				pbean.setFirstName(firstName);
				pbean.setLastName(lastName);
				pbean.setDateOfBirth(dateOfBirth);
				pbean.setGender(gender);
				pbean.setEmailId(email);
				pbean.setStreet(street);
				pbean.setLocation(location);
				pbean.setCity(city);
				pbean.setState(state);
				pbean.setPincode(pincode);
				pbean.setMobileNo(phone);
		
		// Object of Credentials Bean class
				CredentialsBean cbean = new CredentialsBean();
				cbean.setPassword(password);
				cbean.setUserType("C");
				CredentialsBeanImp dao = new CredentialsBeanImp();
				String id = dao.createCredentials(cbean);
				System.out.println(id);
				if(!id.equalsIgnoreCase("FAIL") || !id.equalsIgnoreCase(null) )
				{
					pbean.setUserId(id);
					ProfileBeanImp pdao = new ProfileBeanImp();
					pdao.createProfile(pbean);
				}
				
				
		
		
		
		
		
		
	}

}

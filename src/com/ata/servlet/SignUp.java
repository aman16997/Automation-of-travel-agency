package com.ata.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ata.bean.ProfileBean;
import com.ata.dao.ProfileBeanImp;



public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Output in the form of Html
		response.setContentType("text/html");
	// Print Object
		PrintWriter out = response.getWriter();	
	// Object of Profile Bean Class
		ProfileBean bean = new ProfileBean();
	// Object of Dao Class
		ProfileBeanImp dao = new ProfileBeanImp();
		
		
		
		
	}

}

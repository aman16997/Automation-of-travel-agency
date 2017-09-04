package com.ata.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/transport";
	private static String user = "root";
	private static String pass = "Odd1357924680";
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		return con;
	}
		
}	

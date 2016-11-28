package com.db;

import java.sql.*;

import com.mysql.jdbc.Connection;
import com.sun.org.apache.commons.collections.StaticBucketMap;

public class DB {
	
		//1.Çý¶¯
	private static String driver = "com.mysql.jdbc.Driver";
	//2.µØÖ·
	private static String host="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	private static String user="root";
	private static String pass="nzj7235939";
	
	 public static java.sql.Connection getConnection(){
		java.sql.Connection con =null;
		try {
			Class.forName(driver);
			con =  DriverManager.getConnection(host,user,pass);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return con;
				 
	 }
}

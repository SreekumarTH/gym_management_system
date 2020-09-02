package org.sree.gym.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sree.gym.bean.MemberBean;

public class DbConnection {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gym_db";
	
	static final String USER = "root";
	static final String PASS = "Sree@1234";
	
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to Database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection Established!!!");
			System.out.println("Creating Statement");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from members");
			while(rs.next())
			{
				System.out.println(rs.getString("name") + "," + rs.getInt("age"));
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

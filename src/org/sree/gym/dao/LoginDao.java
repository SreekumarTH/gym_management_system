package org.sree.gym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sree.gym.bean.MemberBean;

public class LoginDao {


	public boolean validate(MemberBean loginBean) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_b75b3335121fcf8", "ba222130921f02", "f5c6b050");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from member where username = ? and password = ? "))
		{
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);		}
		return status;

	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}		

		}
	}
}



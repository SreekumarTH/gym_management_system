package org.sree.gym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import org.sree.gym.bean.MemberBean;


public class MembersDao {

	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DB_URL = "jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_b75b3335121fcf8?useSSL=false";
	private String USER = "ba222130921f02";
	private String PASS = "f5c6b050";

	private static final String INSERT_MEMBER_SQL = "INSERT INTO member" + "  (username, password, name, age) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_MEMBER_BY_USERNAME = "select username, name, age from member where username =?";
	private static final String SELECT_ALL_MEMBERS = "select * from member;";
	private static final String DELETE_MEMBER_SQL = "delete from member where username = ?;";	
	private static final String UPDATE_MEMBER_SQL = "update member set password = ?, name = ?,age= ? where username = ?";
	

	public MembersDao(){
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
	public void insertMember(MemberBean member) throws SQLException {
		System.out.println(INSERT_MEMBER_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBER_SQL)) {
			preparedStatement.setString(1, member.getUsername());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getName());
			preparedStatement.setInt(4, member.getAge());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public MemberBean selectMember(String username) {
		MemberBean member = null;
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBER_BY_USERNAME);) {
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String username1 = rs.getString("username");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				member = new MemberBean(username1, name, age);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return member;
	}

	public List<MemberBean>selectAllMembers() {

		List<MemberBean> members = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEMBERS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				members.add(new MemberBean(username, name, age));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return members;
	}
	
	public boolean deleteMember(String username) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_MEMBER_SQL);) {
			statement.setString(1, username);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateMember(MemberBean member) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBER_SQL)) {
			statement.setString(1, member.getPassword());
			statement.setString(2, member.getName());
			statement.setInt(3, member.getAge());
			statement.setString(4, member.getUsername());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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




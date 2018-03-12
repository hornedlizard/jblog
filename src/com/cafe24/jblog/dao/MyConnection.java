package com.cafe24.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			if (conn != null && conn.isClosed() == false) {
				return conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return makeConnection();
	}
	
	private static Connection makeConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jblog";
			conn = DriverManager.getConnection(url, "jblog", "jblog");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

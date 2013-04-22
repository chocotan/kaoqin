package io.loli.kaoqin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/kaoqin?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static void releaseConnection(Statement statement, Connection conn) {
		try {
			statement.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

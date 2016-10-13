package com.lce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;


public class JDBCUtil {

	// create and edit dbinfo config file
	// read config of dbinfo
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static {
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("dbinfo.properties");
		driverClass = resourceBundle.getString("driverClass");
		url = resourceBundle.getString("url");
		user = resourceBundle.getString("user");
		password = resourceBundle.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// get connection
	public static Connection geConnection() throws Exception {

		// 2. registy driver

		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	public static void Release(ResultSet rs,Statement stmt, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
	}
}

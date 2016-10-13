package com.lce.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.regexp.internal.RE;

public class C3P0Util2 {
	//1. copy c3p0-xxx.jar
	//2. edit config file of c3p0
	//3. initial datasource pool
	//private static ComboPooledDataSource dataSource=new ComboPooledDataSource("day16");
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	//4. get datasource
	/*static{
		dataSource.setDriverClass("com.jdbc.mysql.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bookstore");
		dataSource.setUser("root");
		dataSource.setPassword("root");
	}*/
	public static DataSource geDataSource(){
		return dataSource;
	}	
	//5. get connection
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("database connection fail");
		}
	}
	public static void release(ResultSet rs,Statement stmt,Connection conn){
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

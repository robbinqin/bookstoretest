package com.lce.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mysql.jdbc.Statement;

public class DBCPUtil {

	//1. copy jar:commons-pool.jar, commons-dbcp.jar
	//2. edit config:dbcpconfig.properties
	//3. get datasource
	private static DataSource dataSource;
	//3.1 load config of dbcp
	static{
		//DBCP
		Properties props=new Properties();
		try {
			props.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			dataSource=BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("load config fail");
		}
	}
	//4. get connection
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("db connection fail");
		}
	}
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			stmt=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			conn=null;
		}
	}
	
}

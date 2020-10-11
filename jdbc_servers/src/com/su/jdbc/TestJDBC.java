package com.su.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 此类用于演示JDBC的使用步骤2：获取连接
 * @author liyuting
 *
 */
public class TestJDBC {
	
//	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		Properties info  = new Properties();
		info.load(new FileInputStream("src\\jdbc.properties"));
		String user = info.getProperty("user");
		String password = info.getProperty("password");
		String driver = info.getProperty("driver");
		String url = info.getProperty("url");
		
		//1.注册驱动
		Class.forName(driver);
		
		//2.获取连接
		@SuppressWarnings("unused")
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("连接成功");
		
		
		
		
		
		
	}

}

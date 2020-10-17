package com.su.jdbc;

//import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.cj.jdbc.Driver;

public class ConnectionTest {
	@Test
	public void ConnectinoTest1() {
		try {
            //1.提供java.sql.Driver接口实现类的对象
            Driver driver = null;
            driver = new com.mysql.cj.jdbc.Driver();

            //2.提供url，指明具体操作的数据
            String url = "jdbc:mysql://localhost:3306/girls";

            //3.提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "123456");

            //4.调用driver的connect()，获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void ConnectionTest2() { 
		try {
            //1.实例化Driver
            String className = "com.mysql.cj.jdbc.Driver";
            Class clazz = Class.forName(className);
            Driver driver = (Driver) clazz.newInstance();

            //2.提供url，指明具体操作的数据
            String url = "jdbc:mysql://localhost:3306/girls";

            //3.提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "123456");

            //4.调用driver的connect()，获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void ConnectionTest5() throws Exception {
		//1、加载配置文件
		InputStream is=ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		
		//2、读取配置信息
		String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("jdbc.connectionURL");
        String driverClass = pros.getProperty("driver");
		
        //3、加载驱动
        Class.forName(driverClass);
        
        //4、获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
		
	}
}

package com.su.blob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.su.util.JDBCUtils;

public class BlobTest {
	//1、向数据表customers中插入Blob类型的字段
	
	@Test
	public void testInsert() throws Exception {
		//连接JDBC
		Connection conn = JDBCUtils.getConnection();
		//预编译SQL语句
		String sql="insert into customers(name,email,birth,photo)values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
//		ps.setObject(1,"花木兰");
//		ps.setObject(2,"hua@qq.com");
//		ps.setObject(3,"1999-02-16");
//		FileInputStream is = new FileInputStream(new File("timg.jpg"));
//		ps.setBlob(4, is);
		
		ps.setObject(1,"袁浩");
		ps.setObject(2, "yuan@qq.com");
		ps.setObject(3,"1992-09-08");
		FileInputStream is = new FileInputStream(new File("timg.jpg"));
		ps.setBlob(4, is);
		
		ps.execute();
		
		//关闭
		JDBCUtils.closeResource(conn, ps);
	}
}

package com.su.preparedstatement.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import org.junit.Test;

import com.su.bean.Order;
import com.su.util.JDBCUtils;

//针对Order表的通用的查询操作
public class OrderForQuery {

	@Test
	public void testQuery1() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id= ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);

			rs = ps.executeQuery();
			if (rs.next()) {
				int id = (int) rs.getObject(1);
				String name = (String) rs.getObject(2);
				Date date = (Date) rs.getObject(3);

				Order order = new Order(id, name, date);
				System.out.println(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}

	}

}

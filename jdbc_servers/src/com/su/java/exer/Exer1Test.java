package com.su.java.exer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.su.util.JDBCUtils;

public class Exer1Test {
	//通用的增删改操作
		public static void update(String sql, Object... args) {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JDBCUtils.getConnection();
				ps = conn.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				JDBCUtils.close(null, ps, conn);
			}

		}
}

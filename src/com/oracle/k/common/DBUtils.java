package com.oracle.k.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	/**
	 * 释放资源
	 * @param rs：结果集
	 * @param stmt：Statement
	 * @param conn:连接对象
	 */
	public static void close(ResultSet rs,
			Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt,Connection conn){
		//调用重载的方法
		close(null,stmt,conn);
	}
	
	public static void close(Statement stmt){
		close(null,stmt,null);
	}
	
	public static void close(Connection conn){
		close(null,null,conn);
	}
	
	//。。。根据需要继续添加
}

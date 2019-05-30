package com.oracle.k.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	/**
	 * 通用的增删改方法
	 * @param sql：要执行的SQL语句
	 * @param setter：设置占位符的值的对象
	 * @return 影响的行数
	 */
	public static int update(String sql,PreparedStatementSetter setter){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		 //1,2
		conn = ConnectionFactory.getConnection();	
		try {
			//3
			pstmt = conn.prepareStatement(sql);
			//4
			if(setter!=null){
				setter.setValues(pstmt);
			}
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//6
			DBUtils.close(pstmt, conn);
		}
		return rows;
	}
	
	//通用的查询
	public static void query(String sql,
			PreparedStatementSetter setter,
			ResultSetHandler handler){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1,2
		conn = ConnectionFactory.getConnection();		
		try {
			conn.setAutoCommit(false);
			//3
			pstmt = conn.prepareStatement(sql);
			//4
			if(setter!=null){
				setter.setValues(pstmt);
			}
			rs = pstmt.executeQuery();
			//5.处理结果集
			if(handler!=null){
				handler.handleRS(rs);
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			//6
			DBUtils.close(rs, pstmt, conn);
		}
	}
}





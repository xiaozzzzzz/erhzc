package com.oracle.k.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.k.bean.TUser;
import com.oracle.k.common.JDBCTemplate;
import com.oracle.k.common.PreparedStatementSetter;
import com.oracle.k.common.ResultSetHandler;

public class TUserDao {
	
	/**
	 * ×¢²áÓÃ»§
	 * @param username
	 * @param password
	 * @param sex
	 * @param id_number
	 * @param tel
	 * @param addr
	 * @return
	 */
	public int addUser(String username,String password,String sex,String id_number,String tel,String addr) {
		String sql = "insert into t_user (username,password,sex,id_number,tel,addr) "+
					" values(?,?,?,?,?,?)";
		
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, sex);
				pstmt.setString(4, id_number);
				pstmt.setString(5, tel);
				pstmt.setString(6, addr);
			}
		});
	}
	 
	 
	public int updateUser(String password,String sex,String tel,String addr,int type,String username) {
		// TODO Auto-generated method stub
		String sql = "update t_user set password=?,sex=?,tel=?,addr=?,type=? where username=?";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, password);
				pstmt.setString(2, sex);
				pstmt.setString(3, tel);
				pstmt.setString(4, addr);
				pstmt.setInt(5, type);
				pstmt.setString(6, username);
			}
		});
	}
	
	public TUser queryByName(String username) {
		String sql="select *from t_user where username=?";
		TUser user=new TUser();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, username);
			}
		},new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					user.setId(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSex(rs.getString(4));
					user.setId_number(rs.getString(5));
					user.setTel(rs.getString(6));
					user.setAddr(rs.getString(7));
					user.setType(rs.getInt(8));
				}
			}
		});
		
		return user;
	}
	
	
}

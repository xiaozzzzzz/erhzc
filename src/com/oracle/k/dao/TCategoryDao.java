package com.oracle.k.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.k.bean.TCategory;
import com.oracle.k.common.JDBCTemplate;
import com.oracle.k.common.PreparedStatementSetter;
import com.oracle.k.common.ResultSetHandler;

public class TCategoryDao {
	public TCategory queryByName(String name) {
		String sql="select *from t_category where name=?";
		TCategory category =new TCategory();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, name);
			}
		},new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					category.setId(rs.getInt(1));
					category.setName(rs.getString(2));
				}
			}
		});
		
		return category;
	}
	
	public List<TCategory> queryAll(){
		String sql="select * from t_category order by id asc";
		List<TCategory> list =new ArrayList<>();
		JDBCTemplate.query(sql, null, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCategory(
							rs.getInt(1),
							rs.getString(2)));
				}
			}
		});
		return list;
	}
}

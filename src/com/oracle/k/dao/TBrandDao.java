package com.oracle.k.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.k.bean.TBrand;
import com.oracle.k.common.JDBCTemplate;
import com.oracle.k.common.PreparedStatementSetter;
import com.oracle.k.common.ResultSetHandler;

public class TBrandDao {
	/**
	 * 添加品牌
	 * @param brand
	 * @return
	 */
	public int addBrand(String name) {
		String sql="insert into t_brand (name) values(?)";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, name);
			}
		});
	}
	
	/**
	 * 根据姓名查找
	 * @param name
	 * @return
	 */
	public TBrand queryByName(String name) {
		String sql="select *from t_brand where name=?";
		TBrand brand =new TBrand();
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
					brand.setId(rs.getInt(1));
					brand.setName(rs.getString(2));
				}
			}
		});
		
		return brand;
	}
	
	public List<TBrand> queryAll(){
		String sql="select * from t_brand order by id asc";
		List<TBrand> list =new ArrayList<>();
		JDBCTemplate.query(sql, null, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TBrand(
							rs.getInt(1),
							rs.getString(2)));
				}
			}
		});
		return list;
	}
	
}

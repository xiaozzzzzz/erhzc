package com.oracle.k.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.oracle.k.bean.TCar;
import com.oracle.k.common.JDBCTemplate;
import com.oracle.k.common.PreparedStatementSetter;
import com.oracle.k.common.ResultSetHandler;

public class TCarDao {
	
	

	/**
	 * 查找所有
	 * @return
	 */
	public List<TCar> queryAll0() {
		String sql="select * from t_car where useable=? and status=?";
		
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, 0);
				pstmt.setInt(2, 0);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
		
	}
	
	public List<TCar> queryAll1() {
		String sql="select * from t_car ";
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, null, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
		
	}
	
	/**
	 * 添加汽车
	 * @param car
	 * @return
	 */
	public int addCar(String car_number, int brand_id, String model, String color, int category_id,String t_comments, double price,
			double rent, int status, int useable) {
		String sql = "insert into t_car (car_number,brand_id,model,color,category_id,t_comments,price,rent,status,useable) " + 
				" values(?,?,?,?,?,?,?,?,?,?)";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, car_number);
				pstmt.setInt(2, brand_id);
				pstmt.setString(3, model);
				pstmt.setString(4, color);
				pstmt.setInt(5, category_id);
				pstmt.setString(6, t_comments);
				pstmt.setDouble(7, price);
				pstmt.setDouble(8, rent);
				pstmt.setInt(9, status);
				pstmt.setInt(10, useable);
			}
		});
	}
	
	public List<TCar> queryByCategory(int categoyr_id,int useable) {
		String sql="select *from t_car where category_id=? and useable=?";
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, categoyr_id);
				pstmt.setInt(2, useable);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
	}
	
	public List<TCar> queryByBrand(int brand_id,int userable) {
		String sql="select *from t_car where brand_id=? and useable=?";
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, brand_id);
				pstmt.setInt(2, userable);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
	}
	
	/**
	 * 按降序查找
	 * @return
	 */
	public List<TCar> queryAllByDesc0() {
		String sql="select * from t_car where status=? and useable=? order by price desc";
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, 0);
				pstmt.setInt(2, 0);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
		
	}
	
	/**
	 * 按价格升序查找
	 * @return
	 */
	public List<TCar> queryAllByAsc0() {
		String sql="select * from t_car where status=? and useable=? order by price asc";
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, 0);
				pstmt.setInt(2, 0);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
		
	}
	
	
	public List<TCar> queryAllByNum(String car_number) {
		String sql="select * from t_car where car_number=? ";
		List<TCar> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, car_number);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TCar(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getInt(6),
							rs.getString(7),
							rs.getDouble(8),
							rs.getDouble(9),
							rs.getInt(10),
							rs.getInt(11)));
				}
			}
		});
		return list;
		
	}
	
	
	public void updateByCar0(int id,int status) {
		String sql="update t_car set status=? where id=?";
		JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, status);
				pstmt.setInt(2, id);
			}
		});
	}
	/**
	 * 根据id修改汽车信息
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateByCar(int id,int status) {
		// TODO Auto-generated method stub
		String sql = "update t_car set status=? where id=?";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, status);
				pstmt.setInt(2, id);
			}
		});
	}
	
	
	public int updateByCar1(int id, double rent) {
		// TODO Auto-generated method stub
		String sql = "update t_car set rent=? where id=?";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setDouble(1, rent);
				pstmt.setInt(2, id);
			}
		});
	}
	
	public int updateByCar2(int id, int useable) {
		// TODO Auto-generated method stub
		String sql = "update t_car set useable=? where id=?";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, useable);
				pstmt.setInt(2, id);
			}
		});
	}
	
	public TCar queryByCar_number(String car_number) {
		String sql="select * from t_car where car_number=?";
		TCar car=new TCar();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, car_number);
			}
		},new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					car.setId(rs.getInt(1));
					car.setCar_number(rs.getString(2));
					car.setBrand_id(rs.getInt(3));
					car.setModel(rs.getString(4));
					car.setColor(rs.getString(5));
					car.setCategory_id(rs.getInt(6));
					car.setT_comments(rs.getString(7));
					car.setPrice(rs.getDouble(8));
					car.setRent(rs.getDouble(9));
					car.setStatus(rs.getInt(10));
					car.setUseable(rs.getInt(11));
				}
			}
		});
		return car;
	}
	
	public TCar queryById(int id) {
		String sql="select * from t_car where id=?";
		TCar car=new TCar();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, id);
			}
		},new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					car.setId(rs.getInt(1));
					car.setCar_number(rs.getString(2));
					car.setBrand_id(rs.getInt(3));
					car.setModel(rs.getString(4));
					car.setColor(rs.getString(5));
					car.setCategory_id(rs.getInt(6));
					car.setT_comments(rs.getString(7));
					car.setPrice(rs.getDouble(8));
					car.setRent(rs.getDouble(9));
					car.setStatus(rs.getInt(10));
					car.setUseable(rs.getInt(11));
				}
			}
		});
		return car;
	}
}

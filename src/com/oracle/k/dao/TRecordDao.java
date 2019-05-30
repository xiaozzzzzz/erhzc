package com.oracle.k.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.k.bean.TCar;
import com.oracle.k.bean.TRecord;
import com.oracle.k.common.JDBCTemplate;
import com.oracle.k.common.PreparedStatementSetter;
import com.oracle.k.common.ResultSetHandler;

public class TRecordDao {

	/**
	 * 查询所有租凭
	 * @return
	 */
	public List<TRecord> queryAll(){
		String sql="select * from t_record";
		List<TRecord> list =new ArrayList<>();
		JDBCTemplate.query(sql, null, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TRecord(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getDouble(6)));
				}
			}
		});
		return list;
	}
	
	/**
	 * 根据人名查找租凭
	 * @param name
	 * @return
	 */
	public List<TRecord> queryByUser(int user_id) {
		String sql="select *from t_record where user_id =?";
		List<TRecord> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, user_id);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TRecord(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getDouble(6)));
				}
			}
		});
		return list;
	}
	
	public List<TRecord> queryByUser0(int user_id) {
		String sql="select *from t_record where user_id =?,return_date=?";
		List<TRecord> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, user_id);
				pstmt.setString(2, null);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TRecord(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getDouble(6)));
				}
			}
		});
		return list;
	}
	
	public List<TRecord> queryByUser1(int user_id) {
		String sql="select *from t_record where user_id =?";
		List<TRecord> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, user_id);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TRecord(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getDouble(6)));
				}
			}
		});
		return list;
	}
	
	/**
	 * 根据id查询租凭
	 * @param car_id
	 * @return
	 */
	public List<TRecord> queryByCar(int car_id) {
		String sql="select *from t_record where car_id=?";
		List<TRecord> list =new ArrayList<>();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, car_id);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					list.add(new TRecord(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5),
							rs.getDouble(6)));
				}
			}
		});
		return list;
	}
	
	public TRecord queryByCar0(int car_id) {
		String sql="select * from t_record where car_id=?";
		TRecord record=new TRecord();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, car_id);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					record.setId(rs.getInt(1));
					record.setUser_id(rs.getInt(2));
					record.setCar_id(rs.getInt(3));
					record.setStart_date(rs.getString(4));
					record.setReturn_date(rs.getString(5));
					record.setPayment(rs.getDouble(6));
				}
				
			}
		});
		return record;
	}
	
	
	public TRecord queryById(int id) {
		String sql="select * from t_record where id=?";
		TRecord record=new TRecord();
		JDBCTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, id);
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handleRS(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				if(rs.next()) {
					record.setId(rs.getInt(1));
					record.setUser_id(rs.getInt(2));
					record.setCar_id(rs.getInt(3));
					record.setStart_date(rs.getString(4));
					record.setReturn_date(rs.getString(5));
					record.setPayment(rs.getDouble(6));
				}
				
			}
		});
		return record;
	}
	
	public int addRecord(int user_id,int car_id,String start_date) {
		String sql = "insert into t_record  (user_id,car_id,start_date) values(?,?,?)";
		TCarDao cd=new TCarDao();
		
		TCar c=cd.queryById(car_id);
		if (c.getStatus()==0) {
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, user_id);
				pstmt.setInt(2, car_id);
				pstmt.setString(3, start_date);
			}
		});}
		else
			return 0;
	}
	
	public int updateRecord0(int id,int user_id, String return_date,double payment) {
		// TODO Auto-generated method stub
		String sql = "update t_record set return_date=?,payment=? where id=? and user_id=?";
		return JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, return_date);
				pstmt.setDouble(2, payment);
				pstmt.setInt(3, id);
				pstmt.setInt(4, user_id);
			}
		});
	}
	
	public void deleteRecord(int user_id,int car_id) {
		String sql="delete from t_record where car_id=? and user_id=? ";
		JDBCTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, car_id);
				pstmt.setInt(2, user_id);
			}
		});
	}
	
	
}

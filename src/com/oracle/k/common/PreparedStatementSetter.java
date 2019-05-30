package com.oracle.k.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 用来设置占位符的值的通用类型
 * @author 
 *
 */
public interface PreparedStatementSetter {
	public void setValues(PreparedStatement pstmt)
			throws SQLException;
}

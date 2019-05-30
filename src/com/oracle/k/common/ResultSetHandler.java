package com.oracle.k.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集处理的封装
 * @author 
 *
 */
public interface ResultSetHandler {
	public void handleRS(ResultSet rs)
			throws SQLException;
}

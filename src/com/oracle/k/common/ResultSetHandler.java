package com.oracle.k.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���������ķ�װ
 * @author 
 *
 */
public interface ResultSetHandler {
	public void handleRS(ResultSet rs)
			throws SQLException;
}

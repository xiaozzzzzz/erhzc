package com.oracle.k.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��������ռλ����ֵ��ͨ������
 * @author 
 *
 */
public interface PreparedStatementSetter {
	public void setValues(PreparedStatement pstmt)
			throws SQLException;
}

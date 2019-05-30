package com.oracle.k.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String DRIVER;
	private static String URL;
	private static String UNAME;
	private static String UPASS;
	
	static{
		//�����һ��ʹ��ʱ�����ִ࣬�о�̬����飬ֻ��ִ��һ��
		//��ȡ�ļ����ĸ�ֵ
		Properties prop = new Properties();
		try {
			//1.load()���ļ��е����ݼ��ص��ڴ��е�prop������
			//prop.load(new FileInputStream("src/com/hwua/util/jdbcinfo.properties"));
			//���ַ�ʽ�����÷��䣬������Ҫ�Լ�����
			//ͨ��getResourceAsStream����
			//ǰ�᣺Ҫ���ļ��Ͷ�Ӧ������ͬһ���ļ�����
			prop.load(ConnectionFactory.class.
					getResourceAsStream("jdbcinfo.properties"));
			//2.��ȡ�ĸ�����Ӧ��ֵ
			DRIVER = prop.getProperty("driver");
			URL = prop.getProperty("url");
			UNAME = prop.getProperty("uname");
			UPASS = prop.getProperty("upass");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(
					URL, 
					UNAME, 
					UPASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}

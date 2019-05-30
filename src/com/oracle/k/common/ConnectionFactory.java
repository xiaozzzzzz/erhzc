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
		//在类第一次使用时加载类，执行静态代码块，只会执行一次
		//读取文件的四个值
		Properties prop = new Properties();
		try {
			//1.load()把文件中的数据加载到内存中的prop对象中
			//prop.load(new FileInputStream("src/com/hwua/util/jdbcinfo.properties"));
			//这种方式，利用反射，流不需要自己创建
			//通过getResourceAsStream返回
			//前提：要求文件和对应的类在同一个文件夹下
			prop.load(ConnectionFactory.class.
					getResourceAsStream("jdbcinfo.properties"));
			//2.获取四个键对应的值
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

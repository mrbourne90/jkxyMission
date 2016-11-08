package com.jikexueyuan.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private Connection connection;

	//初始化静态成员变量
	static {
		Properties properties = new Properties();
		
		try {

			InputStream iStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			properties.load(iStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
	//单例模式创建示例
	private ConnectionFactory(){
		
	}
	
	private static class SingletonHolder{
		private static final ConnectionFactory FACTORY = new ConnectionFactory();
	}
	
	public static ConnectionFactory getInstance(){
		return SingletonHolder.FACTORY;
	}
	
	//打开连接
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭连接
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

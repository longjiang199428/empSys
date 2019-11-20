package com.zyz.empSys.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class MyDBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	private static Properties properties = new Properties();

	private MyDBUtil() {

	}

	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			properties.load(in);

			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");

			Class.forName(driver);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 获取到连接对象
	 */
	
	public static Connection getConnection() {
		
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	

}

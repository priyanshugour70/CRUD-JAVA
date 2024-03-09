package com.pg.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	private static Properties properties = null;

	private JdbcUtil() {
		
	}
	
	static {
		FileInputStream fis = null;

		String fileInfo = "/Users/priyanshugour/Desktop/SDE-Prep/BMCJ/CRUD-JDBC/src/com/pg/properties/database.properties";
		try {
			fis = new FileInputStream(fileInfo);
			if (fis != null) {
				properties = new Properties();
				properties.load(fis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public static Connection getDBConection() throws IOException, SQLException {
		// Database connection parameters
		// JDBC dbUrl, dbUsername, and dbPassword of MySQL server
		String dbProtocol = properties.getProperty("db.protocol", "jdbc:mysql://");
		String dbHost = properties.getProperty("db.host", "127.0.0.1");
		String dbPort = properties.getProperty("db.port", "3306");
		String dbName = properties.getProperty("db.name", "pwskills");
		String dbUrl = dbProtocol + dbHost + ":" + dbPort + "/" + dbName;
		String dbUserName = properties.getProperty("db.username", "root");
		String dbPassword = properties.getProperty("db.password", "Harda20p!");
		// 1. Establishing the Connection
		return DriverManager.getConnection(dbUrl, dbUserName,dbPassword);
	}

	public static void cleanUpResources(ResultSet resultSet, Statement statement, Connection connection) {
		// 5. Close the resources
		if (resultSet != null) {
			try {
				// Closing ResultSet
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				// Closing Statement
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				// Closing Connection
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

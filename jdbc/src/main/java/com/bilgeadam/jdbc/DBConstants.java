package com.bilgeadam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConstants {
	public static String USER = "postgres";

	public static String PASSWORD = "1234";

	public static String URL = "jdbc:postgresql://localhost:5432/OBS";

	public static Connection DBConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWORD);
	}
}
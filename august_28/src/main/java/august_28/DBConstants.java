package august_28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConstants {
	public static final String USER = "postgres";

	public static final String PASSWORD = " ";

	public static final String URL = "jdbc:postgresql://localhost:5432/OBS";

	public static final Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
package repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static String url = "jdbc:postgresql://jdatabase.cnizg9jiyt4a.us-east-2.rds.amazonaws.com:5432/quizzard";
	private static String user = "quizuser";
	private static String password = "password";
	public static Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection(url,user, password);
		return conn;
}
	
}

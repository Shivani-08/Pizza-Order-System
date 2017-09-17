package pizzaordersystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	static Connection conn = null;

	public static void loadDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("Driver Loading Failed..!!!");
		}
	}

	public static Connection getMyConnection() {
		try {
			loadDriver();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "SCOTT", "TIGER");
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeMyConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

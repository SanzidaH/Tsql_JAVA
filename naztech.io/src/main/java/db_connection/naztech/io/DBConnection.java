package db_connection.naztech.io;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@Slf4j
public class DBConnection {
//	private static final Logger logger=LoggerFactory.getLogger(DBConnection.class);

	public static Connection conn;
	//public static DBConnection instance = null;

	DBConnection() {

		try {

			// DB CONNETION
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://vNTDACWSSQLD002:1433;"
					+ "databaseName=DEV_TEST;user=dev_test_dbo;password=dev_test_dbo123;");
			System.out.println("connection created.");

			
			CallableStatement stmt = null;

			stmt = conn.prepareCall("{call What_DB_is_that(?)}");
			stmt.setInt(1, 2);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getObject(1).toString();
				// String name = rs.getObject(2).toString();
				// System.out.println("id is " + id + "name is" + name);

				System.out.println("id is " + id + "name is");
			}
		} catch (Exception e) {
			System.out.println("Connection error: " + e.getMessage());

		}

	}

//	public static DBConnection getInstance() {
//		if (instance == null) {
//			instance = new DBConnection();
//		}
//		return instance;
//	}

	public Connection getConnection() {
		return conn;

	}

	public static void closeAll(ResultSet rs, PreparedStatement stmt, Connection conn) {
		try {
			if (rs != null && !rs.isClosed()) {
				try {
					rs.close();

				} catch (SQLException e) {
					System.out.println("The result set cannot be closed." + e);
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("The statement cannot be closed." + e);

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("The data source connection cannot be closed." + e);

				}
			}
		} catch (Exception e) {
			System.out.println("close all");

		}
	}

	public static void main(String[] args) throws SQLException {
		//new DBConnection();
		
		Queries.insertDataTrainer();
		System.out.println("successfull");
		

	}
}

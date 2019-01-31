package db_connection.naztech.io;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db_connection.naztech.io.DBConnection;

public class Queries {
 
	public static void insertDataTrainer() throws SQLException {
		
	
	DBConnection conn =  new DBConnection();
	//	Connection dbConnection = conn.getConnection();
		
		CallableStatement stmt = null;

		stmt = conn.conn.prepareCall("{call INSERTDATA114(?, ?)}");
		stmt.setInt(1, 10);
		stmt.setString(2, "lol");

		stmt.execute();
		
//		ResultSet rs = 
//		while (rs.next()) {
//			String id = rs.getObject(1).toString();
//		    String name = rs.getObject(2).toString();
//			// System.out.println("id is " + id + "name is" + name);
//
//			System.out.println("id is " + id + "name is" + name);
//		}
	}
}

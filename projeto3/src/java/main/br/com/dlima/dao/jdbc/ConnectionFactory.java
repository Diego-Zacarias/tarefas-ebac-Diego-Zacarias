package br.com.dlima.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conn;
	
	private ConnectionFactory(Connection conn) {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = initConnection();
		} else if (conn.isClosed()) {
			conn = initConnection();
		}
		return conn;
	}

	private static Connection initConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres","postgres","admin"
				);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

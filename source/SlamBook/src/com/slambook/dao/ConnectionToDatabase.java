
package com.slambook.dao;

import java.sql.*;
import java.util.logging.Logger;
/**
 * @author aditya
 *
 */
public class ConnectionToDatabase {
	private String database = "slambook";
	private String user = "root";
	private String password = "system";
	private static Logger logger;
	public Connection connection = null;

	public ConnectionToDatabase() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + database, user, password);
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

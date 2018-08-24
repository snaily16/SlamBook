package com.slambook.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.slambook.dao.ConnectionToDatabase;
import com.slambook.model.UserProfile;

/**
 * @author aditya
 *
 */
public class RegistrationServiceImpl implements RegistrationService {
	private ConnectionToDatabase connectionToDatabase = null;
	ResultSet resultSet = null;
	java.sql.PreparedStatement preparedStatement = null;

	/* (non-Javadoc)
	 * @see com.slambook.service.RegistrationService#isAlreadyRegistered(com.slambook.model.UserProfile)
	 */
	@Override
	public boolean isAlreadyRegistered(UserProfile userProfile) {
		boolean result = Boolean.FALSE;
		connectionToDatabase = new ConnectionToDatabase();
		try {
			preparedStatement = connectionToDatabase.connection.prepareStatement("");
			preparedStatement.setString(1, "");
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null)
				result = Boolean.TRUE;
			while (resultSet.next()) {

			}
		} catch (SQLException e) {
			result = Boolean.FALSE;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				connectionToDatabase.connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

}

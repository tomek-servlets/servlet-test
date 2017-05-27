package lu.lllc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools {

	public DBTools() {
		try {

			Class.forName(DBInfo.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
		}
	}

	Connection getConnction() {
		String dbURL = DBInfo.getDBURL();
		String user = DBInfo.getUser();
		String password = DBInfo.getPassword();
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL, user, password);

		} catch (SQLException e) {
			System.out.println("Error. Connection problem: " + e);

		}
		return connection;

	}

	void addNewUser(String name, String password, String role) {
		Statement statement = null;
		ResultSet result = null;

		String searchString = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
			
			searchString = "SELECT * FROM users WHERE user_name='" + name + "'";
			result = statement.executeQuery(searchString);

			if (!result.next()) {
				PreparedStatement stm = connection
						.prepareStatement("INSERT INTO users (user_name, user_pass) VALUES (?,?)");

				stm.setString(1, name);
				stm.setString(2, password);

				stm.executeUpdate();

				stm.close();
			}

			searchString = "SELECT * FROM roles WHERE role_name='" + role + "'";
			result = statement.executeQuery(searchString);

			if (!result.next()) {
				PreparedStatement stm = connection
						.prepareStatement("INSERT INTO roles (role_name) VALUES (?)");

				stm.setString(1, role);

				stm.executeUpdate();

				stm.close();
			}

			searchString = "SELECT * FROM user_roles WHERE user_name='" + name
					+ "' AND role_name='" + role + "'";
			result = statement.executeQuery(searchString);

			if (!result.next()) {
				PreparedStatement stm = connection
						.prepareStatement("INSERT INTO user_roles (user_name,role_name) VALUES (?,?)");

				stm.setString(1, name);
				stm.setString(2, role);

				stm.executeUpdate();

				stm.close();
			}

		} catch (SQLException e) {
			System.out.println("Error. Problem with adding user: " + e);
			return;
		}

	}

}

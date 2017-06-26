package lu.lllc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import lu.lllc.Book;
import lu.lllc.DBInfo;

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

	ArrayList<Book> getAllBooksList() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Statement statement = null;
		ResultSet result = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return null;
		}

		String searchString = "SELECT * FROM products";

		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return null;
		}

		try {
			while (result.next()) {
				Book book = new Book();
				long id = result.getLong("id");
				book.setId(id);

				String title = result.getString("title");
				book.setTitle(title);

				String description = result.getString("description");
				book.setDescription(description);

				float price = result.getFloat("price");
				book.setPrice(price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			System.out.println("Error. Problem reading data: " + e);
		}

		try {
			result.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookList;

	}

	// Here we use the PreparedStatement because the data come from the user
	void addNewBook(String title, String description, float price) {

		Connection connection = getConnction();

		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO products (title, description, price) VALUES (?,?,?)");

			statement.setString(1, title);
			statement.setString(2, description);
			statement.setFloat(3, price);

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error when adding a new book " + e);

		}

	}

	void setNewPrice(long id, float price) {
		Connection connection = getConnction();

		try {
			PreparedStatement statement = connection
					.prepareStatement("UPDATE products SET price = ? WHERE id = ?");
			statement.setFloat(1, price);
			statement.setLong(2, id);

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error when setting the price " + e);
		}

	}

	void deleteBooks(ArrayList<Long> list) {
		Connection connection = getConnction();

		try {
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM products WHERE id=?");

			for (Long id : list) {
				statement.setLong(1, id.longValue());
				statement.executeUpdate();
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error when deleting books " + e);
		}

	}

	void setDiscount(float discount) {
		Connection connection = getConnction();

		try {
			CallableStatement cs = connection
					.prepareCall("{ ? = call discount(?) }");
			
			//Register the output before executing (if it is a function) !!!
			cs.registerOutParameter(1, Types.BIGINT);
			cs.setFloat(2, discount);
			cs.execute();

			
			System.out.println("Number of products: " + cs.getLong(1));
			cs.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error in stored procedure call: " + e);
		}
	}
	
	void addNewUser(String name, String password, String role) {
		Statement statement = null;
		ResultSet result = null;

		String searchString = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
			
			searchString = "SELECT * FROM usersDig WHERE user_name='" + name + "'";
			result = statement.executeQuery(searchString);

			if (!result.next()) {
				PreparedStatement stm = connection
						.prepareStatement("INSERT INTO usersDig (user_name, user_pass) VALUES (?,?)");

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

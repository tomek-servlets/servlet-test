package com.patryk.adaramelech;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import com.patryk.adaramelech.Product;

public class DBTools {





	public DBTools() {
		try {

			Class.forName(DBInfo.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
		}
	}

	public Connection getConnction() {
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
	
	
	
	
	public ArrayList<Product> searchProduct(String search){
		System.out.println("Message from searchPRoduct line 53");
		ArrayList<Product> productList = new ArrayList<Product>();
		PreparedStatement statement=null;
		ResultSet result = null;

		Connection connection = getConnction();

		try {
			String searchString = "SELECT * FROM products where title LIKE ?";
		    statement=   connection.prepareStatement(searchString);
		    statement.setString(1, '%'+ search + '%');
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return null;
		}



		try {
			result = statement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return null;
		}

		try {
			while (result.next()) {
				Product product = new Product();
				long id = result.getLong("id");
				product.setId(id);

				String title = result.getString("title");
				
				System.out.println(title);
				product.setTitle(title);

				String description = result.getString("description");
				product.setDescription(description);

				float price = result.getFloat("price");
				product.setPrice(price);
				
				 String type = result.getString("tag");
				 product.setTag(type);
				 
				  
			    
			       
				
				
				productList.add(product);
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
		System.out.println("Message from searchPRoduct line 114");
		return productList;
		
		
		
	}
	
	public ArrayList<Product> returnValueOF(HashMap<Integer, Integer> cart){
		ArrayList<Product> productList = new ArrayList<Product>();
for(Integer key: cart.keySet()){
			
			Product value = getProduct(key, cart.get(key));
			System.out.println(value);
			if(value.getCont() != 0 ){
			productList.add(value);
			}
		}
return productList;

	}
	
	public ArrayList<Product> getLastProducts(){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Statement statement = null;
		ResultSet result = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return null;
		}

		String searchString = "SELECT * FROM products  ORDER BY id DESC LIMIT 5" ;

		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return null;
		}

		try {
			while (result.next()) {
				Product product = new Product();
				long id = result.getLong("id");
				product.setId(id);

				String title = result.getString("title");
				product.setTitle(title);

				String description = result.getString("description");
				product.setDescription(description);

				float price = result.getFloat("price");
				product.setPrice(price);
				
				 String type = result.getString("tag");
				 product.setTag(type);
				 
				  
			    
			       
				
				
				productList.add(product);
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

		return productList;
	}
	
	
	public ArrayList<Product> getProductLimited(String tag){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Statement statement = null;
		ResultSet result = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return null;
		}

		String searchString = "SELECT * FROM products where tag=\"" + tag + "\" ORDER BY id DESC LIMIT 3" ;

		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return null;
		}

		try {
			while (result.next()) {
				Product product = new Product();
				long id = result.getLong("id");
				product.setId(id);

				String title = result.getString("title");
				product.setTitle(title);

				String description = result.getString("description");
				product.setDescription(description);

				float price = result.getFloat("price");
				product.setPrice(price);
				
				 String type = result.getString("tag");
				 product.setTag(type);
				 
				  
			    
			       
				
				
				productList.add(product);
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

		return productList;
		
	}
	
	
	public Product getViewProduct(int idRequestInput ){
		Product product = new Product();
		Statement statement = null;
		ResultSet result = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return null;
		}

		String searchString = "SELECT * FROM products WHERE id ='" + idRequestInput + "'";

		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return null;
		}

		try {
			while (result.next()) {
			
				long id = result.getLong("id");
				product.setId(id);

				String title = result.getString("title");
				product.setTitle(title);

				String descMore = result.getString("descriptionFull");
				product.setDescMore(descMore);

				float price = result.getFloat("price");
				product.setPrice(price);
				
				 String type = result.getString("tag");
				 product.setTag(type);
				 
				 
			    
			       
				
				
				
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
		System.out.println("Message from getProduct Function in db tools everythong went fine " + product);
		return product;
		
		
		
	}
	
		
		public Product getProduct(int name, int cantvalue){
			System.out.println("Message from getProduct Function in db tools");
			Product product = new Product();
			Statement statement = null;
			ResultSet result = null;

			Connection connection = getConnction();

			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.out.println("Error. Can not create the statement: " + e);
				return null;
			}

			String searchString = "SELECT * FROM products WHERE id ='" + name + "'";

			try {
				result = statement.executeQuery(searchString);
			} catch (SQLException e) {
				System.out.println("Error. Problem with executeUpdate: " + e);
				return null;
			}

			try {
				while (result.next()) {
				
					long id = result.getLong("id");
					product.setId(id);

					String title = result.getString("title");
					product.setTitle(title);

					String description = result.getString("description");
					product.setDescription(description);

					float price = result.getFloat("price");
					product.setPrice(price);
					
					 String type = result.getString("tag");
					 product.setTag(type);
					 
					  product.setcont(cantvalue);
				    
				       
					
					
					
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
			System.out.println("Message from getProduct Function in db tools everythong went fine " + product);
			return product;
			
			
		}
		
	public ArrayList<Product> getAllProductWithTag(String tag){
		ArrayList<Product> productList = new ArrayList<Product>();
		Statement statement = null;
		ResultSet result = null;

		Connection connection = getConnction();

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return null;
		}

		String searchString = "SELECT * FROM products where tag=\"" + tag + "\"" ;

		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return null;
		}

		try {
			while (result.next()) {
				Product product = new Product();
				long id = result.getLong("id");
				product.setId(id);

				String title = result.getString("title");
				product.setTitle(title);

				String description = result.getString("description");
				product.setDescription(description);

				float price = result.getFloat("price");
				product.setPrice(price);
				
				 String type = result.getString("tag");
				 product.setTag(type);
				 
				  
			    
			       
				
				
				productList.add(product);
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

		return productList;

		
	}

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
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
				Product product = new Product();
				long id = result.getLong("id");
				product.setId(id);

				String title = result.getString("title");
				product.setTitle(title);

				String description = result.getString("description");
				product.setDescription(description);

				float price = result.getFloat("price");
				product.setPrice(price);
				
				 String type = result.getString("tag");
				 product.setTag(type);
				 
				  
			    
			       
				
				
				productList.add(product);
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

		return productList;

	}

	// Here we use the PreparedStatement because the data come from the user


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
	
	
	boolean doesUserExist(String nick){
		Statement statement = null;
		ResultSet result = null;

		String searchString = null;
       boolean status=false;
       
       
		Connection connection = getConnction();
	
		try{
			
			statement = connection.createStatement();
			
			searchString = "SELECT * FROM users WHERE user_name='" + nick + "'";
			result = statement.executeQuery(searchString);
			if (result.next()) {
				status=true;
				statement.close();
			}else{
				
				status=false;
				statement.close();
			}
			statement.close();
			
		}catch (SQLException e) {
			System.out.println("Error. Problem with Login: " + e);
			return false;
		}
		return status;
		
	}
	
	
	
	boolean isThePasswordCorrect(String user, String pass){
		Statement statement = null;
		ResultSet result = null;

		String searchString = null;
       boolean status=false;
       
       
		Connection connection = getConnction();
	
		try{
			
			statement = connection.createStatement();
			
			searchString = "SELECT * FROM users WHERE user_name='" + user+ "' AND user_pass='" + pass + "'";
			result = statement.executeQuery(searchString);
			if (result.next()) {
				status=true;
				statement.close();
			}else{
				
				status=false;
				statement.close();
			}
			statement.close();
		}catch (SQLException e) {
			System.out.println("Error. Problem with Login: " + e);
			return false;
		}
		return status;
		
	}
	
	
}

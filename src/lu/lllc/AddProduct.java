package lu.lllc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection;
		Statement statement;
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		
		String dbURL = DBInfo.getDBURL();
		String user = DBInfo.getUser();
		String password = DBInfo.getPassword();

		try {

			Class.forName(DBInfo.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
		}
		
		try {
			connection = DriverManager.getConnection(dbURL, user, password);
		} catch (SQLException e) {
			System.out.println("Error. Connection problem: " + e);
			return;
		}
		
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return;
		}
		
		String updateString = "INSERT INTO products VALUES (0,'" + title + "','" + description + "'," + price + ")";
		try {
			statement.executeUpdate(updateString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return;
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error. Problem with closing connection: " + e);
			return;
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/addingOk.jsp");
		disp.forward(request, response);

		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

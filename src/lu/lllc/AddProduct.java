package lu.lllc;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title;
		String description;
		float price;

		try {
			title = request.getParameter("title");
			description = request.getParameter("description");
			price = Float.parseFloat(request.getParameter("price"));
		} catch (NumberFormatException e) {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/wrongParameterError.html");
			disp.forward(request, response);
			return;

		}

		DBTools dbTools = new DBTools();

		dbTools.addNewBook(title, description, price);

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/addingOk.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

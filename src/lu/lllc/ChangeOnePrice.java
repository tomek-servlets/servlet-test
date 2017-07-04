package lu.lllc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeOnePrice
 */
@WebServlet("/ChangeOnePrice")
public class ChangeOnePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeOnePrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBTools dbTools = new DBTools();

		long id;
		float price;
		try {
			id = Long.parseLong(request.getParameter("id"));
			price = Float.parseFloat(request.getParameter("newPrice"));
		} catch (NumberFormatException e) {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/wrongParameterError.html");
			disp.forward(request, response);
			return;

		}

		dbTools.setNewPrice(id, price);

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/priceChangeOk.jsp");
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

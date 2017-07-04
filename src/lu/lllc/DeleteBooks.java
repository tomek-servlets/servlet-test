package lu.lllc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBooks
 */
@WebServlet("/DeleteBooks")
public class DeleteBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> parNames = request.getParameterNames();

		ArrayList<Long> list = new ArrayList<Long>();

		try {
			while (parNames.hasMoreElements()) {
				String name = (String) parNames.nextElement();
				list.add(new Long(name));
			}
		} catch (NumberFormatException e) {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/wrongParameterError.html");
			disp.forward(request, response);
			return;
		}

		DBTools dbTools = new DBTools();
		dbTools.deleteBooks(list);

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/deletingOk.jsp");
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

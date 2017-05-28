package com.patryk.adaramelech;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllProductsWithValue
 */
@WebServlet("/GetAllProductsWithValue")
public class GetAllProductsWithValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllProductsWithValue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  tag = (String) request.getParameter("tag");
		Principal username = request.getUserPrincipal();
		DBTools db = new DBTools();
		ArrayList<Product> List = db.getAllProductWithTag(tag);
		   request.setAttribute("List", List);
		   request.setAttribute("Name",tag.toUpperCase());
		   request.setAttribute("userName", username);
		 RequestDispatcher view = request.getRequestDispatcher("category/category.jsp");
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

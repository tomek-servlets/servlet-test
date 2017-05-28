package com.patryk.adaramelech;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String searchPatern= (String) request.getAttribute("search");
	String status;
    
		DBTools db = new DBTools();
		ArrayList<Product> searchMatch = db.searchProduct(searchPatern);

		 if(searchMatch.isEmpty()){
				System.out.println("from if  Serach Product");
			 status="none";
			 ArrayList<Product> lastFive = db.getLastProducts();
			 request.setAttribute("lastFive", lastFive);
request.setAttribute("status", status);
request.setAttribute("searchP", searchPatern);
		 }else{
		System.out.println("from else  Serach Product");
status="ok";
request.setAttribute("searchMatch", searchMatch);
request.setAttribute("status", status);
		 }
		
		
		 RequestDispatcher view = request.getRequestDispatcher("search.jsp");
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

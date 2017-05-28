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
 * Servlet implementation class Display3MaxIndexPage
 */
@WebServlet("/Display3MaxIndexPage")
public class Display3MaxIndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display3MaxIndexPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Principal username = request.getUserPrincipal();
		
	          
		DBTools db = new DBTools();
		ArrayList<Product> ListCPU = db.getProductLimited("cpu");
		ArrayList<Product> ListGPU = db.getProductLimited("graphic_card");
		ArrayList<Product> ListBody = db.getProductLimited("body");
		 request.setAttribute("Cpu",ListCPU);
		 request.setAttribute("Gpu",ListGPU);
		 request.setAttribute("Body",ListBody);
		 if(request.isUserInRole("admin")){
			 request.setAttribute("admin", "admin");
		 }
		 request.setAttribute("userName", username);
		 RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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

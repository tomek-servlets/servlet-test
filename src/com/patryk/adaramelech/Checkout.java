package com.patryk.adaramelech;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Principal username = request.getUserPrincipal();
		
		 

			 @SuppressWarnings("unchecked")
				HashMap<Integer, Integer > cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
				
				String Message= "";
				if(cart == null){
				Message="nothing to checkout";
				response.sendRedirect("CartShop?message=" + Message);
				}
				
				
			
				
				
				if(!cart.isEmpty()){
				
					   Message= "Please select the form for input informations where to send your products!";
					cart.clear();
					
				}else{
					Message="nothing to checkout";
					
				}
				  request.setAttribute("userName", username);
				request.setAttribute("Message", Message);
				request.getRequestDispatcher("client/checkout.jsp").forward(request, response);
			 
		 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

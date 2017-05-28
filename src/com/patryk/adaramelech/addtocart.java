package com.patryk.adaramelech;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class addtocart
 */
@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		

				@SuppressWarnings("unchecked")
				HashMap<Integer, Integer > cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
			
				if(cart == null){
					cart = new HashMap<Integer, Integer>();
			
					//Only here we add the array to the session
					//In fact we add the reference to the array
					//Next we just add elements to the array
					session.setAttribute("cart", cart);
				
				}
				
				int  product = Integer.parseInt(request.getParameter("name"));
				int valuecont =0;
			
				if (product !=0 ) {
			
					//We add the  product to the array
					//We do not need to add anything to the session 
					//The reference to our list is added to the session
					
					if(cart.containsKey(product)){
						int value= cart.get(product);
						System.out.println("Value before increase " + value);
						value ++;
						System.out.println("Value after increase " + value);
						cart.put(product, value);
					}else{
						System.out.println("Value doesn't exist so add to array!");
						valuecont =1;
						cart.put(product, valuecont);
					}
					
				}
				
				
			 
		
		response.sendRedirect("CartShop?message=Added to Cart");
		
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

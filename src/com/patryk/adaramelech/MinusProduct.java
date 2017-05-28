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
 * Servlet implementation class MinusProduct
 */
@WebServlet("/MinusProduct")
public class MinusProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinusProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer > cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
		String Message= "";
		if(cart == null){
			cart = new HashMap<Integer, Integer>();
	
			//Only here we add the array to the session
			//In fact we add the reference to the array
			//Next we just add elements to the array
			session.setAttribute("cart", cart);
		
		}
		
		
		int  product = Integer.parseInt(request.getParameter("id"));
		
		
		if(cart.containsKey(product)){
			int value= cart.get(product);
			if(value != 0){
			if( value >0){
			System.out.println("Value before increase " + value);
			value --;
			System.out.println("Value after increase " + value);
			Message = "You have decreased item by -1";
			cart.put(product, value);
			}
			}else{
				Message="Completely removed from Cart";
				cart.remove(product);
			}
		}else{
			System.out.println("Value doesn't exist !!!!");
		   Message= "Item doesn't exist don't try again!";
		}
		
		response.sendRedirect("CartShop?message=" + Message);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

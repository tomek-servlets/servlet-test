package com.patryk.adaramelech;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import com.patryk.adaramelech.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CartShop
 */
@WebServlet("/CartShop")
public class CartShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String message =	(String) request.getParameter("message");
		
	 boolean status = false;
	 HttpSession session = request.getSession();

	

	  
	 

		 DBTools db = new DBTools();
			@SuppressWarnings("unchecked")
			HashMap<Integer, Integer > cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
			ArrayList<Product> productList = null ;
			if(cart != null ){
			 productList = db.returnValueOF(cart);
				 status= true;
				
			}else{
			status = false;
			}
			


			float allCartProductPrice=0;
			
			
			
			// Comment issu with jstl tags foreach doesn't get the Object.function exmp : Product.getID() 
			//request.setAttribute("cartList", productList);
			// response.sendRedirect("client/cart.jsp");
			 
			
			
			
			// String for boostrap, js, 
			response.setContentType("text/html;charset=UTF-8");
			String Meta_Boostrap= "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
			String boostrapCSS= " <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" >";
			String JQueryJS = " <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>";
			String BoostrapJS = "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>";
			String ContDiv= "  <div class=\"container\">";
			String ContDivEnd="</div>";
			String url_MainPAge="<a href=\"/ComputerShop/\"><button style=\"text-align: right;\" type=\"button\" class=\"btn btn-success\"> Main Page</button></a>"; 
			String RefreshButton= "<a href=\"CartShop\"><button style=\"text-align: right;\" type=\"button\" class=\"btn btn-success pull-right\"> <span class=\"glyphicon glyphicon-refresh\"></span></button></a> ";
			String div_fluid= " <div class=\"row-fluid\">";
			String div_info="<div class=\"alert alert-info\">";
			String title="<title>Cart</title>";
			PrintWriter out = response.getWriter();
			
			out.println("<html> "); 
			out.println("<head>");
			out.println(Meta_Boostrap);
			out.println(boostrapCSS);
			out.println(title);
			out.println("</head>");
			out.println("<body>");
			out.print(ContDiv);
			out.println("<h2>Cart</h2>");
		
			if(message == null){
				message= "";
			}else{
				out.println(div_info);
				out.println(message);
				out.println(ContDivEnd);
			}
			out.println(url_MainPAge);
			out.println(div_fluid);
			out.println(RefreshButton);
			out.println(ContDivEnd);
			out.println("  <table class=\"table table-striped\">");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>Title</th>");
			out.println("<th>Price</th>");
			out.println("<th>Qunatity</th>");
			out.println("<th>Items * Quantity</th>");
			out.println("<th> Options</th>");
		
			
			out.println("<tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			
			
			if(cart == null && status == false && productList == null) {
				out.println(div_info);
				out.println("<h4>No items in cart!</h4>");
				out.println(ContDivEnd);
			}else{
				
			
				for(Product x: productList){
					out.println("<tr>");
					out.println("<td><a href=\"ViewProduct?id="+x.getId()+ "\">" + x.getTitle()+  "</a></td>");
					out.println("<td>" + x.getPrice() + " $ </td>"); 
					out.println("<td>" + x.getCont() + "</td>");
					out.println("<td> " + x.getPrice()*x.getCont() + " $</td>" );
					allCartProductPrice +=  (x.getPrice()*x.getCont());
					out.println("<td><a href=\"MinusProduct?id="+x.getId()+ "\"> <button type=\"button\" class=\"btn btn-success\"> -</button></a></td>");
					out.println("<td><a href=\"IncreaseProduct?id="+x.getId()+ "\"><button type=\"button\" class=\"btn btn-success\"> +</button></a></td>");
					out.println("<td><a href=\"DeleteAllProducts?id="+x.getId()+ "\"><button type=\"button\" class=\"btn btn-success\">Delete All</button></a></td>");
					out.println("</tr>");
				}
			
			}
			
			

			out.println("</tbody>");
			out.println(" </table>");
			out.println(div_fluid);
		
			out.println(" <button type=\"button\" class=\"btn btn-success pull-right\"> Total Price : " + allCartProductPrice+" $</button><br><br><br><br>");
			if(status == true){
			out.println("<td><a href=\"Checkout\"><button type=\"button\" class=\"btn btn-success  pull-right\">Checkout</button></a></td>");}
			out.println(ContDivEnd);
			out.println(ContDivEnd);
			out.println(JQueryJS);
			out.print(BoostrapJS);
			out.println("</body");
			out.println("</html> "); 
			
	
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

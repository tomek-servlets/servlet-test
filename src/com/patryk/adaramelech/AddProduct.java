package com.patryk.adaramelech;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.patryk.adaramelech.DBTools;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig(maxFileSize = 16177216)
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
		
		
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = 0;
		String full;
		String title;
		String description;
		float price;
		String tag;
		
 DBTools db= new DBTools();
	
 Connection con = db.getConnction();
 title = request.getParameter("title");
	description = request.getParameter("description");
	 full = request.getParameter("descriptionFull");
	price = Float.parseFloat(request.getParameter("price"));
Part img = request.getPart("image");
	tag= request.getParameter("tag");
		
		try {
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO products (title, descriptionFull ,description, price, image, tag) VALUES (?,?,?,?,?,?)");

			statement.setString(1, title);
			statement.setString(2, full);
			statement.setString(3, description);
			statement.setFloat(4, price);
			InputStream is = img.getInputStream();
			statement.setBlob(5, is);
			statement.setString(6, tag);

			result = statement.executeUpdate();

			statement.close();
			con.close();
			
	}catch(Exception e){
		e.printStackTrace();
	}	
	finally{
		if(con != null){
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}


if(result > 0){
	 request.setAttribute("Message", "Product Added to Database!");
	 RequestDispatcher view = request.getRequestDispatcher("Display3MaxIndexPage");
        view.forward(request, response);
}
else{
	 request.setAttribute("Message", "Product wasn't added to database!");
	 RequestDispatcher view = request.getRequestDispatcher("Display3MaxIndexPage");
        view.forward(request, response);
}
	}

}

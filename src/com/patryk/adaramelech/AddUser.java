package com.patryk.adaramelech;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.realm.RealmBase;

import com.patryk.adaramelech.DBTools;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String password = request.getParameter("password");
	 String	Message="";
	
		
		if(!name.isEmpty() && !password.isEmpty()) {
			DBTools base = new DBTools();
			password = RealmBase.Digest(password, "SHA", "UTF-8");
			
			base.addNewUser(name, password, role);
			
			RequestDispatcher disp = request.getRequestDispatcher("/forms/login.jsp");
			disp.forward(request, response);
			
			
		}else{
			
			Message ="Empty fields!";
			request.setAttribute("Message", Message);
			request.getRequestDispatcher("errorRegister.jsp").forward(request, response);
		}
		
		
		
	
	}

}

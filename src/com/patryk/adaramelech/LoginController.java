package com.patryk.adaramelech;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.RealmBase;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession();
		String isLogin= "isLogin";
	        String user = request.getParameter("j_username");
	        String pass2 = request.getParameter("j_password");
	String	 pass = RealmBase.Digest(pass2, "SHA", "UTF-8");
	    
	        String statusMessage = "";
	        
	        DBTools db = new DBTools();
	        
	        
	        if(db.doesUserExist(user)){
	        	
	        	if(db.isThePasswordCorrect(user, pass)){
	        		
	        		
	        		
        try{	
        	if (request.getUserPrincipal() == null ) {
        	    request.getSession(); // create session before logging in
        	    request.login(user, pass2);
        	
				session.setAttribute("userName", user);
        	    session.setAttribute("status", isLogin);
                 response.sendRedirect("Display3MaxIndexPage");
        	}
                        
                         
                         
                         
        }catch (Exception e) {
            throw new ServletException(e);
        } finally {
            request.logout();
       
        }
	        	}
	        
	        	else{
	        		statusMessage = "The user you tried to log on with doesn't exist.";
	        		request.setAttribute("message", statusMessage);
		        	request.getRequestDispatcher("/forms/loginUserError.jsp").forward(request, response);
	        	
	        	}
	        }else{
	        	statusMessage = "The user you tried to log on with doesn't exist.";
	        	request.setAttribute("message", statusMessage);
	        	request.getRequestDispatcher("/forms/loginUserError.jsp").forward(request, response);
	        }
	        
	}

}

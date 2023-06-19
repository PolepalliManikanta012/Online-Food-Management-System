package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
	      String password = request.getParameter("password");
	      
	      if(uname.equals("admin") && password.equals("Admin"))
	      {
	    	  response.sendRedirect("/Food_Master/Admin/AddItems.jsp");
	      }
	      else
	      {
	    	  response.sendRedirect("/Food_Master/Admin/AdminLogin.jsp");
	      }
	}


}

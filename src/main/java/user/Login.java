package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
boolean status=false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
	    {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/master","root","Mani@123");
	      
	      String uname = request.getParameter("uname");
	      String password = request.getParameter("password");
	      
	      PreparedStatement preparedStatement = con.prepareStatement("select * from user where uname = ? and password = ? ");
	       
	      preparedStatement.setString(1, uname);
	       preparedStatement.setString(2, password);
	       
	       ResultSet rs = preparedStatement.executeQuery();
	              status = rs.next();
	              if(status)
	              {
	            	HttpSession httpSession = request.getSession();
	            	httpSession.setAttribute("user",uname);
	            	
	                response.sendRedirect("Display.jsp");
	              }
	              else
	              {
	            	HttpSession httpSession = request.getSession();
		            httpSession.setAttribute("invalid","Invalid user name or Password");
		            response.sendRedirect("Login.jsp");
	              }
	    }
	    catch (Exception e)
	    {
	      System.out.print(e);
	    }
	  }
	}





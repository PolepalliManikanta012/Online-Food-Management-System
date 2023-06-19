package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UserRegister
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
	    {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/master","root","Mani@123");
	      
	      String uname = request.getParameter("uname");
	      String name = request.getParameter("name");
	      String mobile = request.getParameter("mobile");
	      String password = request.getParameter("password");
	      String gender = request.getParameter("uname");
	     	      
	      PreparedStatement preparedStatement = con.prepareStatement("insert into user(name,gender,password,uname,mobile) values(?,?,?,?,?)");
	       
	       preparedStatement.setString(1, name);
	       preparedStatement.setString(2, gender);
	       
	       preparedStatement.setString(3, password);
	       preparedStatement.setString(4, uname);
	       preparedStatement.setString(5, mobile);
	      
	       int rs = preparedStatement.executeUpdate();
	       
	       if(rs==1)
	       {
	    	   HttpSession httpSession = request.getSession();
           		httpSession.setAttribute("registered","Successfully Registered!!!");
	    	   response.sendRedirect("Register.jsp");
	    	   
	       }
	       
	    }
	    catch (Exception e)
	    {
	      System.out.print(e);
	    }
	}
	
	

}

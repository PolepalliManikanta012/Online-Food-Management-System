package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class DeleteCart
 */
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
	    {
			HttpSession session = request.getSession();
			String uname =(String) session.getAttribute("user");
		  	Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/master","root","Mani@123");
	      
	      
	      String name = request.getParameter("item");
	      
	      
	      
	      Statement statement = con.createStatement();
	      statement.execute("DELETE FROM cart WHERE name='"+name+"'and uname='"+uname+"'");
	       
	              
	              
	            	HttpSession httpSession = request.getSession();
	            	httpSession.setAttribute("delete","Item Deleted from cart Sucessfully....");
	                response.sendRedirect("http://localhost:8080/Food_Master/Cart.jsp");
	              

	    }
	    catch (Exception e)
	    {
	      System.out.print(e);
	      HttpSession httpSession = request.getSession();
      	httpSession.setAttribute("delete",e);
          response.sendRedirect("http://localhost:8080/Food_Master/Cart.jsp");
	    }
	  }
	}





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
 * Servlet implementation class Increment
 */
public class Increment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Increment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
	    {
			String connectionURL = "jdbc:mysql://localhost:3306/master";
			Connection connection = null;
			Statement statement = null,state=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "root", "Mani@123");
			statement = connection.createStatement();
			
			HttpSession session = request.getSession();
		  	String uname =(String) session.getAttribute("user");
		  	String item = request.getParameter("item");
		  	ResultSet r = statement.executeQuery("SELECT * FROM cart where name='"+item+"'and uname='"+uname+"'");
		  	
		  	r.next();
		  	int quantity = r.getInt(6);
		  	quantity = quantity+1;
		  	state = connection.createStatement();
		  	int x = state.executeUpdate("UPDATE cart SET quantity ='"+quantity+"' WHERE name='"+item+"'and uname='"+uname+"'");
		  	

	       
	    	 
	    	   response.sendRedirect("Cart.jsp");
	  
	       
	    }
	    catch (Exception e)
	    {
	      System.out.print(e);
	    }
	
	
	}
	}






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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class UserRegister
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
	    {
			String connectionURL = "jdbc:mysql://localhost:3306/master";
			Connection connection = null;
			Statement statement = null;
			
			Statement state = null;
			ResultSet r = null;
			connection = DriverManager.getConnection(connectionURL, "root", "Mani@123");
			statement = connection.createStatement();
			Class.forName("com.mysql.cj.jdbc.Driver");
			HttpSession session = request.getSession();
		  	String uname =(String) session.getAttribute("user");
			String name=request.getParameter("item");
			
			ResultSet rm = statement.executeQuery("SELECT * FROM cart where name='"+name+"'and uname='"+uname+"'");
		  	
		  	
		  	
		  	if(rm.next())
		  	{
		  		int quantity = rm.getInt(6);
		  		quantity = quantity+1;
			  	state = connection.createStatement();
			  	int x = state.executeUpdate("UPDATE cart SET quantity ='"+quantity+"' WHERE name='"+name+"'and uname='"+uname+"'");
			  	
		  	}
			
			
			else {
			r = statement.executeQuery("SELECT * FROM items where name='"+name+"'");
	  	
	  	String cuisine=null;
	  	int price=0;
	  	int Itemid=0;
	  	while (r.next()) {
	  			  		
	  		Itemid=r.getInt(1);
	  		cuisine=r.getString(3);
	  		price=r.getInt(4);
	  	
	  	}
	  	int quantity1=1;
	  	
	  	
	      PreparedStatement preparedStatement = connection.prepareStatement("insert into cart values(?,?,?,?,?,?)");
	       
	      preparedStatement.setString(1, uname);
	      preparedStatement.setInt(2, Itemid);
	      preparedStatement.setString(3, name);
	      preparedStatement.setString(4, cuisine);
	       preparedStatement.setInt(5, price);
	       preparedStatement.setInt(6, quantity1);
	       
	      
	       int rs = preparedStatement.executeUpdate();
		  	}
	       
	      
	    	   HttpSession httpSession = request.getSession();
           		httpSession.setAttribute("cart","Successfully Added To Cart!!!");
	    	   response.sendRedirect("Display.jsp");
	    	   
	     
	       
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	}
	
	

}

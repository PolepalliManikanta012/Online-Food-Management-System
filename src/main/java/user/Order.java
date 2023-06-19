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
 * Servlet implementation class Order
 */
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
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
			Statement statement = null;
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "root", "Mani@123");
			statement = connection.createStatement();
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			HttpSession session = request.getSession();
		  	String uname =(String) session.getAttribute("user");
		  	int total =0;
		  	String status="Order Placed";
		  	
			PreparedStatement preparedStatement = connection.prepareStatement("insert into orders(name,price,uname,address,status) values(?,?,?,?,?)");
		       
		       preparedStatement.setString(1, name);
		       preparedStatement.setInt(2, total);
		       preparedStatement.setString(3, uname);
		       preparedStatement.setString(4, address);
		       preparedStatement.setString(5, status);
		       preparedStatement.executeUpdate();
		       
		       
		       PreparedStatement ps = connection.prepareStatement("SELECT MAX(order_id) AS max_id FROM orders;");
		       ResultSet id = ps.executeQuery(); 
		       id.next();
		       int mx = Integer.parseInt(id.getString("max_id"));
		       
		      
		   	
		    ResultSet r = statement.executeQuery("SELECT * FROM cart where uname='"+uname+"'");
		       
			
	  	String cuisine=null,itemname=null;
	  	int itemprice=0;
	  	int Itemid=0;
	  	int quantity=0;
	  	while (r.next()) {
	  			  		
	  		Itemid=r.getInt(2);
	  		cuisine=r.getString(4);
	  		itemprice=r.getInt(5);
	  		itemname=r.getString(3);
	  		quantity=r.getInt(6);
	  		PreparedStatement preparedStatement1 = connection.prepareStatement("insert into order_details values(?,?,?,?,?,?,?)");
		       
		      preparedStatement1.setInt(1, mx);
		      preparedStatement1.setString(2, uname);
		      preparedStatement1.setInt(3, Itemid);
		      preparedStatement1.setString(4, itemname);
		      preparedStatement1.setString(5, cuisine);
		       preparedStatement1.setInt(6, itemprice);
		       preparedStatement1.setInt(7, quantity);
		       preparedStatement1.executeUpdate();
		        total=total+itemprice;
		      		       
	  	}
	  	PreparedStatement preparedStatement3=connection.prepareStatement("UPDATE orders SET price =? WHERE uname = ?");
	  	
	  	preparedStatement3.setInt(1, total);
	  	preparedStatement3.setString(2, uname);
	  	preparedStatement3.executeUpdate();
	  	
	       
	       
	    	   HttpSession httpSession = request.getSession();
           		httpSession.setAttribute("ordered","Successfully Ordered!!!");
	    	   response.sendRedirect("Orders.jsp");
	  
	       
	    }
	    catch (Exception e)
	    {
	      System.out.print(e);
	    }
	
	
	}



}

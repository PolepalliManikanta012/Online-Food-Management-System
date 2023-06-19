package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String connectionURL = "jdbc:mysql://localhost:3306/master";
		Connection connection = null;
		Statement statement = null;
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(connectionURL, "root", "Mani@123");
		statement = connection.createStatement();
		String uname =(String) request.getParameter("item");
		String co="Delivered Sucessfully";
		int id=Integer.parseInt(uname);
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE orders SET status =? WHERE order_id = ?");
	  	
	  	preparedStatement.setString(1, co);
	  	preparedStatement.setInt(2, id);
	  	preparedStatement.executeUpdate();
	  	response.sendRedirect("update.jsp");
		}
		catch(Exception e)
		{
			
		}
	}


}

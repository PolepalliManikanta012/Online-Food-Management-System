package admin;

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

/**
 * Servlet implementation class AddItem
 */
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
	    {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/master","root","Mani@123");
	      
	      String name = request.getParameter("name");
	      String cuisine = request.getParameter("cuisine");
	      int price = Integer.parseInt(request.getParameter("price"));
	     
	     	      
	      PreparedStatement preparedStatement = con.prepareStatement("insert into items(name,cuisine,price) values(?,?,?)");
	       
	       preparedStatement.setString(1, name);
	       preparedStatement.setString(2, cuisine);
	       
	       preparedStatement.setInt(3, price);
	      
	      
	       int rs = preparedStatement.executeUpdate();
	       
	       if(rs==1)
	       {
	    	   HttpSession httpSession = request.getSession();
           		httpSession.setAttribute("item","Successfully Item Added!!!");
	    	   response.sendRedirect("/Food_Master/Admin/AddItems.jsp");
	    	   
	       }
	       
	    }
	    catch (Exception e)
	    {
	      System.out.print(e);
	      HttpSession httpSession = request.getSession();
     		httpSession.setAttribute("item","Item Already Exist");
  	   response.sendRedirect("/Food_Master/Admin/AddItems.jsp");
	    }
	}


}

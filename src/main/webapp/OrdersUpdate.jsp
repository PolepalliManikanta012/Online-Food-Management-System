<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding:10px 10px 10px 10px;
}

table.center {
  margin-left: 266px;
    margin-right: 50px;
}
</style>
</head>	
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">KL FOOD COURT</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto my-2 my-lg-0">
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="Home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="logout.jsp">Logout</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link " href="Display.jsp">Menu</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="Cart.jsp">Cart</a>
        </li>
        </ul>
     </div>
  </div>
</nav>
<%try {
	String connectionURL = "jdbc:mysql://localhost:3306/master";
	Connection connection = null;
	Statement statement = null;
	Statement state = null;
	ResultSet rs = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection(connectionURL, "root", "Mani@123");
	statement = connection.createStatement();
	String uname =(String)session.getAttribute("user");
	rs = statement.executeQuery("SELECT * FROM orders where uname='"+uname+"'");
	
	//ResultSet c = state.executeQuery("SELECT * from user");
	//c.last();
	
	//if(count>0){%>

<table class="center">
<%@include file="alerts/cart.jsp" %>
<h2 style="font-family:courier;margin:40px 0px 20px;font-weight: bold;text-align: center;">Orderes Placed</h2>
<th>
Order Id
</th>
<th>
Name
</th>
<th>
Date & Time
</th>
<th>
Total Price
</th>
<th>Address
</th>
<th>Status</th>
<th>Action</th>

<%
while (rs.next()) {
%>

<TR >
<TD><%=rs.getInt(1)%></TD>
<TD><%=rs.getString(2)%></TD>
<TD><%=rs.getTimestamp(3)%></TD>
<TD><%=rs.getInt(4)%></TD>
<td><%=rs.getString(6)%></td>
<td><%=rs.getString(7)%></td>
<td><form action="http://localhost:8080/Food_Master/Order_details.jsp"><button class="btn btn-light" name="item" value=<%=rs.getInt(1)%> onclick="submit">View more Details</button></form>
</td>
</TR>
<% }
//}else {%>

</form>
<!--  <h4>No Applications</h4>-->
<%
	rs.close();
	statement.close();
	connection.close();
} catch (Exception ex) {
%>

<%
out.println("Unable to connect  database.");
}
%>

</table>

</body>
</html>
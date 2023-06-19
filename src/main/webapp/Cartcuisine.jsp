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
  margin-left: 430px;
    margin-right: 50px;
}
.btn.center{
margin-left:600px;
}
.btn-group
{
margin-left:550px;
padding-bottom:20px
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
        <li class="nav-item">
          <a class="nav-link " href="Display.jsp">Menu</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link " href="Cart.jsp">Cart</a>
        </li>
        </ul>
     </div>
  </div>
</nav>
<%int total=0; %>
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
  	String cui=request.getParameter("cuisine");
	String QueryString = "SELECT * FROM cart where uname='"+uname+"'and cuisine='"+cui+"'";
	rs = statement.executeQuery(QueryString);
	//ResultSet c = state.executeQuery("SELECT * from user");
	//c.last();
	
	
	//if(count>0){%>


<table class="center">
<%@include file="alerts/delete.jsp" %>
<h2 style="font-family:courier;margin:40px 0px 20px;font-weight: bold;text-align: center;">Cart</h2>
	
		<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
	<form action="Cart.jsp">
  <input type="radio" class="btn-check" name="cuisine"  autocomplete="off" checked>
  <label class="btn btn-outline-primary" for="cuisine" onclick="submit">All</label>
	</form>
	<form action="Cartcuisine.jsp">
  <input type="radio" class="btn-check" name="cuisine"  autocomplete="off">
  <label class="btn btn-outline-primary" for="cuisine" value="Indian" onclick="submit">Indian</label>
	</form>
	<form action="Cartcuisine.jsp">
  <input type="radio" class="btn-check" name="cuisine"  autocomplete="off">
  <label class="btn btn-outline-primary" for="cuisine" value="Chinese" onclick="submit">Chinese</label>
  </form>
</div>

<th>
Item Id
</th>
<th>
Item Name
</th>
<th>
Cuisine
</th>
<th>
Item Price
</th>
<th>
Quantity
</th>
<th>
Action
</th>

<%
while (rs.next()) {
int price=rs.getInt(5);
int quantity=rs.getInt(6);
total=total+(price*quantity);%>

<TR >
<TD><%=rs.getInt(2)%></TD>
<TD><%=rs.getString(3)%></TD>
<TD><%=rs.getString(4)%></TD>
<TD><%=price%></TD>
<td><%=quantity%></td>
<td><form action="Decrement"><button class="btn btn-light" name="xme" value=<%=rs.getString(3)%> onclick="submit">-</button></form><form action="DeleteCart"><button class="btn btn-light" name="item" value=<%=rs.getString(3)%> onclick="submit">Delete</button></form><form action="Increment"><button class="btn btn-light" name="item" value=<%=rs.getString(3)%> onclick="submit">+</button></form>
</TR>
<% }
//}else {%>
<tr>
<td></td>
<td></td>
<td>Total :</td>
<td><%=total%></td>
<td></td>
<td></td>
</tr>
</form>
<!--  <h4>No Applications</h4>-->
<%
	rs.close();
	statement.close();
	connection.close();
} catch (Exception ex) {
%>

<%
out.println("Unable to connect to database.");
}
HttpSession httpSession = request.getSession();
httpSession.setAttribute("total",total);%>

</table>
<br>
<form action="http://localhost:8080/Food_Master/Order.jsp"><button class="btn btn-light center"  name="order" onclick="submit">Place Order</button></form>
</body>
</html>
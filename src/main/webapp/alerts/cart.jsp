<%
String message =(String)session.getAttribute("cart");
if(message!=null)
{
	//out.println(message);%>
	<div class="alert alert-success" role="alert">
  <%=message %>
</div>
	
	<%
	session.removeAttribute("cart");
}
%>
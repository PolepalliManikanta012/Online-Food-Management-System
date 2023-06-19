<%
String message =(String)session.getAttribute("delete");
if(message!=null)
{
	//out.println(message);%>
	<div class="alert alert-success" role="alert">
  <%=message %>
</div>
	
	<%
	session.removeAttribute("delete");
}
%>
<%
String message =(String)session.getAttribute("invalid");
if(message!=null)
{
	//out.println(message);%>
	<div class="alert alert-danger" role="alert">
  <%=message %>
</div>
	
	<%
	session.removeAttribute("invalid");
}
%>
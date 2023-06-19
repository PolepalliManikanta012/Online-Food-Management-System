<%
String message =(String)session.getAttribute("registered");
if(message!=null)
{
	//out.println(message);%>
	<div class="alert alert-success" role="alert">
  <%=message %>
</div>
	
	<%
	session.removeAttribute("registered");
}
%>
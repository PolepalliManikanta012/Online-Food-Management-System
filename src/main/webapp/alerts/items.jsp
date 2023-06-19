<%
String message =(String)session.getAttribute("item");
if(message!=null && message.equals("Item Already Exist"))
{
	//out.println(message);%>
	<div class="alert alert-danger" role="alert">
  <%=message %>
</div>
	
<%
}
else if(message!=null)
{
	%>
	<div class="alert alert-success" role="alert">
  <%=message %>
</div>
<% }

session.removeAttribute("item");
%>
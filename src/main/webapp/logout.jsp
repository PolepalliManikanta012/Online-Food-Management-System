<%

	
//String message =(String)session.getAttribute("user");
//System.out.println(message);
	session.removeAttribute("user");
	String redirectURL = "/Food_Master/Home.jsp";
	response.sendRedirect(redirectURL);

%>
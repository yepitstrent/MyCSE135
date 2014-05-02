<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ExamplePackage.UserBean"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><%System.out.println("IN THE TOP OF CONF"); %>
	<%
		UserBean currentUser = (UserBean) (session
				.getAttribute("currentSessionUser"));
	
	%>
	Welcome
	<%=currentUser.getUsername()%>
	<form action=LoginServlet>
		<input type="submit" value="Logout"><br> <input
			type="hidden" name="st" value="default">
	</form>
	
	<form action=userLogged.jsp>
		<input type="submit" value="Go Home">
	</form>
	
	<% String[] arr = currentUser.getConfirmation(); %>
	
	Products Purchaced:
	<%
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			out.print(" <tr><form><th><input value=\" " + arr[i]
					+ " \" name=\"name" + i
					+ "\" size=\"10\"/ readonly></th><th></th><th>"
					+ "</th></form></tr>");
		}
	%>

</body>
</html>
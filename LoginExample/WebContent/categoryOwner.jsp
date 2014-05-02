<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ExamplePackage.UserBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		<input type="submit" value="Go Back">
	</form>

	<h1>Add a new category</h1>

	<form action=LoginServlet>
		Enter a New Category: <input type="text" name="catname" /><br>
		Description: <input type="text" name="catdesc" /><br> <input
			type="submit" value="Submit"> <input type="hidden" name="st"
			value="5">
	</form>


	<h1>Delete a non-empty category</h1>

	<form action=LoginServlet>
		<%
			String[] strName = currentUser.getCatNameArrList().clone();
		%>
		<%
			String[] strDesc = currentUser.getCatDescArray().clone();
		%>


		<%
			int i = 0;
			for (i = 0; i < strName.length; i++) {
				out.print(" <tr><form><th><input value=\" "
						+ strName[i]
						+ " \" name=\"newname"
						+ i
						+ "\" size=\"10\"/></th><th><input value=\""
						+ strDesc[i]
						+ "\" name=\"newdesc"
						+ i
						+ "\" size=\"40\"/></th><th>"
						+ "<form action=LoginServlet><input type=\"submit\" name=\"updatecat"
						+ i
						+ "\" value=\"Update\" />"
						+ "<input type=\"hidden\" name=\"CatIndex\" value=\""
						+ i
						+ "\" >"
						+ "<input type=\"hidden\" name=\"st\" value=\"10\" ></form>"
						+ "<form action=LoginServlet><input type=\"submit\" name=\"remove"
						+ i
						+ "\" value=\"Remove\" />"
						+ "<input type=\"hidden\" name=\"CatIndex\" value=\""
						+ i
						+ "\" >"
						+ "<input type=\"hidden\" name=\"st\" value=\"6\" ></form>"
						+ "</th>" + "</form></tr>");
			}
		%>
	</form>




</body>
</html>
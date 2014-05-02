<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ExamplePackage.UserBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>User Logged Successfully</title>
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

	<form action=LoginServlet>
		<input type="submit" value="Goto Cart"><br> <input
			type="hidden" name="st" value="9">
	</form>
	<center>
		<form action="LoginServlet">
			<%
				String strCat = currentUser.getRole();
				System.out.println(currentUser.getRole());
				if (strCat.equals("owner")) {
			%>Add/Delete a Category:<input type="submit" value="Category"><br>
			<%
				} else {
			%>
			<input type="hidden">
			<%
				}
			%>
			<input type="hidden" name="st" value="4">
		</form>
		<form action="LoginServlet">
			<%
				String strProd = currentUser.getRole();
				System.out.println(currentUser.getRole());
				if (strProd.equals("owner")) {
			%>Add/Delete a Product:<input type="submit" value="Product"><br>
			<%
				} else {
			%>
			<input type="hidden">
			<%
				}
			%>
			<input type="hidden" name="st" value="2">
		</form>

		<h1>Products Browsing Page</h1>

		<form action=LoginServlet>
			<%
				String[] strName = currentUser.getCatNameArrList().clone();
			%>
			<%
				String[] strID = currentUser.getCatIDArrList().clone();
			%>
			Select a Category: <Select name="catListForProd" size="1">

				<%
					int i = 0;
					for (i = 0; i < strName.length; i++) {
						out.print("<option value=\"" + strID[i] + "\">" + strName[i]
								+ "</option>");
					}
				%>
			</Select> <input type="submit" value="Submit"> <input type="hidden"
				name="st" value="8">
		</form>

		<form action=LoginServlet>
			Search By Product And Category:<Select name="catListForProdWithText" size="1"><option
					value="All">All</option>
				<%
					for (i = 0; i < strName.length; i++) {
						out.print("<option value=\"" + strID[i] + "\">" + strName[i]
								+ "</option>");
					}
				%>
			</Select><input type="text" name="prodname" /> <input type="submit"
				value="Submit"> <input type="hidden" name="st" value="7">
		</form>
		Product List:

	</center>
</body>

</html>

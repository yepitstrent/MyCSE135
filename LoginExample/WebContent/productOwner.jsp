<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ExamplePackage.UserBean"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="myBean" scope="session" class="ExamplePackage.UserBean" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Page</title>
</head>
<body>
	<%
		System.out.println("TOP OF PROD OWNER");
	%>
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

	<h1>Add a product to the page</h1>

	<form action=LoginServlet>
		<%
			String[] strName = currentUser.getCatNameArrList().clone();
		%>
		<%
			String[] strID = currentUser.getCatIDArrList().clone();
		%>
		Select a Category: <Select name="catList" size="1" id="catogoryList">
			<%
				int i = 0;
				for (i = 0; i < strName.length; i++) {
					out.print("<option value=\"" + strID[i] + "\">" + strName[i]
							+ "</option>");
				}
			%>
		</Select><br> Enter your Product Name: <input type="text" name="prodname" /><br>
		Enter SKU: <input type="text" name="prodsku" /><br> Enter Price:
		$ <input type="text" name="prodprice" /><br> Description: <input
			type="text" name="proddesc" /><br> <input type="submit"
			value="Submit"> <input type="hidden" name="st" value="3">
	</form>

	<form action=LoginServlet>
		<%
			String[] prodName = currentUser.getProdNameArrList().clone();
			String[] prodSKU = currentUser.getProdSKUArrList().clone();
			String[] prodPrice = currentUser.getProdPriceArrList().clone();
		%>
		<%
			String[] strDesc = currentUser.getCatDescArray().clone();
		%>


		<%
			;
			for (i = 0; i < prodName.length; i++) {
				out.print(" <tr><form><th><input value=\" "
						+ prodName[i]
						+ " \" name=\"newProdname"
						+ i
						+ "\" size=\"20\"/></th><th><input value=\""
						+ prodSKU[i]
						+ "\" name=\"newProdSKU"
						+ i
						+ "\" size=\"10\"/></th><th><input value=\""
								+ prodPrice[i]
										+ "\" name=\"newProdPrice"
										+ i
										+ "\" size=\"10\"/></th><th>"
						+ "<form action=LoginServlet><input type=\"submit\" name=\"updateProd"
						+ i
						+ "\" value=\"Update\" />"
						+ "<input type=\"hidden\" name=\"prodIndex\" value=\""
						+ i
						+ "\" >"
						+ "<input type=\"hidden\" name=\"st\" value=\"13\" ></form>"
						+ "<form action=LoginServlet><input type=\"submit\" name=\"removeProd"
						+ i
						+ "\" value=\"Remove\" />"
						+ "<input type=\"hidden\" name=\"ProdIndex\" value=\""
						+ i
						+ "\" >"
						+ "<input type=\"hidden\" name=\"st\" value=\"14\" ></form>"
						+ "</th>" + "</form></tr>");
			}
		%>
	</form>

</body>
</html>
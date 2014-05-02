<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ExamplePackage.UserBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
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
	<h1>Items in your cart:</h1>

	<%
		//get the prodNameCart
		String[] prodNamCart = currentUser.getCartPric().clone();
		String[] prodPriCart = currentUser.getCartProd().clone();
		//currentUser.
		System.out.println("GOT THE ARRAYS" + prodNamCart.length);
		String[] nameBought = prodNamCart.clone();
		System.out.println("HERERERERER??????");
		currentUser.setConfirmation(nameBought);
	%>

	Product List:
	<%
		int i = 0;
		for (i = 0; i < prodNamCart.length; i++) {
			out.print(" <tr><form><th><input value=\" " + prodNamCart[i]
					+ " \" name=\"name" + i
					+ "\" size=\"10\"/ readonly></th><th><input value=\""
					+ prodPriCart[i] + "\" name=\"pri" + i
					+ "\" size=\"10\"/ readonly></th><th>"
					+ "</th></form></tr>");
		}
	%>

	Total (price of items in cart):
	<%
		out.print(currentUser.getCartTotal());
	%>
	<form action=LoginServlet>
		Enter Credit Card Info: <input type="text" name="creditCard" /> <input
			type="submit" value="Purchase"> <input type="hidden"
			name="st" value="12">
	</form>
</body>
</html>
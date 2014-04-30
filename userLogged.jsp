<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" import="ExamplePackage.UserBean" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
  <title> User Logged Successfully </title>
</head>

<body>
 
  <% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
  Welcome <%= currentUser.getUsername() %> 
<center>  
  <form action="LoginServlet">
    Add a Category to the Page:
    <input type="submit" value="Category"><br>
    <input type="hidden" name="st" value="4" >
  </form>
  <form action="LoginServlet">
    Add a Product to the Page:
    <input type="submit" value="Product"><br>
    <input type="hidden" name="st" value="2" >
  </form>
</center> 
</body>

</html>

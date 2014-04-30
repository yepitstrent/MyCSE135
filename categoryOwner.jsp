<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" import="ExamplePackage.UserBean" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
  Welcome <%= currentUser.getUsername() %>
  
  <h1>Add a new category to the page</h1>
  
  <form action=LoginServlet>
    Enter a New Category:
    <input type="text" name="catname"/><br>  
    Description:
    <input type="text" name="catdesc"/><br>  
  <input type="submit" value="submit">
  <input type="hidden" name="st" value="5" >
  </form>

</body>
</html>
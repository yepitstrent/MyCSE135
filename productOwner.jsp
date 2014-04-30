<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" import="ExamplePackage.UserBean" %> 
<%@ page import="java.util.*" %>  
<jsp:useBean id="myBean" scope="session" class="ExamplePackage.UserBean"/> 

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Page</title>
</head>
<body>
  <% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
  Welcome <%= currentUser.getUsername() %>
  
  <h1>Add a product to the page</h1>
  
  <form action=LoginServlet>
    <%String[] strName = currentUser.getCatNameArrList().clone(); %>
    <%String[] strID = currentUser.getCatIDArrList().clone(); %> 
    
    <Select name="catList" size="1" id="catogoryList">
      <%
     int i=0;
     for(i=0;i<strName.length;i++)
     {
      out.print("<option value=\"" + strID[i] + "\">"+ strName[i] +"</option>");
     }
    %>
    </Select><br>
    Select a Category:
    <input type="text" name="catname"/><br> 
    Enter your Product Name: 
    <input type="text" name="prodname"/><br> 
    Enter SKU:
    <input type="text" name="prodsku"/><br> 
    Enter Price: $
    <input type="text" name="prodprice"/><br>
    Description:
    <input type="text" name="proddesc"/><br>  
  <input type="submit" value="submit">
  <input type="hidden" name="st" value="3" >
  </form>
</body>
</html>
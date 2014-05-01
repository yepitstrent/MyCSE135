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
  <%System.out.println("TOP OF CAT OWNER"); %>
  <form action=LoginServlet>
    <input type="submit" value="Logout"><br>
    <input type="hidden" name="st" value="default" >
  </form>

  <form action=userLogged.jsp>
    <input type="submit" value="Cancel">
  </form>
  
  <h1>Add a new category</h1>
  
  <form action=LoginServlet>
    Enter a New Category:
    <input type="text" name="catname"/><br>
    Description:
    <input type="text" name="catdesc"/><br>
  <input type="submit" value="Submit">
  <input type="hidden" name="st" value="5" >
  </form>
  

  <h1>Delete a non-empty category</h1>
  
  <form action=LoginServlet>
    <%String[] strName = currentUser.getCatNameArrList().clone(); %>
    <%String[] strID = currentUser.getCatIDArrList().clone(); %>


    <% int i=0;
     for(i=0;i<strName.length;i++)
     {
      out.print(" <tr><form><th><input value=\" "
                + strName[i]
                + " \" name=\"name"
                + i
                + "\" size=\"10\"/></th><th><input value=\""
                + strName[i]
                +"\" name=\"desc"
                + i
                +"\" size=\"10\"/></th><th><input type=\"submit\" name=\"addcat\" value=\"Add\" />"
                +"<input type=\"submit\" name=\"remove\" value=\"Remove\" /></th></form></tr>");
     }
    %>

  <input type="submit" value="Submit">
  <input type="hidden" name="st" value="3" >
  </form>


<h1>Update an Existing Category</h1>
  
  <form action=LoginServlet>
    <%String[] strName2 = currentUser.getCatNameArrList().clone(); %>
    <%String[] strID2 = currentUser.getCatIDArrList().clone(); %>
    Select a Category:
    <Select name="catList" size="1" id="catogoryList">
    <%
     int j=0;
     for(j=0;j<strName.length;j++)
     {
      out.print("<option value=\"" + strID2[j] + "\">"+ strName2[j] +"</option>");
     }
    %>
    </Select><br>
    Description:
    <input type="text" name="proddesc"/><br>
  <input type="submit" value="Submit">
  <input type="hidden" name="st" value="3" >
  </form>









</body>
</html>
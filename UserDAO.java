package ExamplePackage;

import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO 
{
  static Connection currentCon = null;
  static ResultSet rs = null;
  
  public static UserBean signup(UserBean bean)
  {
	//preparing some objects for connection 
	    Statement stmt = null; 
	    
	    String username = bean.getUsername(); 
	    String role = bean.getRole();
	    String state = bean.getState();
	    int age = bean.getAge();
	    
	    String searchQuery = "INSERT INTO THE_USER ( NAME, AGE, ROLE, STATE ) VALUES ('" 
	                         + username 
	    		             + "' ,'" + age 
	    		             + "', '" + role 
	    		             + "', '" + state 
	    		             + "' )";
	    
	    // "System.out.println" prints in the console; Normally used to trace the process 
	    System.out.println("Signup UserDAO");
	    System.out.println("Your user name is: " + username); 
	    System.out.println("Your age is: " + age);
	    System.out.println("Your role is: " + role);
	    System.out.println("Your state is: " + state);
	    
	    System.out.println("Query: "+searchQuery); 
	    
	    try 
	    { //connect to DB 
	      currentCon = ConnectionManager.getConnection(); 
	      stmt=currentCon.createStatement(); 
	      rs = stmt.executeQuery(searchQuery);
	      boolean more = rs.next(); // if user does not exist set the isValid variable to false 
	    
	      if (!more) 
	      { 
	        System.out.println("Sorry, you are not a registered user! Please sign up first"); 
	        bean.setValid(false); 
	      } //if user exists set the isValid variable to true 
	      else if (more) 
	      { 
	        System.out.println("Successful Signup Insert.");
	        bean.setValid(true); 
	      }
	    }
	    catch (Exception ex) 
	    { 
	      System.out.println("Signup failed: An Exception has occurred! " + ex);
	    } //some exception handling 
	    finally 
	    {
	      if (rs != null)
	      {
	        try
	        {
	          rs.close(); 
	        }
	        catch (Exception e) 
	        {}
	        rs = null; 
	      }
	      if (stmt != null) 
	      {
	        try
	        { 
	          stmt.close();
	        }
	        catch (Exception e) 
	        {}
	        stmt = null; 
	      }
	      if (currentCon != null)
	      {
	        try
	        { 
	          currentCon.close();
	        }
	        catch (Exception e) 
	        {}
	        currentCon = null; 
	      }
	    }
	    return bean;
  }
  
  public static UserBean addProduct(UserBean bean)
  {
	  //insert product into table...
	  return bean;
  }
  
  public static UserBean getProduct(UserBean bean)
  {
	  return bean;
  }
  
  public static UserBean addCategory(UserBean bean)
  {
	  return bean;
  }
  
  public static UserBean getCategory(UserBean bean)
  {
	  return bean;
  }
  
  public static UserBean login(UserBean bean) 
  { 
    //preparing some objects for connection 
    Statement stmt = null; 
    String username = bean.getUsername(); 
    String password = bean.getPassword(); 
    String searchQuery = "select * from users where username='" + username + "' AND password='" + password + "'";
    // "System.out.println" prints in the console; Normally used to trace the process 
    System.out.println("Your user name is JAVA " + username); 
    System.out.println("Your password is JAVA " + password); 
    System.out.println("Query: "+searchQuery); 
    
    try 
    { //connect to DB 
      currentCon = ConnectionManager.getConnection(); 
      stmt=currentCon.createStatement(); 
      rs = stmt.executeQuery(searchQuery);
      boolean more = rs.next(); // if user does not exist set the isValid variable to false 
    
      if (!more) 
      { 
        System.out.println("Sorry, you are not a registered user! Please sign up first"); 
        bean.setValid(false); 
      } //if user exists set the isValid variable to true 
      else if (more) 
      {
        String firstName = rs.getString("FirstName"); 
        String lastName = rs.getString("LastName"); 
        System.out.println("Welcome " + firstName); 
        bean.setFirstName(firstName); 
        bean.setLastName(lastName); 
        bean.setValid(true); 
      }
    }
    catch (Exception ex) 
    { 
      System.out.println("Log In failed: An Exception has occurred! " + ex);
    } //some exception handling 
    finally 
    {
      if (rs != null)
      {
        try
        {
          rs.close(); 
        }
        catch (Exception e) 
        {}
        rs = null; 
      }
      if (stmt != null) 
      {
        try
        { 
          stmt.close();
        }
        catch (Exception e) 
        {}
        stmt = null; 
      }
      if (currentCon != null)
      {
        try
        { 
          currentCon.close();
        }
        catch (Exception e) 
        {}
        currentCon = null; 
      }
    }
    return bean;
  }
}

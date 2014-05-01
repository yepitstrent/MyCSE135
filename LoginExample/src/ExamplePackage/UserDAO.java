package ExamplePackage;

import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO 
{
  static Connection currentCon = null;
  static ResultSet rs = null;
  //DELETE FROM CATEGORIES WHERE CAT_ID NOT IN (SELECT PROD_CAT_ID FROM PRODUCTS) AND CAT_ID = 1;

  public static UserBean setIDSignup(UserBean bean)
  {     
	    Statement stmt = null;
	    String currUserID;
	    //INSERT INTO THE_USER
	    String searchQuery = "SELECT * from THE_USER WHERE USER_NAME = " + bean.getUsername(); 
	    System.out.println("Query: "+searchQuery); 
	    
	    try 
	    { //connect to DB 
	      currentCon = ConnectionManager.getConnection(); 
	      stmt=currentCon.createStatement(); 
	      rs = stmt.executeQuery(searchQuery);
	      //boolean more; // = rs.next(); // if user does not exist set the isValid variable to false 
	    
	      boolean more = rs.next();
	      {
	        if (!more) 
	        { 
	          System.out.println("IN HERER Sorry, you are not a registered user! Please sign up first"); 
	          bean.setValid(false); 
	        } //if user exists set the isValid variable to true 
	        else if (more) 
	        {
	        	currUserID = rs.getString("USER_ID");
	        	bean.setUserID(Integer.parseInt(currUserID));
	          //flag = true;
	        	//System.out.println(rs.getString( "CAT_NAME" ));
	    	  //catNameArrList.add(rs.getString( "CAT_NAME" ) );
	    	  //catDescArrList.add(rs.getString( "CAT_DESCR" ) );
	    	  //catIDArrList.add(rs.getString("CAT_ID"));
	   
	          bean.setValid(true); 
	        }
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
  
  public static UserBean signup(UserBean bean)
  {
	    
	//preparing some objects for connection 
	    Statement stmt = null; 
	    
	    String username = bean.getUsername(); 
	    String role = bean.getRole();
	    String state = bean.getState();
	    int age = bean.getAge();
	    
	    /*INSERT INTO THE_USER (USER_NAME, USER_ROLE, USER_AGE, USER_STATE) 
          SELECT * FROM (SELECT 'Trent', 'Owner', 37, 'CA') AS tmp
          WHERE NOT EXISTS (
          SELECT USER_NAME FROM THE_USER WHERE USER_NAME = 'Trent'
          ) LIMIT 1;*/
	    //INSERT INTO THE_USER (USER_NAME, USER_ROLE, USER_AGE, USER_STATE) VALUES ( 'Trent', 'Owner', 37, 'CA' );
	    
	    String searchQuery = "INSERT INTO THE_USER (USER_NAME, USER_ROLE, USER_AGE, USER_STATE)" 
	                         + "SELECT * FROM (SELECT '" 
	    		             + username
	                         + "', '" + role
	                         + "', " + age
	                         + ", '" + state
	                         + "' ) AS tmp "
	                         + "WHERE NOT EXISTS (SELECT USER_NAME FROM THE_USER WHERE USER_NAME = '"
	                         + username + "' ) LIMIT 1";
	    
	    /*String searchQuery = "INSERT INTO THE_USER (USER_NAME, USER_ROLE, USER_AGE, USER_STATE) VALUES ( '" 
	                         + username 
	    		             + "' ,'" + role
	    		             + "', '" + age 
	    		             + "', '" + state 
	    		             + "' )";*/
	    
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
	      stmt.executeUpdate(searchQuery);
	      bean.setValid(true);
	      
	      
	      //boolean more = rs.next(); // if user does not exist set the isValid variable to false 
	      //System.out.println(rs);
	      /*if (!more) 
	      { 
	        System.out.println("Sorry, you are not a registered user! Please sign up first"); 
	        bean.setValid(false); 
	      }*/ //if user exists set the isValid variable to true 
	      /*else if (more) 
	      { 
	        System.out.println("Successful Signup Insert.");
	        bean.setValid(true); 
	      }*/
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
  
  public static UserBean getAllCategories(UserBean bean)
  {
	    boolean flag = false;
	    Statement stmt = null; 
	    ArrayList<String> catNameArrList = new ArrayList<String>();
	    ArrayList<String> catDescArrList = new ArrayList<String>();//need setters and getters
	    ArrayList<String> catIDArrList = new ArrayList<String>();
	    
	    String searchQuery = "SELECT * from CATEGORIES"; 
	    System.out.println("Query: "+searchQuery); 
	    
	    try 
	    { //connect to DB 
	      currentCon = ConnectionManager.getConnection(); 
	      stmt=currentCon.createStatement(); 
	      rs = stmt.executeQuery(searchQuery);
	      boolean more; // = rs.next(); // if user does not exist set the isValid variable to false 
	    
	      while( more = rs.next() )
	      {
	        if (!more) 
	        { 
	          System.out.println("IN HERER Sorry, you are not a registered user! Please sign up first"); 
	          bean.setValid(false); 
	        } //if user exists set the isValid variable to true 
	        else if (more) 
	        {
	          flag = true;
	        	//System.out.println(rs.getString( "CAT_NAME" ));
	    	  catNameArrList.add(rs.getString( "CAT_NAME" ) );
	    	  catDescArrList.add(rs.getString( "CAT_DESCR" ) );
	    	  catIDArrList.add(rs.getString("CAT_ID"));
	   
	          bean.setValid(true); 
	        }
	      }
	      if(flag)
	      {
	    	  System.out.println("Setting cat arr list to bean");
	          bean.setCatNameArrList(catNameArrList);
	          bean.setCatIDArrList(catIDArrList);
	      }
	      else
	      {
	    	  bean.setCatNameArrList(null);
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
  
  public static UserBean categoryOwner(UserBean bean)
  {
      System.out.println("In DAO catOwner");
	  
	  Statement stmt = null; 
	  String cat = bean.getCatName();  
	  String desc = bean.getCatDesc();
	  /*INSERT INTO CATEGORIES ( CAT_NAME, CAT_DESCR ) 
        SELECT * FROM (SELECT  'Food', 'Different Cooking Supplies' ) AS tmp
        WHERE NOT EXISTS (
        SELECT CAT_NAME FROM CATEGORIES WHERE CAT_NAME = 'Food' 
        ) LIMIT 1;*/
	  String searchQuery = "INSERT INTO CATEGORIES ( CAT_NAME, CAT_DESCR )"
			               + " SELECT * FROM (SELECT  '" + cat + "', '" + desc + "' ) AS tmp "
			               + " WHERE NOT EXISTS ( "
			               + " SELECT CAT_NAME FROM CATEGORIES WHERE CAT_NAME = '" + cat + "' ) LIMIT 1";
	  
	  //String searchQuery2 = "SELECT * FROM CATEGORIES";
	  // "System.out.println" prints in the console; Normally used to trace the process  
	  System.out.println("Query: "+searchQuery); 
	    
	  try 
	  { //connect to DB 
	    currentCon = ConnectionManager.getConnection(); 
	    stmt=currentCon.createStatement(); 
	    stmt.executeUpdate(searchQuery);
	    //boolean more = rs.next(); // if user does not exist set the isValid variable to false 
	    
        bean.setValid(true); 

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
  
  public static UserBean productOwner(UserBean bean)
  {
	  System.out.println("In DAO prodOwner");
	  
	  Statement stmt = null; 
	  String product = bean.getProdName();  
	  String sku = bean.getProdSKU();
	  double price = Double.parseDouble( bean.getProdPrice());
	  String desc = bean.getProdDesc();
	  int catID = Integer.parseInt(bean.getCatID());
	  int ownerID = bean.getUserID();
	  System.out.println(product + "', '" + sku + "', " + price 
              + ", '" + desc + "', " + catID + ", " + ownerID);
	  /*INSERT INTO PRODUCTS ( PROD_NAME, PROD_SKU, PROD_PRICE, PROD_DESCR, PROD_CAT_ID, PROD_OWNER_ID )
        SELECT * FROM (SELECT 'Blender', 'ABC123', 45.99, 'Hobart Blender', 1, 1 ) AS tmp
        WHERE NOT EXISTS (
        SELECT PROD_SKU FROM PRODUCTS WHERE PROD_SKU = 'ABC123'
        ) LIMIT 1;*/
	  String searchQuery = "INSERT INTO PRODUCTS ( PROD_NAME, PROD_SKU, PROD_PRICE, PROD_DESCR, PROD_CAT_ID, PROD_OWNER_ID )"
			               + " SELECT * FROM (SELECT '" + product + "', '" + sku + "', " + price 
			               + ", '" + desc + "', " + catID + ", " + ownerID + " ) AS tmp "
			               + "WHERE NOT EXISTS ( "
			               + " SELECT PROD_SKU FROM PRODUCTS WHERE PROD_SKU = '" + sku + "' ) LIMIT 1";
	  
	  // "System.out.println" prints in the console; Normally used to trace the process  
	  System.out.println("Query: "+searchQuery); 
	    
	  try 
	  { //connect to DB 
	    currentCon = ConnectionManager.getConnection(); 
	    stmt=currentCon.createStatement(); 
	    stmt.executeUpdate(searchQuery);
	    //boolean more = rs.next(); // if user does not exist set the isValid variable to false 
	    
        bean.setValid(true); 

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
  
  public static UserBean productBrowsing(UserBean bean)
  {
	  return bean;
  }
  
  public static UserBean login(UserBean bean) 
  { 
    //preparing some objects for connection 
    Statement stmt = null; 
    String username = bean.getUsername(); 
    //String password = bean.getPassword(); 
    String searchQuery = "select * from THE_USER where USER_NAME='" + username + "'";
    // "System.out.println" prints in the console; Normally used to trace the process 
    System.out.println("Your user name is JAVA " + username); 
    //System.out.println("Your password is JAVA " + password); 
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
        String userName = rs.getString("USER_NAME"); 
        String role = rs.getString("USER_ROLE"); 
        String userID = rs.getString("USER_ID");
        System.out.println("Welcome " + userName); 
        bean.setUserName(username); 
        bean.setUserID(Integer.parseInt(userID));
        bean.setRole(role);
        System.out.println("valid: True");
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

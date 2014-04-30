package ExamplePackage;

import java.util.ArrayList;

public class UserBean 
{ 
  private String username; 
  private String password; 
  private String firstName;
  private String lastName;
  
  private int age;
  private int userID;
  private String role;
  private String state;
  private String[] catStrArr;
  
  private String catID;
  private String prodName;
  private String prodSKU;
  private String prodPrice;
  private String prodDesc;
  
  private String catName;
  private String catDesc;
  
  private String[] catNameList;// = new ArrayList<String>();
  private String[] catIDList;
  
  public boolean valid; 
  
  public String getCatNameByIndex(int i)
  {
	  return catNameList[i];
  }
  
  public String getCatIDByIndex(int i)
  {
	  return catIDList[i];
  }
  
  public void setCatIDArrList(ArrayList<String> catIDArrList)
  {
	  /*for(String object: catNameArrList){
		  System.out.println("#@#@#@#" + object);
		  }*/
	  catIDList = catIDArrList.toArray(new String[catIDArrList.size()]);
  }
  
  public String[] getCatIDArrList()
  {
	  //myArrayList.toArray(new String[myArrayList.size()])
	  return catIDList;
  }
  
  public void setCatNameArrList(ArrayList<String> catNameArrList)
  {
	  /*for(String object: catNameArrList){
		  System.out.println("#@#@#@#" + object);
		  }*/
	  catNameList = catNameArrList.toArray(new String[catNameArrList.size()]);
  }
  
  public String[] getCatNameArrList()
  {
	  //return catNameList;
	  return catNameList;
  }
  
  public void setCatName(String newCatName)
  {
	  
	  catName = newCatName;
  }
  
  public String getCatName()
  {
	  return catName;
  }
  
  public void setCatDesc(String newCatDesc)
  {
	  catDesc = newCatDesc;
  }
  
  public String getCatDesc()
  {
	  return catDesc;
  }
  
  public void setCatID(String currCatID)
  {
	  catID = currCatID;
  }
  
  public String getCatID()
  {
	  return catID;
  }
  
  public void setProdName(String newProdName)
  {
	  prodName = newProdName;
  }
  
  public String getProdName()
  {
	  return prodName;
  }
  
  public void setProdSKU(String newProdSKU)
  {
	  prodSKU = newProdSKU;
  }
  
  public String getProdSKU()
  {
	  return prodSKU;
  }
  
  public void setProdPrice(String newProdPrice)
  {
	  prodPrice = newProdPrice;
  }
  
  public String getProdPrice()
  {
	  return prodPrice;
  }
  
  public void setProdDesc(String newProdDesc)
  {
	  prodDesc = newProdDesc;
  }
  
  public String getProdDesc()
  {
	  return prodDesc;
  }
  
  public void setCatArr(String[] arr)
  {
	  for(int i = 0; i < arr.length; i++)
	  {
		  catStrArr[i] = arr[i];
	  }
  }
  
  public String[] getCatArr()
  {
	  return catStrArr;
  }
  
  public void setAge(int the_age)
  {
	  age = the_age;
  }
  
  public int getAge()
  {
	  return age;
  }
  
  public void setRole(String the_role)
  {
	  role = the_role;
  }
  
  public String getRole()
  {
	  return role;
  }
  
  public void setState(String the_state)
  {
	  state = the_state;
  }
  
  public String getState()
  {
	  return state;
  }
  
  public String getFirstName() 
  { 
    return firstName; 
  } 
  
  public void setFirstName(String newFirstName) 
  { 
    firstName = newFirstName; 
  } 
  
  public String getLastName() 
  { 
    return lastName; 
  } 
  
  public void setLastName(String newLastName) 
  { 
    lastName = newLastName; 
  } 
  
  public String getPassword() 
  { 
    return password; 
  } 
  
  public void setPassword(String newPassword) 
  { 
    password = newPassword; 
  } 
  
  public String getUsername() 
  { 
    return username; 
  }
  
  public void setUserName(String newUsername) 
  { 
    username = newUsername; 
  }
  
  public void setUserID(int newUserID)
  {
	  userID = newUserID;
  }
  
  public int getUserID()
  {
	 return userID;
  }
  
  public boolean isValid() 
  {
    return valid;
  }
  
  public void setValid(boolean newValid) 
  {
    valid = newValid; 
  }
}
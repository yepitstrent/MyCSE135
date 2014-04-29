package ExamplePackage;

public class UserBean 
{ 
  private String username; 
  private String password; 
  private String firstName;
  private String lastName;
  
  private int age;
  private String role;
  private String state;
  
  
  public boolean valid; 
  
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
  
  public boolean isValid() 
  {
    return valid;
  }
  
  public void setValid(boolean newValid) 
  {
    valid = newValid; 
  }
}
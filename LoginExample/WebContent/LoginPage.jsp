<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Login Page</title>
</head> 

<body> 
<form action="LoginServlet"> 
  <h1>Log In With Your User Name</h1>
  Please enter your username: 
  <input type="text" name="un"/><br> 
  
  <input type="submit" value="submit">
  <input type="hidden" name="st" value="0" > 
</form><br>

<form action=LoginServlet>
 <h1> Sign up for all new users:</h1><br>
  Enter a new user name:
  <input type="text" name="newUN"/><br>
  Owner or Customer:
  <select name="Role">
	    <option value="owner">Owner</option>
		<option value="customer">Customer</option>
  </select><br>
  Age:<input type="text" name="Age"><br>
  <p>Select State:</p>
        <select name="state">
		<option value="AL">Alabama</option>
		<option value="AK">Alaska</option>
		<option value="AZ">Arizona</option>
		<option value="AR">Arkansas</option>
		<option value="CA">California</option>
		<option value="CO">Colorado</option>
		<option value="CT">Connecticut</option>
		<option value="DE">Delaware</option>
		<option value="DC">District of Columbia</option>
		<option value="FL">Florida</option>
		<option value="GA">Georgia</option>
		<option value="HI">Hawaii</option>
		<option value="ID">Idaho</option>
		<option value="IL">Illinois</option>
		<option value="IN">Indiana</option>
		<option value="IA">Iowa</option>
		<option value="KS">Kansas</option>
		<option value="KY">Kentucky</option>
		<option value="LA">Louisiana</option>
		<option value="ME">Maine</option>
		<option value="MD">Maryland</option>
		<option value="MA">Massachusetts</option>
		<option value="MI">Michigan</option>
		<option value="MN">Minnesota</option>
		<option value="MS">Mississippi</option>
		<option value="MO">Missouri</option>
		<option value="MT">Montana</option>
		<option value="NE">Nebraska</option>
		<option value="NV">Nevada</option>
		<option value="NH">New Hampshire</option>
		<option value="NJ">New Jersey</option>
		<option value="NM">New Mexico</option>
		<option value="NY">New York</option>
		<option value="NC">North Carolina</option>
		<option value="ND">North Dakota</option>
		<option value="OH">Ohio</option>
		<option value="OK">Oklahoma</option>
		<option value="OR">Oregon</option>
		<option value="PA">Pennsylvania</option>
		<option value="RI">Rhode Island</option>
		<option value="SC">South Carolina</option>
		<option value="SD">South Dakota</option>
		<option value="TN">Tennessee</option>
		<option value="TX">Texas</option>
		<option value="UT">Utah</option>
		<option value="VT">Vermont</option>
		<option value="VA">Virginia</option>
		<option value="WA">Washington</option>
		<option value="WV">West Virginia</option>
		<option value="WI">Wisconsin</option>
		<option value="WY">Wyoming</option>
        </select><br>
   
  <input type="submit" value="submit">
  <input type="hidden" name="st" value="1">
</form>
</body> 
</html> 
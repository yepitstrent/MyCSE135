package ExamplePackage;

import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UserBean deleteCatByID(UserBean bean) {

		Statement stmt = null;

		int index = bean.getCatIndex();
		String[] arr = bean.getCatIDArrList();
		String id = arr[index];

		String searchQuery = "DELETE FROM CATEGORIES WHERE CAT_ID = " + id
				+ " AND " + id + " NOT IN (SELECT PROD_CAT_ID FROM PRODUCTS)";

		System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Signup failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean getProdFromCat(UserBean bean) {

		// get string from bean
		String str = bean.getProdSearchCat();
		ArrayList<String> prodIDArrList = new ArrayList<String>();
		ArrayList<String> prodDescArrList = new ArrayList<String>();
		ArrayList<String> prodNameArrList = new ArrayList<String>();
		ArrayList<String> prodSKUArrList = new ArrayList<String>();
		ArrayList<String> prodPriceArrList = new ArrayList<String>();
		ArrayList<String> prodCatArrList = new ArrayList<String>();
		// do sql
		Statement stmt = null;
		String searchQuery = "SELECT * from PRODUCTS, CATEGORIES WHERE PROD_CAT_ID = CAT_ID"
				+ " AND CAT_ID = " + str;

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more; // = rs.next(); // if user does not exist set the
							// isValid variable to false
			boolean flag = false;

			while (more = rs.next()) {
				if (!more) {
					System.out
							.println("IN HERER Sorry, you are not a registered user! Please sign up first");
					bean.setValid(false);
				} // if user exists set the isValid variable to true
				else if (more) {
					flag = true;

					prodNameArrList.add(rs.getString("PROD_NAME"));

					prodDescArrList.add(rs.getString("PROD_DESCR"));

					prodIDArrList.add(rs.getString("PROD_ID"));

					prodCatArrList.add(rs.getString("PROD_CAT_ID"));

					prodPriceArrList.add(rs.getString("PROD_PRICE"));

					prodSKUArrList.add(rs.getString("PROD_SKU"));

					bean.setValid(true);
				}
			}
			if (flag) {
				// System.out.println("Cat Search Setting prod arr list to bean");
				bean.setProdNameArr(prodNameArrList
						.toArray(new String[prodNameArrList.size()]));
				bean.setProdIDArr(prodIDArrList
						.toArray(new String[prodIDArrList.size()]));
				bean.setProdDescArr(prodDescArrList
						.toArray(new String[prodDescArrList.size()]));

				bean.setprodSkuArr(prodSKUArrList
						.toArray(new String[prodSKUArrList.size()]));
				bean.setprodCatArr(prodCatArrList
						.toArray(new String[prodCatArrList.size()]));
				bean.setprodPriArr(prodPriceArrList
						.toArray(new String[prodPriceArrList.size()]));
			} else {
				// System.out.println("Name is null");
				prodNameArrList.add("No Results Found In This Search");
				prodNameArrList.add("No Results Found In This Search");
				prodNameArrList.add("No Results Found In This Search");
				prodCatArrList.add("No Results Found In This Search");
				prodPriceArrList.add("No Results Found In This Search");
				prodSKUArrList.add("No Results Found In This Search");
				bean.setProdNameArr(prodNameArrList
						.toArray(new String[prodNameArrList.size()]));
				bean.setProdIDArr(prodIDArrList
						.toArray(new String[prodIDArrList.size()]));
				bean.setProdDescArr(prodDescArrList
						.toArray(new String[prodDescArrList.size()]));
				bean.setprodSkuArr(prodSKUArrList
						.toArray(new String[prodSKUArrList.size()]));
				bean.setprodCatArr(prodCatArrList
						.toArray(new String[prodCatArrList.size()]));
				bean.setprodPriArr(prodPriceArrList
						.toArray(new String[prodPriceArrList.size()]));

			}
		} catch (Exception ex) {
			// System.out.println("Prod Search BY SRT");
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean getProdFromString(UserBean bean) {
		// System.out.println("IN DAO GET PROD FM STRING");
		// get string from bean
		String str = bean.getProdSearchStr();

		ArrayList<String> prodIDArrList = new ArrayList<String>();
		ArrayList<String> prodDescArrList = new ArrayList<String>();
		ArrayList<String> prodNameArrList = new ArrayList<String>();
		ArrayList<String> prodSKUArrList = new ArrayList<String>();
		ArrayList<String> prodPriceArrList = new ArrayList<String>();
		ArrayList<String> prodCatArrList = new ArrayList<String>();

		// do sql
		Statement stmt = null;
		String searchQuery = new String();

		if (bean.getProdCatSearchStr().equals("All")) {
			searchQuery = "SELECT * from PRODUCTS WHERE LOWER(PROD_NAME) LIKE LOWER('%"
					+ str
					+ "%') OR LOWER(PROD_DESCR) LIKE LOWER('%"
					+ str
					+ "%')";
		} else {
			searchQuery = "SELECT * from PRODUCTS WHERE (LOWER(PROD_NAME)"
					+ " LIKE LOWER('%" + str
					+ "%') OR LOWER(PROD_DESCR) LIKE LOWER('%" + str
					+ "%') ) AND prod_cat_id = " + bean.getProdCatSearchStr();
		}

		System.out.println("Query: " + searchQuery);

		try {

			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more; // = rs.next(); // if user does not exist set the
							// isValid variable to false
			boolean flag = false;

			while (more = rs.next()) {
				if (!more) {

					System.out
							.println("IN HERER Sorry, you are not a registered user! Please sign up first");
					bean.setValid(false);
				} // if user exists set the isValid variable to true
				else if (more) {
					flag = true;

					System.out.println("parse prod arr");
					prodNameArrList.add(rs.getString("PROD_NAME"));

					prodDescArrList.add(rs.getString("PROD_DESCR"));

					prodIDArrList.add(rs.getString("PROD_ID"));

					prodCatArrList.add(rs.getString("PROD_CAT_ID"));

					prodPriceArrList.add(rs.getString("PROD_PRICE"));

					prodSKUArrList.add(rs.getString("PROD_SKU"));

					bean.setValid(true);
				}
			}
			if (flag) {
				// System.out.println("Setting prod arr list to bean");
				// out.write("");
				bean.setProdNameArr(prodNameArrList
						.toArray(new String[prodNameArrList.size()]));
				bean.setProdIDArr(prodIDArrList
						.toArray(new String[prodIDArrList.size()]));
				bean.setProdDescArr(prodDescArrList
						.toArray(new String[prodDescArrList.size()]));
				bean.setprodSkuArr(prodSKUArrList
						.toArray(new String[prodSKUArrList.size()]));
				bean.setprodCatArr(prodCatArrList
						.toArray(new String[prodCatArrList.size()]));
				bean.setprodPriArr(prodPriceArrList
						.toArray(new String[prodPriceArrList.size()]));

			} else {
				// System.out.println("Name is null in else str");

				prodNameArrList.add(" ");
				prodCatArrList.add(" ");
				prodPriceArrList.add(" ");
				prodSKUArrList.add(" ");
				bean.setProdNameArr(prodNameArrList
						.toArray(new String[prodNameArrList.size()]));
				bean.setProdIDArr(prodIDArrList
						.toArray(new String[prodIDArrList.size()]));
				bean.setProdDescArr(prodDescArrList
						.toArray(new String[prodDescArrList.size()]));
				bean.setprodSkuArr(prodSKUArrList
						.toArray(new String[prodSKUArrList.size()]));
				bean.setprodCatArr(prodCatArrList
						.toArray(new String[prodCatArrList.size()]));
				bean.setprodPriArr(prodPriceArrList
						.toArray(new String[prodPriceArrList.size()]));
				// System.out.println("Done setting prod arr");
			}
		} catch (Exception ex) {
			// System.out.println("Name is null in catch");
			prodNameArrList.add(" ");
			prodNameArrList.add(" ");
			prodNameArrList.add(" ");
			prodCatArrList.add(" ");
			prodPriceArrList.add(" ");
			prodSKUArrList.add(" ");
			bean.setProdNameArr(prodNameArrList
					.toArray(new String[prodNameArrList.size()]));
			bean.setProdIDArr(prodIDArrList.toArray(new String[prodIDArrList
					.size()]));
			bean.setProdDescArr(prodDescArrList
					.toArray(new String[prodDescArrList.size()]));
			bean.setprodSkuArr(prodSKUArrList.toArray(new String[prodSKUArrList
					.size()]));
			bean.setprodCatArr(prodCatArrList.toArray(new String[prodCatArrList
					.size()]));
			bean.setprodPriArr(prodPriceArrList
					.toArray(new String[prodPriceArrList.size()]));
			// System.out.println("Prod Search BY SRT");
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
		// set variables to arr
		// set arr to bean
		// return bean;
	}

	public static UserBean setIDSignup(UserBean bean) {
		Statement stmt = null;
		String currUserID;
		// INSERT INTO THE_USER
		String searchQuery = "SELECT * from THE_USER WHERE USER_NAME = "
				+ bean.getUsername();
		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			// boolean more; // = rs.next(); // if user does not exist set the
			// isValid variable to false

			boolean more = rs.next();
			{
				if (!more) {
					System.out
							.println("IN HERER Sorry, you are not a registered user! Please sign up first");
					bean.setValid(false);
				} // if user exists set the isValid variable to true
				else if (more) {
					currUserID = rs.getString("USER_ID");
					bean.setUserID(Integer.parseInt(currUserID));
					// flag = true;
					// System.out.println(rs.getString( "CAT_NAME" ));
					// catNameArrList.add(rs.getString( "CAT_NAME" ) );
					// catDescArrList.add(rs.getString( "CAT_DESCR" ) );
					// catIDArrList.add(rs.getString("CAT_ID"));

					bean.setValid(true);
				}
			}

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean signup(UserBean bean) {
		bean = getAllCategories(bean);

		// preparing some objects for connection
		Statement stmt = null;

		String username = bean.getUsername();
		String role = bean.getRole();
		String state = bean.getState();
		int age = bean.getAge();

		String searchQuery = "INSERT INTO THE_USER (USER_NAME, USER_ROLE, USER_AGE, USER_STATE)"
				+ "SELECT * FROM (SELECT '"
				+ username
				+ "', '"
				+ role
				+ "', "
				+ age
				+ ", '"
				+ state
				+ "' ) AS tmp "
				+ "WHERE NOT EXISTS (SELECT USER_NAME FROM THE_USER WHERE USER_NAME = '"
				+ username + "' ) LIMIT 1";

		/*
		 * String searchQuery =
		 * "INSERT INTO THE_USER (USER_NAME, USER_ROLE, USER_AGE, USER_STATE) VALUES ( '"
		 * + username + "' ,'" + role + "', '" + age + "', '" + state + "' )";
		 */

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		// System.out.println("Signup UserDAO");
		// System.out.println("Your user name is: " + username);
		// System.out.println("Your age is: " + age);
		// System.out.println("Your role is: " + role);
		// System.out.println("Your state is: " + state);

		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Signup failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean getAllProducts(UserBean bean) {
		boolean flag = false;
		Statement stmt = null;
		ArrayList<String> prodNameArrList = new ArrayList<String>();
		ArrayList<String> prodPriceArrList = new ArrayList<String>();// need
		ArrayList<String> prodSKUArrList = new ArrayList<String>();
		// setters
		// and
		// getters
		ArrayList<String> prodIDArrList = new ArrayList<String>();

		String searchQuery = "SELECT * from PRODUCTS ORDER BY PROD_ID ASC";
		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more; // = rs.next(); // if user does not exist set the
							// isValid variable to false

			while (more = rs.next()) {
				if (!more) {
					System.out
							.println("IN HERER Sorry, you are not a registered user! Please sign up first");
					bean.setValid(false);
				} // if user exists set the isValid variable to true
				else if (more) {
					flag = true;
					// System.out.println(rs.getString("PROD_ID"));
					prodSKUArrList.add(rs.getString("PROD_SKU"));
					prodNameArrList.add(rs.getString("PROD_NAME"));
					prodPriceArrList.add(rs.getString("PROD_PRICE"));
					prodIDArrList.add(rs.getString("PROD_ID"));

					bean.setValid(true);
				}
			}
			if (flag) {
				// System.out.println("Setting cat arr list to bean");
				bean.setProdSKUArrList(prodSKUArrList
						.toArray(new String[prodSKUArrList.size()]));
				bean.setProdNameArrList(prodNameArrList
						.toArray(new String[prodNameArrList.size()]));
				bean.setProdIDArrList(prodIDArrList
						.toArray(new String[prodIDArrList.size()]));
				bean.setProdPriceArray(prodPriceArrList
						.toArray(new String[prodPriceArrList.size()]));
			} else {
				prodNameArrList.add(" ");
				prodPriceArrList.add(" ");
				prodIDArrList.add(" ");
				prodSKUArrList.add(" ");
				bean.setProdNameArrList(prodNameArrList
						.toArray(new String[prodNameArrList.size()]));
				bean.setProdIDArrList(prodIDArrList
						.toArray(new String[prodIDArrList.size()]));
				bean.setProdPriceArray(prodPriceArrList
						.toArray(new String[prodPriceArrList.size()]));
				bean.setProdSKUArrList(prodSKUArrList
						.toArray(new String[prodSKUArrList.size()]));

			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean getAllCategories(UserBean bean) {
		boolean flag = false;
		Statement stmt = null;
		ArrayList<String> catNameArrList = new ArrayList<String>();
		ArrayList<String> catDescArrList = new ArrayList<String>();// need
																	// setters
																	// and
																	// getters
		ArrayList<String> catIDArrList = new ArrayList<String>();

		String searchQuery = "SELECT * from CATEGORIES ORDER BY CAT_ID ASC";
		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more; // = rs.next(); // if user does not exist set the
							// isValid variable to false

			while (more = rs.next()) {
				if (!more) {
					System.out
							.println("IN HERER Sorry, you are not a registered user! Please sign up first");
					bean.setValid(false);
				} // if user exists set the isValid variable to true
				else if (more) {
					flag = true;
					// System.out.println(rs.getString( "CAT_NAME" ));
					catNameArrList.add(rs.getString("CAT_NAME"));
					catDescArrList.add(rs.getString("CAT_DESCR"));
					catIDArrList.add(rs.getString("CAT_ID"));

					bean.setValid(true);
				}
			}
			if (flag) {
				// System.out.println("Setting cat arr list to bean");
				bean.setCatNameArrList(catNameArrList);
				bean.setCatIDArrList(catIDArrList);
				bean.setCatDescArray(catDescArrList);
			} else {
				catNameArrList.add(" ");
				catDescArrList.add(" ");
				catIDArrList.add(" ");
				bean.setCatNameArrList(catNameArrList);
				bean.setCatIDArrList(catIDArrList);
				bean.setCatDescArray(catDescArrList);

			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean categoryOwner(UserBean bean) {
		// System.out.println("In DAO catOwner");

		Statement stmt = null;
		String cat = bean.getCatName();
		String desc = bean.getCatDesc();

		String searchQuery = "INSERT INTO CATEGORIES ( CAT_NAME, CAT_DESCR )"
				+ " SELECT * FROM (SELECT  '" + cat + "', '" + desc
				+ "' ) AS tmp " + " WHERE NOT EXISTS ( "
				+ " SELECT CAT_NAME FROM CATEGORIES WHERE CAT_NAME = '" + cat
				+ "' ) LIMIT 1";

		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			// boolean more = rs.next(); // if user does not exist set the
			// isValid variable to false

			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean catRemove(UserBean bean) {
		// System.out.println("In DAO catRemove");

		Statement stmt = null;
		String cat = bean.getCatName();
		String desc = bean.getCatDesc();

		String searchQuery = "INSERT INTO CATEGORIES ( CAT_NAME, CAT_DESCR )"
				+ " SELECT * FROM (SELECT  '" + cat + "', '" + desc
				+ "' ) AS tmp " + " WHERE NOT EXISTS ( "
				+ " SELECT CAT_NAME FROM CATEGORIES WHERE CAT_NAME = '" + cat
				+ "' ) LIMIT 1";

		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			// boolean more = rs.next(); // if user does not exist set the
			// isValid variable to false

			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean productOwner(UserBean bean) {
		// System.out.println("In DAO prodOwner");

		Statement stmt = null;
		String product = bean.getProdName();
		String sku = bean.getProdSKU();
		double price = Double.parseDouble(bean.getProdPrice());
		String desc = bean.getProdDesc();
		int catID = Integer.parseInt(bean.getCatID());
		int ownerID = bean.getUserID();

		/*
		 * INSERT INTO PRODUCTS ( PROD_NAME, PROD_SKU, PROD_PRICE, PROD_DESCR,
		 * PROD_CAT_ID, PROD_OWNER_ID ) SELECT * FROM (SELECT 'Blender',
		 * 'ABC123', 45.99, 'Hobart Blender', 1, 1 ) AS tmp WHERE NOT EXISTS (
		 * SELECT PROD_SKU FROM PRODUCTS WHERE PROD_SKU = 'ABC123' ) LIMIT 1;
		 */
		String searchQuery = "INSERT INTO PRODUCTS ( PROD_NAME, PROD_SKU, PROD_PRICE, PROD_DESCR, PROD_CAT_ID, PROD_OWNER_ID )"
				+ " SELECT * FROM (SELECT '"
				+ product
				+ "', '"
				+ sku
				+ "', "
				+ price
				+ ", '"
				+ desc
				+ "', "
				+ catID
				+ ", "
				+ ownerID
				+ " ) AS tmp "
				+ "WHERE NOT EXISTS ( "
				+ " SELECT PROD_SKU FROM PRODUCTS WHERE PROD_SKU = '"
				+ sku
				+ "' ) LIMIT 1";

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			// boolean more = rs.next(); // if user does not exist set the
			// isValid variable to false

			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean productBrowsing(UserBean bean) {
		return bean;
	}

	public static UserBean login(UserBean bean) {
		// preparing some objects for connection
		Statement stmt = null;
		String username = bean.getUsername();
		// String password = bean.getPassword();
		String searchQuery = "select * from THE_USER where USER_NAME='"
				+ username + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		// System.out.println("Your user name is JAVA " + username);
		// System.out.println("Your password is JAVA " + password);
		// System.out.println("Query: " + searchQuery);
		bean = getAllCategories(bean);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next(); // if user does not exist set the isValid
										// variable to false

			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} // if user exists set the isValid variable to true
			else if (more) {
				String userName = rs.getString("USER_NAME");
				String role = rs.getString("USER_ROLE");
				String userID = rs.getString("USER_ID");

				bean.setUserName(username);
				bean.setUserID(Integer.parseInt(userID));
				bean.setRole(role);

				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean getCartTotal(UserBean bean) {

		Statement stmt = null;
		String sumQuery = "select sum(cart_prod_price) from cart WHERE cart_id = "
				+ bean.getUserID() + ";";

		String namQuery = "select prod_name, cart_prod_price from products, cart "
				+ "WHERE(prod_id = cart_prod_id AND cart_id = "
				+ bean.getUserID() + " );";

		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> pric = new ArrayList<String>();

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(namQuery);
			boolean more;

			boolean flag = false;
			while (more = rs.next()) {
				if (!more) {
					System.out
							.println("Sorry, you are not a registered user! Please sign up first");
					bean.setValid(false);
				} // if user exists set the isValid variable to true
				else if (more) {
					flag = true;

					name.add(rs.getString("PROD_NAME"));
					pric.add(rs.getString("CART_PROD_PRICE"));
					bean.setValid(true);
				}
			}
			if (flag) {
				// System.out.println("Setting cat arr list to bean");
				bean.setCartPric(name);
				bean.setCartProd(pric);
			} else {
				name.add(" ");
				pric.add(" ");
				bean.setCartPric(name);
				bean.setCartProd(pric);
			}
            //bean = UserDAO.getAllProducts(bean);
            //bean = UserDAO.getAllCategories(bean);
            
			rs = stmt.executeQuery(sumQuery);
			more = rs.next();

			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} // if user exists set the isValid variable to true
			else if (more) {

				bean.setCartTotal(Double.parseDouble(rs.getString("SUM")));
				bean = UserDAO.getAllProducts(bean);
				bean.setValid(true);
			}

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean addProductToCart(UserBean bean) {
		// System.out.println("In DAO add to cart");

		Statement stmt = null;
		String index = bean.getProdIndex();
		String[] idArr = bean.getProdIDArrList();
		String[] priceArr = bean.getProdPriceArrList();
		// System.out.println("Did I make it this far?" + index);
		String prodId = idArr[Integer.parseInt(index)];

		/*
		 * String searchQuery = "INSERT INTO CART " +
		 * "( CART_ID, CART_PROD_ID, CART_PROD_PRICE ) " + "VALUES(" +
		 * bean.getUserID() + ", " + prodId + ", " +
		 * priceArr[Integer.parseInt(index)] + " )";
		 */

		String searchQuery = "INSERT INTO CART "
				+ "( CART_ID, CART_PROD_ID, CART_PROD_PRICE ) "
				+ "SELECT * FROM (SELECT "
				+ bean.getUserID()
				+ ", "
				+ prodId
				+ ", "
				+ priceArr[Integer.parseInt(index)]
				+ " ) AS tmp "
				+ "WHERE NOT EXISTS (SELECT CART_PROD_ID FROM CART WHERE CART_PROD_ID = "
				+ prodId + " ) LIMIT 1";

		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			// boolean more = rs.next(); // if user does not exist set the
			// isValid variable to false

			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean checkOut(UserBean bean) {

		// preparing some objects for connection
		Statement stmt = null;
		String searchQuery = "DELETE from CART where CART_ID="
				+ bean.getUserID();

		/*
		 * DELETE FROM PRODUCTS WHERE PROD_ID IN (SELECT CART_PROD_ID FROM CART
		 * WHERE CART_ID = 3);
		 */
		String otherQuery = "DELETE FROM PRODUCTS WHERE PROD_ID IN "
				+ "(SELECT CART_PROD_ID FROM CART WHERE CART_ID = "
				+ bean.getUserID() + ")";

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			int i = stmt.executeUpdate(otherQuery);

			int j = stmt.executeUpdate(searchQuery);

			// boolean more = rs.next(); // if user does not exist set the
			// isValid
			// variable to false

			if (false) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} // if user exists set the isValid variable to true
			else if (true) {

				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean updateProdByID(UserBean bean) {
		Statement stmt = null;

		int index = Integer.parseInt(bean.getProdIndex());

		String[] arr = bean.getProdIDArrList();
		String id = arr[index];

		String strVar1 = bean.getUpdateProdName();
		String strVar2 = bean.getUpdateProdSKU();
		String strVar3 = bean.getUpdateProdPrice();

		String searchQuery = "UPDATE PRODUCTS SET PROD_NAME = '" + strVar1
				+ "', PROD_SKU = '" + strVar2 + "', PROD_PRICE = '" + strVar3
				+ "' WHERE PROD_ID = " + id;

		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			int i = stmt.executeUpdate(searchQuery);
			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Signup failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean updateCatByID(UserBean bean) {

		Statement stmt = null;

		int index = bean.getCatIndex();
		String[] arr = bean.getCatIDArrList();
		String id = arr[index];

		String strVar1 = bean.getUpdateCatName();
		String strVar2 = bean.getUpdateCatDesc();
		String searchQuery = "UPDATE CATEGORIES SET CAT_NAME = '" + strVar1
				+ "', CAT_DESCR = '" + strVar2 + "' WHERE CAT_ID = " + id;

		System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			int i = stmt.executeUpdate(searchQuery);
			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Signup failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

	public static UserBean deleteProdByID(UserBean bean) {
		// TODO Auto-generated method stub
		Statement stmt = null;

		int index = Integer.parseInt(bean.getProdIndex());
		String[] arr = bean.getProdIDArrList();
		String id = arr[index];

		String searchQuery = "DELETE FROM PRODUCTS WHERE PROD_ID = " + id;

		// System.out.println("Query: " + searchQuery);

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			bean.setValid(true);

		} catch (Exception ex) {
			System.out.println("Signup failed: An Exception has occurred! "
					+ ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		return bean;
	}

}
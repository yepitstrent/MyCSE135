package ExamplePackage;

import java.sql.*;
import java.util.*;

public class ConnectionManager {
	static Connection con;
	static String url;

	public static Connection getConnection() {
		try {
			// String url = "jdbc:odbc:" + "DataSource";
			// assuming "DataSource" is your DataSource name

			Class.forName("org.postgresql.Driver");
			System.out.println("AM I HERE?");
			try {
				// con = DriverManager.getConnection(url,"username","password");
				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/test", "t-dogg3030",
						"password");
				// assuming your SQL Server's username is "username"
				// and password is "password"
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("here");
			System.out.println(e);
		}
		return con;
	}
}

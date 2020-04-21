
package com.mindtree.movies.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.movies.exceptions.UtilityException;


public class JdbcConnection {
	static String  url="jdbc:mysql://localhost:3306/movies";
	static String uname="root";
	static String pass="Welcome123";
	
	public static Connection getConnection() throws UtilityException
	{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,uname,pass);
		}
		catch(SQLException e)
		{
			throw new UtilityException("Connection not established");
		} catch (ClassNotFoundException e) {
			
			throw new UtilityException("No such driver"); 		}
		
		return connection;
	}
	
	
	public static String closeConnection(Connection connection) throws UtilityException
	{
		String result="";
		try
		{
			connection.close();
			result = "Successfully closed the connection object.";
		}
		catch(SQLException e)
		{result = e.getLocalizedMessage();
			throw new UtilityException("Connection not established");
		
		}
		
		return result;
	}
}

package com.ust.framework.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ust.framework.util.ConfigReader;

public class DataBaseReader {

	
	public static Object[][] readDB() throws Exception{
		Object array[][]= new Object[2][2];
		int row= 0;
		
		// Step -1 Connect / Load a Driver
		//oracle.jdbc.driver.OracleDriver
		// sun.jdbc.odbc.JdbcOdbcDriver
		//Class.forName("com.mysql.jdbc.Driver");  // Driver Path
		Class.forName(ConfigReader.getDriver());
		//jdbc:oracle:thin:@localhost:1521:testing21
		// Step -2 Creating a Connection 
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing21",
		//		"root","root");
		Connection con = DriverManager.getConnection(ConfigReader.getDBURL(),
						ConfigReader.getDBUserid(),ConfigReader.getDBPassword());
		// Step -3 Doing the Query
		Statement stmt = con.createStatement();
		// Step - 4 Storing the Result and Traverse the Result
		ResultSet rs = stmt.executeQuery("select userid,password from usermst");
		// ResultSet store the Query Result 
		while(rs.next()){
			array[row][0] = rs.getString("userid");
			array[row][1]= rs.getString("password");
			row++;
			// Reterive the Records and Fill it in Array
		}
		
		// Step -5 Close the Resources
		rs.close();
		stmt.close();
		con.close();
		return array;
		
	}
	
}

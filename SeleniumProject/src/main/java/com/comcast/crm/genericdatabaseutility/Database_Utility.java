package com.comcast.crm.genericdatabaseutility;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class Database_Utility {
	
	Connection con;
    public void getconnection()
 {
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
        }
	catch(Exception e) {
                       }	
}

public void getDbconnection(String url,String username,String password) 
{
	Connection con;
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 con=DriverManager.getConnection(url, username, password);
} 
	catch(Exception e) {
                     }
}

     public void closeDbconnection()
 {
	try {
		con.close();
	}catch(Exception e) {
	}
}

	public ResultSet executeConSelectQuery(String query) {    ///get the data from table in db
		ResultSet result=null;
		try {
	 Statement stat=con.createStatement();
	  result=stat.executeQuery(query);
		}catch(Exception e) 
		{
			
		}
	 return result;
		
	}
	public int executeNonselectQuery(String query)             //insert the data in to the table
	{
		int result =0;
		try {
			Statement stat=con.createStatement();
            result  =stat.executeUpdate(query);
		}
		catch(Exception e) 
		{
		}
		return result;
      }
	
}



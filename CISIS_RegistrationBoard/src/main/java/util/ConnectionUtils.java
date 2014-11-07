package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
	
	private static String USER_NAME_DB="root";
	private static String USER_PASSWORD_DB="";
	private static String DB_NAME="cisis_squash_pei_db";
	private static String HOST_NAME="127.0.0.1";
	
	static{
		  try {
		   	  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  } catch (Exception ex) {
		  }
	}
	
	public static Connection getConnection() throws Exception
	{
	 	  return getDBConnection();
	}
	
	 public static Connection getDBConnection() throws Exception 
	  {
	      Connection conn = null;
	      String URL="jdbc:mysql://"+HOST_NAME+":3306/"+DB_NAME;
              System.out.println("URL="+URL);
              System.out.println("User="+USER_NAME_DB);
              System.out.println("Pw="+USER_PASSWORD_DB);
		  try{
			  conn = DriverManager.getConnection(URL,USER_NAME_DB, USER_PASSWORD_DB);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  return conn;
	  }
}

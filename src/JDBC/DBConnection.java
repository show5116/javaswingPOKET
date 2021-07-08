package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	 public static Connection dbConn;
	    
     public static Connection getConnection()
     {
         Connection conn = null;
         try {
             String user = "YYJ95"; 
             String pw = "java";
             String url = "jdbc:oracle:thin:@localhost:1521:xe";
             Class.forName("oracle.jdbc.driver.OracleDriver");        
             conn = DriverManager.getConnection(url, user, pw);          
         } catch (Exception e) {
             e.printStackTrace();
         }
         return conn;     
     }
}

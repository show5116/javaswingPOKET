package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

public class UserDAO {
	private static Connection conn;
	private static PreparedStatement pstm;
	private static ResultSet rs;
    
    public UserDAO() {}
    
    public static boolean logIn(String ID,String password) {
    	String query = String.format("SELECT * FROM TEST WHERE ID = '%s' AND PASSWORD = '%s'",ID,password);
    	password = SHA256Util.encrypt(password); // 암호화
    	try {
    		Select(query);
    		if(rs.next()) {
    			DBclose();
    			return true;
    		}
    		DBclose();
    		return false;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
	}
	
    public static boolean doublecheck(String ID) {
    	String query = String.format("SELECT * FROM TEST WHERE ID = '%s'",ID);
    	try {
    		Select(query);
    		if(rs.next()) {
    			DBclose();
    			return true;
    		}
    		DBclose();
    		return false;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public static void SignUp(String id,String password,String name,String gender,String nickname, String mail){
    	password = SHA256Util.encrypt(password); // 암호화
    	String query = String.format("INSERT INTO TEST VALUES ('%s','%s','%s','%s','%s','%s')",
    			id,password,name,gender,nickname,mail);
    	Update(query);
    	DBclose();
	}
	
	public static String FindId(String name,String mail) {
    	String query = String.format("SELECT * FROM TEST WHERE NAME = '%s' AND MAIL = '%s'",name,mail);
    	try {
    		Select(query);
    		if(rs.next()) {
    			String str =rs.getString("ID");
    			DBclose();
    			return str;
    		}else {
    			DBclose();
    			return null;
    		}    		
    	}catch(Exception e){
    		e.printStackTrace();    		
    		return null;
    	}
	}
	
	public static void SendPassword(String id, String name, String mail) {
		String password = TemporaryPassword.getTemporaryPassword();
		SendMail.ToSendMail(mail, password);
		password = SHA256Util.encrypt(password);
		String quary = String.format("UPDATE TEST SET PASSWORD '%s' WHERE ID = '%s' AND NAME = '%s' AND MAIL = '%s'"
    			, password, id, name, mail);
	}
	
	public static void ChangePassword(String id, String name, String mail,String CurrentPassword,String ChangePassword) {
		CurrentPassword = SHA256Util.encrypt(CurrentPassword);
		ChangePassword = SHA256Util.encrypt(ChangePassword);
    	String quary = String.format("UPDATE TEST SET PASSWORD '%s' WHERE ID = '%s' AND NAME = '%s' AND MAIL = '%s' AND PASSWORD = '%s'"
    			, ChangePassword, id, name, mail, CurrentPassword);
        DBclose();
	}
	
	private static void Select(String query) {
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int Update(String query) {
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			return pstm.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	private static void DBclose(){
		try {
			if ( rs != null )  rs.close();   
			if ( pstm != null )pstm.close();  
			if ( conn != null )conn.close(); 			
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}

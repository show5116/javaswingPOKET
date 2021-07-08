package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

public class User {

    
	private static Connection conn;
	private static PreparedStatement pstm;
	private static ResultSet rs;
    
    private User() {}
    
    public static boolean logIn(String ID,String password) {
    	String quary = String.format("SELECT * FROM TEST WHERE ID = '%s'",ID);
    	password = SHA256Util.encrypt(password); // 암호화
    	try {
    		Quary(quary);
    		if(rs.next()) {
    			if(password.equals(rs.getString(2))) {
    				DBclose();
    				return true;
    			}
    		}
    		DBclose();
    		return false;
    	}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
	}
	
    public static boolean doublecheck(String ID) {
    	String quary = String.format("SELECT * FROM TEST WHERE ID = '%s'",ID);
    	try {
    		Quary(quary);
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
    
    public static boolean patternCheck(String str,String pattern){
    	if(Pattern.matches(pattern,str)) {
    		return true;
    	}
    	return false;
    }
    
    public static void SignUp(String id,String password,String name,String gender,String nickname, String mail){
    	password = SHA256Util.encrypt(password); // 암호화
    	String quary = String.format("INSERT INTO TEST VALUES ('%s','%s','%s','%s','%s','%s')",
    			id,password,name,gender,nickname,mail);
    	try {
    		Quary(quary);
    		DBclose();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
	public static String FindId(String name,String mail) {
    	String quary = String.format("SELECT * FROM TEST WHERE NAME = '%s' AND MAIL = '%s'",name,mail);
    	try {
    		Quary(quary);
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
	
	/*public void ChangePassword() {
		System.out.print("가입한 이름을 입력하세요.");
		String name = sc.next();
    	String quary = String.format("SELECT * FROM TEST WHERE NAME = '%s'",name);
    	rs = this.Quary(quary);
    	try {
    		if(rs.next()) {
    			System.out.print("가입한 아이디를 입력하세요. ");
    			if(sc.next().equals(rs.getString(6))) {
    				System.out.printf("아이디는 %s 입니다.",rs.getString(1));
    			}
    			else System.out.println("아이디가 없습니다.");
    		}else {
    			System.out.println("아이디가 없습니다.");
    		}
    	}catch(SQLException sqle){}
        this.DBclose();
	}*/
	
	private static void Quary(String quary) throws Exception{
		conn = DBConnection.getConnection();
		pstm = conn.prepareStatement(quary);
		rs = pstm.executeQuery();
	}
	
	
	private static void DBclose() throws Exception{
		if ( rs != null )  rs.close();   
		if ( pstm != null )pstm.close();  
		if ( conn != null )conn.close(); 
    }
}

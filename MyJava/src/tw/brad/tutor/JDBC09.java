package tw.brad.tutor;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.lang.RuntimeException;
import org.mindrot.BCrypt;

public class JDBC09 {
	static Connection conn;//static可以呼叫static的屬性方法
	
	public static void main(String[] args) {
		System.out.print("Register... ");
		//先進行資料庫連線
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String url = "jdbc:mysql://127.0.0.1:3306/iii";
		
		try {
			conn=DriverManager.getConnection(url,prop);
			
			Scanner scanner = new Scanner(System.in);
			
			String account;
			do {
				System.out.println("Account:");
				account=scanner.next();
			}while(isAccountExist(account));
			
			System.out.println("Password:");
			String passwd=scanner.next();
			System.out.println("Name:");
			String name=scanner.next();
			
			String sql="insert into member(account,passwd,name)values(?,?,?)";
			String hashPasswd=BCrypt.hashpw(passwd,BCrypt.gensalt() );
			
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, hashPasswd);
			pstmt.setString(3, name);
			if(pstmt.executeUpdate()>0) {
				System.out.println("success");
			}else {
				System.out.println("failure");
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException();
		}
				
}	
			
	static boolean isAccountExist(String account) throws SQLException {
		String sql = "SELECT count(account) count FROM member WHERE account = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt("count");
		
		return count > 0;
	}
}

package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
import org.mindrot.BCrypt;

public class JDBC10 {
	//會員登入認證系統
	static Connection conn;
	public static void main(String[] args) {
		System.out.print("Register... ");
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String url = "jdbc:mysql://127.0.0.1:3306/iii";
		
		try {
			conn=DriverManager.getConnection(url,prop);
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("account:");
			String account=scanner.next();
			System.out.println("password:");
			String password=scanner.next();
			
			String sql="select * from member where account=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,account);
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()) {
				String hashpasswd=rs.getString("passwd");
				if(BCrypt.checkpw(password, hashpasswd)) {
					System.out.println("Login Success");
					System.out.printf("Welcome, %s",rs.getString("name"));
				}else {
					System.out.println("Login Failure1");
				}
			}else {
				System.out.println("Login Failure2");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}
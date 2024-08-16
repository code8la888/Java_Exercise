package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {
	public static void main(String[] args) {
		// Load Driver (Connector)
		// BUT, ....
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
		String url1 = "jdbc:mysql://127.0.0.1:3306/brad?user=root&password=root";
//		try(Connection conn = DriverManager.getConnection(url1)){
//			System.out.println("OK2");
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		String url2 = "jdbc:mysql://127.0.0.1:3306/brad";
//		try(Connection conn = DriverManager.getConnection(url2, "root", "root")){
//			System.out.println("OK3");
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		String url3 = "jdbc:mysql://127.0.0.1:3306/LUNA";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url3, prop)){
			//System.out.println("OK4");
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cust (name,tel,birthday) VALUES ('Brad','123','1999-01-02')";
			sql += ", ('Eric','1111','1999-01-02')";
			sql += ", ('Peter','222','1999-01-02')";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

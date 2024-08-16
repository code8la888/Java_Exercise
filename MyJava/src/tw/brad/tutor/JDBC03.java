package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/LUNA";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url, prop)){
			Statement stmt = conn.createStatement();
			String sql = "UPDATE cust SET tel = '333' WHERE id = 4";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

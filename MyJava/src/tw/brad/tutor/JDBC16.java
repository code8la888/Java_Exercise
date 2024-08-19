package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC16 {

	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/LUNA";
	private static final String SQL_QUERY = "select * from gift";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);
		
		try {
			Connection conn = DriverManager.getConnection(URL,prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY,
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);	
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				String name=rs.getString("name");
				System.out.printf("%s:%s \n",id,name);
			}
			System.out.println("---------");
			if (rs.first()) {
				String id=rs.getString("id");
				String name=rs.getString("name");
				System.out.printf("%s:%s \n",id,name);
			}
			System.out.println("---------");
			if (rs.absolute(47)) {
				String id=rs.getString("id");
				String name=rs.getString("name");
				System.out.printf("%s:%s \n",id,name);
			}
			
			rs.updateString("name", "古意禮");
			rs.updateString("town", "田頭鎮");
			rs.updateRow();
			
			System.out.println("----");
			
			String id=rs.getString("id");
			String name=rs.getString("name");
			rs.updateRow();
			
			System.out.println("-----");
			
//			rs.deleteRow();
			id=rs.getString("id");
			name=rs.getString("name");
			System.out.printf("%s : %s \n",id,name);
			
			System.out.println("-------");
			rs.moveToInsertRow();
			rs.updateString("name", "古意禮");
			rs.updateString("feature", "");
			rs.updateString("addr", "");
			rs.updateString("picurl", "");
			rs.updateString("city", "");
			rs.updateString("town", "");
			rs.updateDouble("lat", 0.0);
			rs.updateDouble("lng", 0.0);
			rs.insertRow();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

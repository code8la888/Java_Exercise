package tw.brad.tutor;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.apis.Bike;




//SELECT sum(UnitPrice*Quantity) from orderdetails 
//WHERE OrderID in(
//		SELECT OrderID from orders 
//		WHERE EmployeeID = 5 
//		); 

public class JDBC15 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/northwind";
	private static final String SQL_QUERY = "select e.EmployeeID, e.LastName, sum(od.UnitPrice* od.Quantity) total from orders o join orderdetails od on (o.OrderID =od.OrderID) join employees e on (o.EmployeeID = e.EmployeeID) group by o.EmployeeID order by total desc; ";
	
	public static void main(String[] args) {
			//物件解序列化objectinputstream
			//readobject
			//if迴圈檢查obj是否為腳踏車

			Properties prop = new Properties();
			prop.put("user", USER);
			prop.put("password", PASSWd);		
			
			try {
				Connection conn = DriverManager.getConnection(URL,prop);
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString("EmployeeID");
					String name = rs.getString("LastName");
					String total = rs.getString("total");
					System.out.printf("%s : %s: %s\n",id,name,total);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}

	}



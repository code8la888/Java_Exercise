package tw.brad.apis;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.ResultSetMetaData;


public class GiftDB {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/LUNA";
	private static final String SQL_QUERY = "select * from gift";
	
	private Connection conn;
	private ResultSet rs;
	private String[] fields;
	
	public  GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);
		
		conn=DriverManager.getConnection(URL,prop);
	}
	public void query() throws SQLException {
		query(SQL_QUERY);
	}
	
	public void query(String sql) throws SQLException{
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery(sql);
			
			ResultSetMetaData rsmd= rs.getMetaData();
			fields =new String[rsmd.getColumnCount()];
			for(int i=0;i<rsmd.getColumnCount();i++) {
				fields[i]=rsmd.getColumnLabel(i+1);
				System.out.println(fields[i]);
			}
		}

	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public int getCols() {
		return fields.length;
	}
	
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(fields[col]);
		} catch (Exception e) {
			return "error";
		}
		
	}
	
	
	
	public String[] getFieldStrings() {
		return fields;
	}
	
	public void delData(int row) throws SQLException {
			rs.absolute(row+1);
			rs.deleteRow();
		}
	public void updateData(String newdata,int row, int col) {
		try {
			rs.absolute(row+1);
			rs.updateString(col+1, newdata);
			rs.updateRow();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

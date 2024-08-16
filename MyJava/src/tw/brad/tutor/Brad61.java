package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class Brad61 {

	public static void main(String[] args) {
		
		try {
			//重點:解析農委會公開數據，並將其儲存到mysql資料庫中
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			//建立一個url物件，用來指定我們要訪問的網址
			URLConnection conn =  url.openConnection();
			//建立urlconnection物件，代表程式與遠端資源之間的連結，
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			//建立一個緩衝輸入流，用來讀取暫存大量資料，讓程式不用每讀取一次就要請求一次，以提高後續讀取動作的效率
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			//從網址讀取數據
			String line; //儲存從網址讀取的每一行數據
			StringBuffer sb = new StringBuffer();//拼接每一行讀到的數據，變成一個完整的字串
			//依序讀取網址內的數據並將他們存放到sb變數中
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			bin.close();
			
			parseJSON(sb.toString());
			//sb.toString()會將StringBuffer轉換為字串物件。這是一個完整的JSON格式字串
			//parseJSON方法會解析傳入的字串，讓你可以在程式操作這些資料
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		
		
		String url = "jdbc:mysql://127.0.0.1:3306/iii";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try{
			Connection conn = DriverManager.getConnection(url, prop);
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM gift");
			stmt.executeUpdate("ALTER TABLE gift AUTO_INCREMENT = 1");
			
			String sql = "INSERT INTO gift (name,feature,addr,picurl,city,town,lat,lng)" + 
					" VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			for (int i=0; i<root.length(); i++) {
				JSONObject element = root.getJSONObject(i);
				String name = element.getString("Name");
				String feature = element.getString("Feature");
				String addr = element.getString("SalePlace");
				String picurl = element.getString("Column1");
				String city = element.getString("County");
				String town = element.getString("Township");
				String lat = element.getString("Latitude");
				String lng = element.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, feature);
				pstmt.setString(3, addr);
				pstmt.setString(4, picurl);
				pstmt.setString(5, city);
				pstmt.setString(6, town);
				
				try {
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(7, 0);
					pstmt.setDouble(8, 0);
				}
				
				pstmt.executeUpdate();
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

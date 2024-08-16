package tw.brad.tutor;

import org.mindrot.BCrypt;

public class Brad66 {

	public static void main(String[] args) {
		String passwd = "123456";//定義一個變數來存取原始密碼，這是待會要進行哈希處理的原始密碼
		String newpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		//這行程式碼會對密碼進行哈希處理:
		//BCrypt.hashpw是用於產生密碼的哈希值，第一個參數是原始密碼，第二個參數是鹽值
		//BCrypt.gensalt()方法會隨機生成一個鹽值，鹽值會被添加道密碼中以添加哈希的安全性
		//
		System.out.println(newpasswd);//印出哈希處理後的密碼值
		if (BCrypt.checkpw("123456", newpasswd)) {
			//BCrypt.checkpw(String plainPassword, String hashedPassword)用來驗證輸入密碼是否和之前定義的密碼匹配
			//當用戶輸入密碼進行驗證時，系統會取出儲存的鹽值，將輸入的密碼與鹽值結合，再進行一次雜湊運算。
			//然後將得到的結果與儲存的雜湊值進行比較。如果兩個值相同，則驗證通過。
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}

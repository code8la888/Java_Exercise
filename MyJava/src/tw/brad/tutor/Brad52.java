package tw.brad.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad52 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("192.168.3.4");
			System.out.println(ip);
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}

}

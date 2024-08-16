package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad53 {

	public static void main(String[] args) {
		String mesg = "好, 休息一下V3";
		byte[] mesgBuf = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(mesgBuf, mesgBuf.length, 
					InetAddress.getByName("10.0.100.163"), 8889);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

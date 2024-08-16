package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad54 {

	public static void main(String[] args) {
		for (;;) {
			byte[] buf = new byte[4*1024];
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				socket.close();
				
				String urIp =  packet.getAddress().getHostAddress();
				byte[] data = packet.getData();
				int len = packet.getLength();
				String mesg = new String(buf,0,len);
				System.out.println("Receive OK");
				System.out.printf("%s => %s\n", urIp, mesg);
				if (mesg.equals("quit")) {
					break;
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
	}

}

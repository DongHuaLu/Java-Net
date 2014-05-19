package _02Socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketWithFourParameter {

	public static void main(String[] args) {
		try {
			InetAddress remoteAddr1 = InetAddress.getByName("192.168.0.25");
			InetAddress remoteAddr2 = InetAddress.getByName("10.10.10.107");
			Socket socket = new Socket(remoteAddr1,5471);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

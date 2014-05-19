package _02Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class _02SocketTimeOut {

	public static void main(String[] args) {
		Socket socket = new Socket();
		InetSocketAddress address = new InetSocketAddress("115.239.210.27", 80);
		try {
			// 6秒连接,未连接报SocketTimeOutException
			socket.connect(address, 6000);
			System.out.println("socket connected on " + socket.getRemoteSocketAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

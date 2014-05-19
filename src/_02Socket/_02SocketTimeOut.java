package _02Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
/**
 * 超时测试,连接该ip端口,设置超时,若超时 抛出connect timed out错误
 * @author ludonghua
 *
 */
public class _02SocketTimeOut {

	public static void main(String[] args) {
		Socket socket = new Socket();
		InetSocketAddress address = new InetSocketAddress("115.239.210.27", 80);
		try {
			// 6秒连接,未连接报SocketTimeOutException
			socket.connect(address, 10);
			System.out.println("socket connected on " + socket.getRemoteSocketAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

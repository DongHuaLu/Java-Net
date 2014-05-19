package _02Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _InetAddress {

	public static void main(String[] args) {
		try {
			//得到本地地址
			InetAddress addr1 = InetAddress.getLocalHost();
			// 得到115.239.210.27的地址
			InetAddress addr2 = InetAddress.getByName("115.239.210.27");
			// 得到域名为www.baidu.com
			InetAddress addr3 = InetAddress.getByName("www.baidu.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

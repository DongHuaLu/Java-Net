package _02Socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 设置连接时间,延时,带宽的相对权重
 * @author ludonghua
 *
 */
public class _06ScoketPerformancePreferenecs {

	public static String host = "www.baidu.com";
	public static int port = 80;
	
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(host,port);
			// 设置连接时间,延时,带宽的相对权重,此设置表示带宽最重要,连接时间次之,延时相对不重要
			socket.setPerformancePreferences(2, 1, 3);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

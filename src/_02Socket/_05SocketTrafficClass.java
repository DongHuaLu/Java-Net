package _02Socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 设置服务类型选项
 * public void setTrafficClass(int trafficClass)
 * 
 * 分别用四种方式
 * 00010   0x02 低成本
 * 00100   0x04 高可靠性
 * 01000   0x08 最高吞吐量
 * 10000   0x10 最小延时
 * 
 * 可以重复组合设置
 * @author ludonghua
 *
 */
public class _05SocketTrafficClass {
	public static String host = "www.baidu.com";
	public static int port = 80;
	
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(host,port);
			// 请求连接为低成本连接
			socket.setTrafficClass(0x02);
			// 请求高性能与最小延时
			socket.setTrafficClass(0x04|0x10);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}

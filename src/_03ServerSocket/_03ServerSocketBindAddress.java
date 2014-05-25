package _03ServerSocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * 设置服务端绑定的地址,如果服务器有两个或以上ip(多网卡)
 * 则在ServerSocket构造方法中加入对应的ip地址可以保证只有连接该Ip的连接可以访问
 * @author ludonghua
 *
 */
public class _03ServerSocketBindAddress {

	public static void main(String[] args) {
		try {
			// 如果该服务器有两个ip,公网ip(xxx.xxx.xxx.xxx) 与内网ip(192.168.10.75)
			// 当只希望客户端只能通过内网ip访问该服务器,则在构造方法中加入对应要绑定的ip
			ServerSocket serverSocket = new ServerSocket(8092,10,InetAddress.getByName("192.168.10.75"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

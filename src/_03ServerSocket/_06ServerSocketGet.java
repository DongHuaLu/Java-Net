package _03ServerSocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * 获取serverSocket的属性
 * @author ludonghua
 *
 */
public class _06ServerSocketGet {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8092,10,InetAddress.getByName("192.168.10.75"));
		// 获取serverSocket绑定的ip地址
		System.out.println("绑定的地址为: " + serverSocket.getInetAddress());
		// 获取serverSocket绑定的端口
		System.out.println("绑定的端口为" + serverSocket.getLocalPort());
		// 使用系统分配的随机端口来绑定serverSocket
		serverSocket = new ServerSocket(0);
		System.out.println("系统分配的端口为 : " + serverSocket.getLocalPort());
	}
}

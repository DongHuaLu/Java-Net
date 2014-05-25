package _03ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * serverSocket.close()关闭一个服务器端口来及时释放所绑定的端口
 * 即使不调用close()方法,关闭服务器也会释放对应端口
 * serverSocket.isClosed()判定该是否已经关闭,只有调用过close()方法才会返回true,即使没有绑定任何端口,isClosed()也返回false
 * serverSocket.isBound()返回是否与一个端口进行绑定,如果没有绑定,返回false,如果与一个端口进行过绑定,即使调用过close()方法也会返回true
 * @author ludonghua
 *
 */
public class _05ServerSocketCloseAndBound {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8092);
		System.out.println(serverSocket.isClosed()); // false
		System.out.println(serverSocket.isBound()); // true
		serverSocket.close();
		System.out.println(serverSocket.isClosed()); // true
		System.out.println(serverSocket.isBound()); // true
		
		
		serverSocket = new ServerSocket();
		System.out.println(serverSocket.isClosed()); // false
		System.out.println(serverSocket.isBound()); // false
		serverSocket.close();
		System.out.println(serverSocket.isClosed()); // true
		System.out.println(serverSocket.isBound()); // false
		
		// 需要检测一个serverSocket是否与一个端口绑定并且还没有关闭
		boolean isOpen = !serverSocket.isClosed() && serverSocket.isBound();
	}
}

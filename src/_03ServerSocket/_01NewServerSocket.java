package _03ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ServerSocket构造方法
 * @author ludonghua
 *
 */
public class _01NewServerSocket {
	public static void main(String[] args) {
		try {
			// 绑定8000端口
			ServerSocket serverSocket1 = new ServerSocket(8000);
			// 绑定8000端口,并且设置客户端请求的队列长度为60,如果没有通过serverSocket2.accept()取出队列
			// 当队列大于60的时候会拒绝新的连接(系统默认连接数为50)
			ServerSocket serverSocket2 = new ServerSocket(8000,60);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

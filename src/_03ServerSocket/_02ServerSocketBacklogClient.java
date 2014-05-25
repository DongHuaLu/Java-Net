package _03ServerSocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 客户端向服务端发起100个连接
 * @author ludonghua
 *
 */
public class _02ServerSocketBacklogClient {

	public static void main(String[] args) {
		String host = "localhost";
		int port = 8092;
		int num = 100;
		Socket[] socket = new Socket[num];
		for(int i=0;i<num;i++){
			try {
				socket[i] = new Socket(host, port);
				System.out.println("第"+(i+1)+"个socket 创建成功");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

package _03ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 未调用accept方法时最多接受10个连接,每accept一个连接都要等待5秒
 * 客户端的表现为连接上11个连接后(因为开始就accept一个连接),新的连接会报Connection refused: connect
 * 直到5秒后服务端再accept连接,客户端才能新加入连接
 * @author ludonghua
 *
 */
public class _02ServerScoketBacklogServer {
	private ServerSocket serverSocket;
	private int prot = 8092;
	
	public _02ServerScoketBacklogServer(){
		try {
			serverSocket = new ServerSocket(prot,10);
			System.out.println("服务器已经启动");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void service(){
		while(true){
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				System.out.println("New connections accepted" + socket.getInetAddress() + " : " + socket.getPort());
				Thread.sleep(5000);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				if(socket!=null){
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		_02ServerScoketBacklogServer server = new _02ServerScoketBacklogServer();
		server.service();
	}
}

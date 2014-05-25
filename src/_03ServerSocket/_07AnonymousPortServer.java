package _03ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用匿名端口进行通信
 * 先于8092端口进行通信,服务器生成一个匿名端口服务,并把生成的匿名端口发送给客户端,新建一个线程处理匿名端口的通信
 * @author ludonghua
 *
 */
public class _07AnonymousPortServer {
	private ServerSocket manageServerSocket;
	// <端口,server>
	private Map<Integer,ServerSocket> anonymousServers;
	private int managePort = 8092;
	
	public static void main(String[] args) {
		new _07AnonymousPortServer().manageService();
	}
	
	public _07AnonymousPortServer(){
		try {
			manageServerSocket = new ServerSocket(managePort);
		} catch (IOException e) {
			e.printStackTrace();
		}
		anonymousServers = new ConcurrentHashMap<Integer, ServerSocket>();
		System.out.println("管理服务器启动");
	}
	
	public void manageService(){
		while(true){
			Socket socket = null;
			try {
				socket = manageServerSocket.accept();
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				// 新建一个匿名端口的服务
				ServerSocket anonymousServer = new ServerSocket(0);
				System.out.println("建立了匿名服务器 端口号:" + anonymousServer.getLocalPort());
				anonymousServers.put(anonymousServer.getLocalPort(), anonymousServer);
				// 向客户端发送生成的匿名端口
				pw.println(anonymousServer.getLocalPort());
				// 新建一个线程处理匿名端口的数据
				new anonyMounsServer(anonymousServer,anonymousServers).start();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	/**
	 * 匿名服务器线程
	 * @author ludonghua
	 *
	 */
	public class anonyMounsServer extends Thread{
		// 匿名服务器
		private ServerSocket anonymounsServer;
		// 服务器集合
		private Map<Integer,ServerSocket> anonymousServers;
		
		public anonyMounsServer(ServerSocket anonymounsServer,Map<Integer,ServerSocket> anonymousServers){
			this.anonymounsServer = anonymounsServer;
			this.anonymousServers = anonymousServers;
			
		}
		
		@Override
		public void run() {
			Socket socket = null;
			try {
				socket = anonymounsServer.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				String msg = null;
				while(true){
					if((msg=br.readLine())!=null){
						System.out.println("匿名端口:"+anonymounsServer.getLocalPort() + " -- "+msg);
						if("2".equals(msg)){
							pw.println("22");
						}
						if("close".equals(msg)){
							anonymousServers.remove(anonymounsServer.getLocalPort());
							break;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(socket!=null){
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(anonymounsServer!=null){
					try {
						anonymounsServer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

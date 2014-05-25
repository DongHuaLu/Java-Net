package _03ServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 匿名端口的客户端
 * @author ludonghua
 *
 */
public class _07AnonymousProtClient {
	private String manageHost = "127.0.0.1";
	private int managePort = 8092;
	
	public static void main(String[] args) {
		_07AnonymousProtClient client = new _07AnonymousProtClient();
		client.communcation(client.getanonyMousProt());
	}
	
	public void communcation(Socket socket){
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			while(true){
				if((msg=localReader.readLine())!=null){
					pw.println(msg);
					String response = null;
					if((response = br.readLine())!=null){
						System.out.println("消息:"+response);
						if("close".equals(response)){
							break;
						}
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
		}
	}
	
	public Socket getanonyMousProt(){
		Socket manageSocket = null;
		try {
			manageSocket = new Socket(manageHost,managePort);
			BufferedReader br = new BufferedReader(new InputStreamReader(manageSocket.getInputStream()));
			Thread.sleep(1000);
			String anonymoutProt = null;
			while ((anonymoutProt= br.readLine())!=null){
				System.out.println("获取匿名端口:" + anonymoutProt);
				return new Socket(manageHost,Integer.parseInt(anonymoutProt));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			if(manageSocket!=null){
				try {
					manageSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}

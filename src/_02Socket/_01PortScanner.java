package _02Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 端口扫描器
 * @author ludonghua
 *
 */
public class _01PortScanner {

	
	public static void main(String[] args) {
		String host = "192.168.10.";
		_01PortScanner s = new _01PortScanner();
		for(int j=1;j<255;j++){
			String r = host+j;
			for(int i=80;i<=80;i++){
				s.scan(r, i);
			}
		}
	}
	
	private void scan(String host,int port){
		Socket socket = null;
		try {
			socket = new Socket();
			InetSocketAddress address = new InetSocketAddress(host, port);
			// 连接此端口,连上了打印
			socket.connect(address, 500);
			System.out.println("This is a server on " + host + ":" + port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("can not find port " + port + " on " + host);
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

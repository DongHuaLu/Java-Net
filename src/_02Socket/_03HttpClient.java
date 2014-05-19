package _02Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * 通过socket模拟http连接
 */

public class _03HttpClient {
	private String host = "news.qq.com";
	private int port = 80;
	private Socket socket = null;
	
	public _03HttpClient() throws UnknownHostException, IOException {
		socket = new Socket(host,port);
	}
	
	public void get() throws IOException{
		StringBuilder sb = new StringBuilder();
		sb.append("GET").append("/zt2014/mnchunjie/index.htm").append(" HTTP/1.1\r\n");
		sb.append("Host:").append(host).append("\r\n");
		sb.append("Accept: */*\r\n");
		sb.append("Accept-Language:zh-cn\r\n");
		sb.append("Accept-Encoding:gzip,deflate\r\n");
		sb.append("User-Agent:Mozilla/4.0(compatible;MSIE 6.0; Windows NT 5.0)\r\n");
		sb.append("Connection:Keep-Alive\r\n\r\n");
		
		OutputStream socketOut = socket.getOutputStream();
		socketOut.write(sb.toString().getBytes());
		socket.shutdownOutput();
		
		InputStream socketIn = socket.getInputStream();
//		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(socketIn));
//		byte[] buff = new byte[1024];
//		int len = -1;
		String data = null;
		while((data = br.readLine())!=null){
//			buffer.write(buff,0,len);
			System.out.println(data);
		}
//		System.out.println(new String(buffer.toByteArray()));
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		_03HttpClient httpClient = new _03HttpClient();
		httpClient.get();
	}
}

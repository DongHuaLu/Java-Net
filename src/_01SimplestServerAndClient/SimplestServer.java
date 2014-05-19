package _01SimplestServerAndClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SimplestServer {
	private int port = 5000;
	private ServerSocket serverSocket;
	
	public SimplestServer() {
		try {
			serverSocket = new ServerSocket(port);
			System.err.println("Server Start;");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void service(){
		while(true){
			Socket socket=null;
			try {
				socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				
				String msg = null;
				while((msg=br.readLine())!=null){
					System.out.println(msg);
					pw.println("server "+ msg);
					if(msg.equals("bye")){
						break;
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
	}
	
	public static void main(String[] args) {
		new SimplestServer().service();
	}
}

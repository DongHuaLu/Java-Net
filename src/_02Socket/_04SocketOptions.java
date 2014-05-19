package _02Socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class _04SocketOptions {
	private String host = "localhost";
	private int port = 8000;
	private Socket socket;
	
	public _04SocketOptions() throws UnknownHostException, IOException {
		socket = new Socket(host,port);
		// 取消发送数据的缓冲,一有数据就向对方发出(默认是等缓冲池满后再一起发出)
		socket.setTcpNoDelay(true);
		// 确保一个进程关闭socket后,即使没有释放端口,同一主机其他进程可以立即使用该端口
		socket.setReuseAddress(true);
		// 设置socket的InputStream.read()超时,如果时间到还未读到数据,抛出SocketTimeOutException
		socket.setSoTimeout(5000);
		// 默认socket.close()不会立即关闭,发完所有数据后才会关闭
		// 设置soLinger为(true,0),会在close()立即关闭socket
		// 设值soLinger为(true,3),会在close()后满足两个条件中的一个就关闭session
		// 1.剩余数据发送完毕,2.过了3秒,但没发送完毕
		socket.setSoLinger(true, 3);
		// 设置输入/输出数据的缓冲区大小
		// 传输大的连续的数据可以设置大点来减少传输的次数,来提高传输效率
		// 传输数据量较小,但实时性要求较高的,可以采用小的缓存区
		socket.setReceiveBufferSize(1024);
		socket.setSendBufferSize(1024);
		// 设置为true会一直监视该链接是否有效,当连接处于空闲状态两个小时,会发送一个数据包,如果没有接到回应,12分钟后会关闭本地的socket
		socket.setKeepAlive(true);
	}
}

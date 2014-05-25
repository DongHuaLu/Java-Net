package _03ServerSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * 默认的ServerSocket构造方法,在构造的时候不指定对应的端口
 * 主要的作用是,有一些属性在绑定的对应的端口后设置是无效的(ep:SO_REUSEADDR)
 * 所以使用默认的构造方法,在设置完对应的属性后再绑定对应的端口
 * @author ludonghua
 *
 */
public class _04ServerSocketDefaultConstruction {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket();
			// 设置SO_REUSEADDR后再绑定端口
			serverSocket.setReuseAddress(true);
			serverSocket.bind(new InetSocketAddress(8092));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

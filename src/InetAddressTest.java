import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressTest {
	public static void main(String[] args) {
		try {
			InetAddress[] baidu = InetAddress.getAllByName("www.baidu.com");
			for(int i=0;i<baidu.length;i++){
				System.out.println(baidu[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

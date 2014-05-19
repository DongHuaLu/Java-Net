import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 根据域名获取对应的ip地址
 * @author ludonghua
 *
 */
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

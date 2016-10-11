import java.net.InetAddress;
import java.net.UnknownHostException;

public class SiteTypes {
	public static int getVersion(InetAddress ia) {		//定义一个整型的静态方法
		byte[] b = ia.getAddress();					//定义一个字节型的数组，并初始化。
		if (b.length == 4) {						//判断这个数组的长度是否等于4
			return 4;							//返回数值4
		} else if (b.length == 16) {
			return 6;
		} else {
			return -1;
		}
	}
	public static char getClass(InetAddress ia) {		//定义一个字符型的静态方法
		byte[] b = ia.getAddress();					//定义一个字节型的数组，并初始化。
		if (b.length != 4) {						//判断这个	字符数组的长度是否不等于4
			throw new IllegalArgumentException("no ipv6 address");//抛出一个非法参数异常
		}
		int firstByte = b[0];						//定义一个整型的变量
		//使用多个if-else语句判断这个整型的变量与十六进制码比较
		if ((firstByte & 0x80) == 0) {
			return 'A';
		} else if ((firstByte & 0xc0) == 0x80) {
			return 'B';
		} else if ((firstByte & 0xe0) == 0xc0) {
			return 'C';
		} else if ((firstByte & 0xF0) == 0xE0) {
			return 'D';
		} else if ((firstByte & 0xF8) == 0xF0) {
			return 'E';
		} else {
			return 'F';
		}
	}
	public static void main(String[] args) {
		InetAddress ia = null;
		try {
			ia = InetAddress.getByName("www.baidu.com");//给定一个网络域名
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		int len;
		char king;
		len = getVersion(ia);							//调用方法求出地址的长度
		System.out.println("地址长度为：" + len);
		king = getClass(ia);							//调用方法求出地址的类型
		System.out.println("地址的类型为：" + king);
	}
}

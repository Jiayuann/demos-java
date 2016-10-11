import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

//可利用共同的密钥来计算消息摘要的验证码 MyMessage.java
public class PublicKeyMessage {
	public static void main(String[] args) throws Exception {
		message_1();
		message_2();
		message_3();
	}
	public static void message_1() throws Exception {
		String str = "I love Java!";// 定义一个消息摘要串
		// 共同的密钥编码，这个可以通过其它算法计算出来
		byte[] kb = { 11, 105, -119, 50, 4, -105, 16, 38, -14, -111, 21, -95,
				70, -15, 76, -74, 67, -88, 59, -71, 55, -125, 104, 42 };
		SecretKeySpec k = new SecretKeySpec(kb, "HMACSHA1");// 获取共同的密钥
		Mac m = Mac.getInstance("HmacMD5");// 获取Mac对象
		m.init(k);//用给定的密钥初始化此 Mac 对象
		m.update(str.getBytes("UTF-8"));
		byte[] by = m.doFinal();// 生成消息码
		// 下面把消息码转换为字符串
		String result = "";
		for (int i = 0; i < by.length; i++) {
			result += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00)
					.substring(6);
		}
		System.out.println("用共同的密钥来计算消息摘要的验证码：" + result);

	}

	// 计算一段字符串的消息摘要
	public static void message_2() throws Exception {
		String str = "Welcome to China!";
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 常用的有MD5,SHA算法等
		md.update(str.getBytes("UTF-8"));// 传入原始字串
		byte[] by = md.digest();// 计算消息摘要放入byte数组中
		// 下面把消息摘要转换为字符串
		String result = "";
		for (int i = 0; i < by.length; i++) {
			result += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00)
					.substring(6);
		}
		System.out.println("一段字符串的消息摘要为：" + result);

	}

	// 计算从输入（出）流中计算消息摘要。
	public static void message_3() throws Exception {
		String fileName = "D:/test/test.txt";
		MessageDigest md = MessageDigest.getInstance("MD5");
		FileInputStream fin = new FileInputStream(fileName);
		DigestInputStream din = new DigestInputStream(fin, md);// 构造输入流
		int length;
		while ((length = din.read()) != -1) {
			// 做一些对文件的处理
			if(length=='$') din.on(true); //当遇到文件中的符号$时才开始计算
		}
		byte[] by = md.digest();// 获得消息摘要
		// 下面把消息摘要转换为字符串
		String result = "";
		for (int i = 0; i < by.length; i++) {
			result += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00)
					.substring(6);
		}
		System.out.println("从文本中计算消息摘要为：" + result);
	}
}
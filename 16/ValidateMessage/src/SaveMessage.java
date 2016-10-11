import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;

public class SaveMessage {
	public static void main(String args[]) throws Exception {
		String name = "Lester";// 账号
		String passwd = "123";// 口令

		MessageDigest m = MessageDigest.getInstance("MD5");// 创建MessageDigest对象
		m.update(passwd.getBytes("UTF8"));// 将口令传入需要计算的字节数组
		byte s[] = m.digest();// 进行消息摘要的计算
		String result = "";
		for (int i = 0; i < s.length; i++) {
			result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00)
					.substring(6);
		}
		PrintWriter out = new PrintWriter(new FileOutputStream("userpassword.txt"));// 将消息口令写入指定的文件中
		out.println(name);
		out.println(result);
		out.close();
	}

}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.MessageDigest;

public class AttackMessage {
	public static void main(String args[]) throws Exception {
		/** 获取用户的摘要信息 */
		String user = "";
		String password = "";
		BufferedReader in = new BufferedReader(new FileReader("userpassword.txt"));
		while ((user = in.readLine()) != null) {
			password = in.readLine();
			if (user.equals("mum")) {
				System.out.println("获取用户的摘要信息为：");
				System.out.println(password + "\n");
				System.out.println("根据用户的摘要信息而破解的口令为：");
				System.out.println("mum");
			}
		}

		MessageDigest m = MessageDigest.getInstance("MD5");
		PrintWriter out = new PrintWriter(new FileOutputStream("dictary.txt"));// 指定攻击口令摘要的字典
		/** 生成3位口令的字典 */
		for (int i1 = 'a'; i1 < 'z'; i1++) {
			for (int i2 = 'a'; i2 < 'z'; i2++)
				for (int i3 = 'a'; i3 < 'z'; i3++) {
					char[] ch = { (char) i1, (char) i2, (char) i3 };
					String passwd = new String(ch);
					m.update(passwd.getBytes("UTF8"));
					byte s[] = m.digest();
					String result = "";
					for (int i = 0; i < s.length; i++) {
						result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
					}
					out.print(passwd + ",");// 写入字符和字符的消息摘要
					out.println(result);
				}
		}
		out.close();
		Dictionary(password);// 破解传入摘要的口令
	}

	public static void Dictionary(String pass) throws Exception {// 查看生成的字典是否包含给定的消息摘要
		String md, str;
		BufferedReader in = new BufferedReader(new FileReader("dictary.txt"));// 读取生成的字典
		while ((md = in.readLine()) != null) {
			if (md.indexOf("") != -1) {
				str = md.substring(md.lastIndexOf(",") + 1);// 取出消息摘要
				if (str.equals(pass)) {
					System.out.println("根据用户的摘要信息而破解的口令为：");
					System.out.println(md.substring(0, md.lastIndexOf(",")));// 输出口令	
				}
			}
		}
		in.close();
	}
}

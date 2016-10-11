import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;

public class ValidateMessage {
	public static void main(String args[]) throws Exception {
		/* 读取保存的口令摘要 */
		String user = "";
		String password = "";
		BufferedReader in = new BufferedReader(new FileReader("userpassword.txt"));
		while ((user = in.readLine()) != null) {
			password = in.readLine();
			System.out.println(password);
			if (user.equals("Lester")) {
				break;
			}
		}

		/* 生成用户输入的口令摘要 */
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("123".getBytes("UTF8"));
		byte b[] = md.digest();
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toHexString((0x000000ff & b[i]) | 0xffffff00)
					.substring(6);
		}

		/* 检验口令摘要是否匹配 */
		if (user.equals("Lester") && result.equals(password)) {
			System.out.println("账号和口令都正确");
		} else {
			System.out.println("错误的账号或口令");
		}
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;

public class ValidateMessage {
	public static void main(String args[]) throws Exception {
		/* ��ȡ����Ŀ���ժҪ */
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

		/* �����û�����Ŀ���ժҪ */
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("123".getBytes("UTF8"));
		byte b[] = md.digest();
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toHexString((0x000000ff & b[i]) | 0xffffff00)
					.substring(6);
		}

		/* �������ժҪ�Ƿ�ƥ�� */
		if (user.equals("Lester") && result.equals(password)) {
			System.out.println("�˺źͿ����ȷ");
		} else {
			System.out.println("������˺Ż����");
		}
	}

}

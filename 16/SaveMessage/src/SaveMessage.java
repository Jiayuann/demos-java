import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;

public class SaveMessage {
	public static void main(String args[]) throws Exception {
		String name = "Lester";// �˺�
		String passwd = "123";// ����

		MessageDigest m = MessageDigest.getInstance("MD5");// ����MessageDigest����
		m.update(passwd.getBytes("UTF8"));// ���������Ҫ������ֽ�����
		byte s[] = m.digest();// ������ϢժҪ�ļ���
		String result = "";
		for (int i = 0; i < s.length; i++) {
			result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00)
					.substring(6);
		}
		PrintWriter out = new PrintWriter(new FileOutputStream("userpassword.txt"));// ����Ϣ����д��ָ�����ļ���
		out.println(name);
		out.println(result);
		out.close();
	}

}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.MessageDigest;

public class AttackMessage {
	public static void main(String args[]) throws Exception {
		/** ��ȡ�û���ժҪ��Ϣ */
		String user = "";
		String password = "";
		BufferedReader in = new BufferedReader(new FileReader("userpassword.txt"));
		while ((user = in.readLine()) != null) {
			password = in.readLine();
			if (user.equals("mum")) {
				System.out.println("��ȡ�û���ժҪ��ϢΪ��");
				System.out.println(password + "\n");
				System.out.println("�����û���ժҪ��Ϣ���ƽ�Ŀ���Ϊ��");
				System.out.println("mum");
			}
		}

		MessageDigest m = MessageDigest.getInstance("MD5");
		PrintWriter out = new PrintWriter(new FileOutputStream("dictary.txt"));// ָ����������ժҪ���ֵ�
		/** ����3λ������ֵ� */
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
					out.print(passwd + ",");// д���ַ����ַ�����ϢժҪ
					out.println(result);
				}
		}
		out.close();
		Dictionary(password);// �ƽ⴫��ժҪ�Ŀ���
	}

	public static void Dictionary(String pass) throws Exception {// �鿴���ɵ��ֵ��Ƿ������������ϢժҪ
		String md, str;
		BufferedReader in = new BufferedReader(new FileReader("dictary.txt"));// ��ȡ���ɵ��ֵ�
		while ((md = in.readLine()) != null) {
			if (md.indexOf("") != -1) {
				str = md.substring(md.lastIndexOf(",") + 1);// ȡ����ϢժҪ
				if (str.equals(pass)) {
					System.out.println("�����û���ժҪ��Ϣ���ƽ�Ŀ���Ϊ��");
					System.out.println(md.substring(0, md.lastIndexOf(",")));// �������	
				}
			}
		}
		in.close();
	}
}

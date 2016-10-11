import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

//�����ù�ͬ����Կ��������ϢժҪ����֤�� MyMessage.java
public class PublicKeyMessage {
	public static void main(String[] args) throws Exception {
		message_1();
		message_2();
		message_3();
	}
	public static void message_1() throws Exception {
		String str = "I love Java!";// ����һ����ϢժҪ��
		// ��ͬ����Կ���룬�������ͨ�������㷨�������
		byte[] kb = { 11, 105, -119, 50, 4, -105, 16, 38, -14, -111, 21, -95,
				70, -15, 76, -74, 67, -88, 59, -71, 55, -125, 104, 42 };
		SecretKeySpec k = new SecretKeySpec(kb, "HMACSHA1");// ��ȡ��ͬ����Կ
		Mac m = Mac.getInstance("HmacMD5");// ��ȡMac����
		m.init(k);//�ø�������Կ��ʼ���� Mac ����
		m.update(str.getBytes("UTF-8"));
		byte[] by = m.doFinal();// ������Ϣ��
		// �������Ϣ��ת��Ϊ�ַ���
		String result = "";
		for (int i = 0; i < by.length; i++) {
			result += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00)
					.substring(6);
		}
		System.out.println("�ù�ͬ����Կ��������ϢժҪ����֤�룺" + result);

	}

	// ����һ���ַ�������ϢժҪ
	public static void message_2() throws Exception {
		String str = "Welcome to China!";
		MessageDigest md = MessageDigest.getInstance("MD5");
		// ���õ���MD5,SHA�㷨��
		md.update(str.getBytes("UTF-8"));// ����ԭʼ�ִ�
		byte[] by = md.digest();// ������ϢժҪ����byte������
		// �������ϢժҪת��Ϊ�ַ���
		String result = "";
		for (int i = 0; i < by.length; i++) {
			result += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00)
					.substring(6);
		}
		System.out.println("һ���ַ�������ϢժҪΪ��" + result);

	}

	// ��������루�������м�����ϢժҪ��
	public static void message_3() throws Exception {
		String fileName = "D:/test/test.txt";
		MessageDigest md = MessageDigest.getInstance("MD5");
		FileInputStream fin = new FileInputStream(fileName);
		DigestInputStream din = new DigestInputStream(fin, md);// ����������
		int length;
		while ((length = din.read()) != -1) {
			// ��һЩ���ļ��Ĵ���
			if(length=='$') din.on(true); //�������ļ��еķ���$ʱ�ſ�ʼ����
		}
		byte[] by = md.digest();// �����ϢժҪ
		// �������ϢժҪת��Ϊ�ַ���
		String result = "";
		for (int i = 0; i < by.length; i++) {
			result += Integer.toHexString((0x000000ff & by[i]) | 0xffffff00)
					.substring(6);
		}
		System.out.println("���ı��м�����ϢժҪΪ��" + result);
	}
}
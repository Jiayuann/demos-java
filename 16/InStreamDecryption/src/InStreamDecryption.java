import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class InStreamDecryption {
	public static void main(String args[]) throws Exception {
		// ������Կ
		FileInputStream f = new FileInputStream("key1.dat");
		ObjectInputStream ob = new ObjectInputStream(f);
		Key k = (Key) ob.readObject();
		Cipher cp = Cipher.getInstance("DESede");// ����������
		cp.init(Cipher.DECRYPT_MODE, k);// ��ʼ��������
		FileInputStream in = new FileInputStream("InStreamEncryption.dat");// ��ȡҪ���ܵ��ļ�
		CipherInputStream cin = new CipherInputStream(in, cp);// ����CipherInputStream����
		int b = 0;
		System.out.println("���ļ����������ܵ�ԭ�����£�");
		while ((b = cin.read()) != -1) {// ��ȡ������
			System.out.print((char) b );
		}
	}
}

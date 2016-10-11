import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
public class OutputStreamDecryption {
	public static void main(String args[]) throws Exception {
		FileInputStream fis = new FileInputStream("key1.dat");// ��ȡ��Կ
		ObjectInputStream ois = new ObjectInputStream(fis);
		Key key = (Key) ois.readObject();// ������Կ
		Cipher cp = Cipher.getInstance("DESede");// ����������
		cp.init(Cipher.DECRYPT_MODE, key);// ��ʼ��������
		FileInputStream in = new FileInputStream("Out_java.dat");// ��ȡ����ܵ��ļ�
		FileOutputStream out = new FileOutputStream("Dec_java.txt");// ָ���������ĵ��ļ�
		CipherOutputStream cout = new CipherOutputStream(out, cp);// ����CipherOutputStream����
		int b = 0;
		System.out.println("���ļ���������ܵ��������£�");
		while ((b = in.read()) != -1) {// д����
			cout.write(b);
		}
		// �ر���
		cout.close();
		out.close();
		in.close();
	}
}

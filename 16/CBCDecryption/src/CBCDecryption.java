import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class CBCDecryption {
	public static void main(String args[]) throws Exception {
		String path = System.getProperty("user.dir") + "//key1.dat"; // �õ���Կ��·��
		FileInputStream in = new FileInputStream("EncCBC.dat");// ��ȡ����
		byte[] rand = new byte[8];
		in.read(rand);
		IvParameterSpec iv = new IvParameterSpec(rand);// ��ȡ��ʼ����
		int num = in.available();
		byte[] ctext = new byte[num];
		in.read(ctext);
		FileInputStream in1 = new FileInputStream(path);// ��ȡ��Կ
		ObjectInputStream b = new ObjectInputStream(in1);
		Key k = (Key) b.readObject();
		// ��ȡ��������ִ�м���
		Cipher cp = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cp.init(Cipher.DECRYPT_MODE, k, iv);
		byte[] ptext = cp.doFinal(ctext);
		String str = new String(ptext, "UTF8");
		System.out.println("CBC���ܺ���ַ���Ϊ��");
		System.out.println(str);
	}

}

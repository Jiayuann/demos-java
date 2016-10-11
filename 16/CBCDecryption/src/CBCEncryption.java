import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class CBCEncryption {
	public static void main(String args[]) throws Exception {
		String s = "��ӭ����Java���磡";
		String path = System.getProperty("user.dir") + "//key1.dat"; // �õ���Կ��·��
		FileInputStream f1 = new FileInputStream(path);// ��ȡ��Կ
		ObjectInputStream b = new ObjectInputStream(f1);// ��������������
		Key k = (Key) b.readObject();// �� ObjectInputStream ��ȡ����
		// ���ɳ�ʼ������
		byte[] rand = new byte[8];
		Random r = new Random();// ���������������
		r.nextBytes(rand);// ��������ֽڲ���������rand�ֽ�������
		IvParameterSpec iv = new IvParameterSpec(rand);// ʹ�� rand�е��ֽ���Ϊ IV
		// ����ʼ��һ��IvParameterSpec����
		// ����
		Cipher cp = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cp.init(Cipher.ENCRYPT_MODE, k, iv);
		byte ptext[] = s.getBytes("UTF8");	
		byte ctext[] = cp.doFinal(ptext);
		// ��ӡ���ܽ��
		System.out.println("������ܽ��Ϊ��");
		for (int i = 0; i < ctext.length; i++) {
			System.out.print(ctext[i] + ",");
			if ((i + 1) % 5 == 0)
				System.out.println();
		}
		// ������ܽ��
		FileOutputStream f2 = new FileOutputStream("EncCBC.dat");
		f2.write(rand);
		f2.write(ctext);
	}
}

//���� �Գ���Կ
import java.io.*;
import javax.crypto.*;
public class Symmetric_key {
	public static void main(String args[]) throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("DESede");//	��ȡ��Կ������
		kg.init(168);//	��ʼ����Կ������
		SecretKey sk = kg.generateKey();//������Կ
		FileOutputStream fos = new FileOutputStream("key1.dat");//����Կ������key1.dat�ļ���
		ObjectOutputStream b = new ObjectOutputStream(fos);
		b.writeObject(sk);
	}
}

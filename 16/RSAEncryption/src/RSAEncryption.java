import java.security.*;
import java.security.interfaces.*;
import java.math.*;
import java.io.*;

public class RSAEncryption {

	public static void main(String[] args) {
		try {
			new RSAEncryption();
			Encryption_RSA();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RSAEncryption() throws Exception {// ���췽�� ������Կ��˽Կ
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");//����ʵ��RSA�㷨��KeyPairGenerator����
		kpg.initialize(1024);// ��ʼ��ȷ����Կ�Ĵ�С	
		KeyPair kp = kpg.genKeyPair();// ������Կ��
		PublicKey pbkey = kp.getPublic();// ������Կ
		PrivateKey prkey = kp.getPrivate();// ����˽Կ
		// ���湫Կ
		FileOutputStream file1 = new FileOutputStream("D:/temp/Skey_RSA_pub.dat");
		ObjectOutputStream ob1 = new ObjectOutputStream(file1);//����ObjectOutputStream����
		ob1.writeObject(pbkey); //��ָ���Ķ���д�� ObjectOutputStream��
		// ����˽Կ
		FileOutputStream file2 = new FileOutputStream("D:/temp/Skey_RSA_priv.dat");
		ObjectOutputStream ob2 = new ObjectOutputStream(file2);
		ob2.writeObject(prkey);

	}

	public static void Encryption_RSA() throws Exception {
		System.out.println("���ݹ�Կ�������ģ�"+"\n");
		String string = "I love Java !";
		// ��ȡ��Կ������e,n
		FileInputStream f_in = new FileInputStream("D:/temp/Skey_RSA_pub.dat");
		ObjectInputStream o_in = new ObjectInputStream(f_in);
		RSAPublicKey pbk = (RSAPublicKey) o_in.readObject();
		BigInteger e = pbk.getPublicExponent();//���ش˹�Կ��ָ��
		BigInteger n = pbk.getModulus();//���ش˹�Կ��ģ
		System.out.println("��Կ��ָ�� e= " + e);
		System.out.println("��Կ��ģ n= " + n);
		// ���� bit
		byte bt[] = string.getBytes("UTF8");
		BigInteger bit = new BigInteger(bt);
		// ��������c,��ӡ
		BigInteger mi = bit.modPow(e, n);//��������
		System.out.println("��������Ϊ�� " + mi+"\n\n");//��ӡ����
		// ��������
		String save = mi.toString();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("D:/temp/Enc_RSA.dat")));
		out.write(save, 0, save.length());
		out.close();
		
	}

	
}

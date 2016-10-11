import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
public class RSAEncryption{
public static void main(String args[]) throws Exception {
		System.out.println("����˽Կ�ƽ����ģ�"+"\n");
		// ��ȡ����
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("D:/temp/Enc_RSA.dat")));
		String ctext = in.readLine();
		BigInteger mi = new BigInteger(ctext);
		// ��ȡ˽Կ
		FileInputStream f = new FileInputStream("D:/temp/Skey_RSA_priv.dat");
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPrivateKey prk = (RSAPrivateKey) b.readObject();
		BigInteger d = prk.getPrivateExponent();//���ش�˽Կ��ָ��
		BigInteger n = prk.getModulus();//���ش�˽Կ��ģ
		System.out.println("˽Կ��ָ�� d= " + d);
		System.out.println("˽Կ��ģ n= " + n);
		BigInteger jie = mi.modPow(d, n);//���н��ܲ���
		System.out.println("m= " + jie);	// ��ʾ���ܽ��
		byte[] mt = jie.toByteArray();
		System.out.println("���ܺ���ı�����Ϊ�� ");
		for (int i = 0; i < mt.length; i++) {
			System.out.print((char) mt[i]);
		}

	}
}
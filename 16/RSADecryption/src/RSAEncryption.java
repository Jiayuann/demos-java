import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
public class RSAEncryption{
public static void main(String args[]) throws Exception {
		System.out.println("根据私钥破解密文："+"\n");
		// 读取密文
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("D:/temp/Enc_RSA.dat")));
		String ctext = in.readLine();
		BigInteger mi = new BigInteger(ctext);
		// 读取私钥
		FileInputStream f = new FileInputStream("D:/temp/Skey_RSA_priv.dat");
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPrivateKey prk = (RSAPrivateKey) b.readObject();
		BigInteger d = prk.getPrivateExponent();//返回此私钥的指数
		BigInteger n = prk.getModulus();//返回此私钥的模
		System.out.println("私钥的指数 d= " + d);
		System.out.println("私钥的模 n= " + n);
		BigInteger jie = mi.modPow(d, n);//进行解密操作
		System.out.println("m= " + jie);	// 显示解密结果
		byte[] mt = jie.toByteArray();
		System.out.println("解密后的文本内容为： ");
		for (int i = 0; i < mt.length; i++) {
			System.out.print((char) mt[i]);
		}

	}
}
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

	public RSAEncryption() throws Exception {// 构造方法 创建公钥和私钥
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");//生成实现RSA算法的KeyPairGenerator对象。
		kpg.initialize(1024);// 初始化确定密钥的大小	
		KeyPair kp = kpg.genKeyPair();// 生成密钥对
		PublicKey pbkey = kp.getPublic();// 创建公钥
		PrivateKey prkey = kp.getPrivate();// 创建私钥
		// 保存公钥
		FileOutputStream file1 = new FileOutputStream("D:/temp/Skey_RSA_pub.dat");
		ObjectOutputStream ob1 = new ObjectOutputStream(file1);//创建ObjectOutputStream对象
		ob1.writeObject(pbkey); //将指定的对象写入 ObjectOutputStream。
		// 保存私钥
		FileOutputStream file2 = new FileOutputStream("D:/temp/Skey_RSA_priv.dat");
		ObjectOutputStream ob2 = new ObjectOutputStream(file2);
		ob2.writeObject(prkey);

	}

	public static void Encryption_RSA() throws Exception {
		System.out.println("根据公钥生成密文："+"\n");
		String string = "I love Java !";
		// 获取公钥及参数e,n
		FileInputStream f_in = new FileInputStream("D:/temp/Skey_RSA_pub.dat");
		ObjectInputStream o_in = new ObjectInputStream(f_in);
		RSAPublicKey pbk = (RSAPublicKey) o_in.readObject();
		BigInteger e = pbk.getPublicExponent();//返回此公钥的指数
		BigInteger n = pbk.getModulus();//返回此公钥的模
		System.out.println("公钥的指数 e= " + e);
		System.out.println("公钥的模 n= " + n);
		// 明文 bit
		byte bt[] = string.getBytes("UTF8");
		BigInteger bit = new BigInteger(bt);
		// 计算密文c,打印
		BigInteger mi = bit.modPow(e, n);//生成密文
		System.out.println("生成密文为： " + mi+"\n\n");//打印密文
		// 保存密文
		String save = mi.toString();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("D:/temp/Enc_RSA.dat")));
		out.write(save, 0, save.length());
		out.close();
		
	}

	
}

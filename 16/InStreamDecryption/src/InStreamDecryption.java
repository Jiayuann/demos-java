import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class InStreamDecryption {
	public static void main(String args[]) throws Exception {
		// 生成密钥
		FileInputStream f = new FileInputStream("key1.dat");
		ObjectInputStream ob = new ObjectInputStream(f);
		Key k = (Key) ob.readObject();
		Cipher cp = Cipher.getInstance("DESede");// 创建密码器
		cp.init(Cipher.DECRYPT_MODE, k);// 初始化密码器
		FileInputStream in = new FileInputStream("InStreamEncryption.dat");// 获取要解密的文件
		CipherInputStream cin = new CipherInputStream(in, cp);// 创建CipherInputStream对象
		int b = 0;
		System.out.println("对文件输入流解密的原文如下：");
		while ((b = cin.read()) != -1) {// 读取输入流
			System.out.print((char) b );
		}
	}
}

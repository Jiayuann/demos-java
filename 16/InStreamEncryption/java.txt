import java.io.*;
import java.security.*;
import javax.crypto.*;
public class InStreamEncryption {
	public static void main(String args[]) throws Exception {
		// 生成密钥
		FileInputStream f = new FileInputStream("key1.dat");
		ObjectInputStream ob = new ObjectInputStream(f);
		Key k = (Key) ob.readObject();
		Cipher cp = Cipher.getInstance("DESede");// 创建密码器
		cp.init(Cipher.ENCRYPT_MODE, k);// 初始化密码器
		FileInputStream in = new FileInputStream("java.txt");// 创建要加密的输入流
		CipherInputStream cin = new CipherInputStream(in, cp);// 创建CipherInputStream对象
		int b = 0;
		int i = 1;
		FileOutputStream out = new FileOutputStream("InStreamEncryption.dat");//将密文保存到指定的文件中
		System.out.println("对文件输入流加密的密文如下：");
		while ((b = cin.read()) != -1) {// 读取输入流
			System.out.print((byte) b + "  ");
			out.write(b);
			i++;
			if (i % 20 == 0)
				System.out.println();// 打印格式控制
		}
	}

}

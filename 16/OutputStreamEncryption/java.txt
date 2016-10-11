import java.io.*;
import java.security.*;
import javax.crypto.*;
public class OutputStreamEncryption {
	public static void main(String args[]) throws Exception {
		FileInputStream fis = new FileInputStream("key1.dat");// 获取密钥
		ObjectInputStream ois = new ObjectInputStream(fis);
		Key key = (Key) ois.readObject();// 生成密钥
		Cipher cp = Cipher.getInstance("DESede");// 创建密码器
		cp.init(Cipher.ENCRYPT_MODE, key);// 初始化密码器
		FileInputStream in = new FileInputStream("java.txt");// 获取需加密的文件
		FileOutputStream out = new FileOutputStream("Out_java.dat");// 指定读出密文的文件
		CipherOutputStream cout = new CipherOutputStream(out, cp);// 创建CipherOutputStream对象
		int b = 0;
		int i = 1;
		System.out.println("对文件输出流加密的密文如下：");
		while ((b = in.read()) != -1) {// 写出流
			cout.write(b);
			System.out.print((byte) b + "  ");
			i++;
			if (i % 20 == 0)
				System.out.println();// 打印格式控制
		}
		// 关闭流
		cout.close();
		out.close();
		in.close();
	}

}

import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class CBCDecryption {
	public static void main(String args[]) throws Exception {
		String path = System.getProperty("user.dir") + "//key1.dat"; // 得到密钥的路径
		FileInputStream in = new FileInputStream("EncCBC.dat");// 获取密文
		byte[] rand = new byte[8];
		in.read(rand);
		IvParameterSpec iv = new IvParameterSpec(rand);// 获取初始向量
		int num = in.available();
		byte[] ctext = new byte[num];
		in.read(ctext);
		FileInputStream in1 = new FileInputStream(path);// 获取密钥
		ObjectInputStream b = new ObjectInputStream(in1);
		Key k = (Key) b.readObject();
		// 获取密码器，执行加密
		Cipher cp = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cp.init(Cipher.DECRYPT_MODE, k, iv);
		byte[] ptext = cp.doFinal(ctext);
		String str = new String(ptext, "UTF8");
		System.out.println("CBC解密后的字符串为：");
		System.out.println(str);
	}

}

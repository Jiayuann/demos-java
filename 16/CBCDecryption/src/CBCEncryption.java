import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class CBCEncryption {
	public static void main(String args[]) throws Exception {
		String s = "欢迎来到Java世界！";
		String path = System.getProperty("user.dir") + "//key1.dat"; // 得到密钥的路径
		FileInputStream f1 = new FileInputStream(path);// 获取密钥
		ObjectInputStream b = new ObjectInputStream(f1);// 创建对象输入流
		Key k = (Key) b.readObject();// 从 ObjectInputStream 读取对象
		// 生成初始化向量
		byte[] rand = new byte[8];
		Random r = new Random();// 创建随机数生成器
		r.nextBytes(rand);// 生成随机字节并将其置于rand字节数组中
		IvParameterSpec iv = new IvParameterSpec(rand);// 使用 rand中的字节作为 IV
		// 来初始化一个IvParameterSpec对象。
		// 加密
		Cipher cp = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cp.init(Cipher.ENCRYPT_MODE, k, iv);
		byte ptext[] = s.getBytes("UTF8");	
		byte ctext[] = cp.doFinal(ptext);
		// 打印加密结果
		System.out.println("输出加密结果为：");
		for (int i = 0; i < ctext.length; i++) {
			System.out.print(ctext[i] + ",");
			if ((i + 1) % 5 == 0)
				System.out.println();
		}
		// 保存加密结果
		FileOutputStream f2 = new FileOutputStream("EncCBC.dat");
		f2.write(rand);
		f2.write(ctext);
	}
}

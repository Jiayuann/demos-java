//创建 对称密钥
import java.io.*;
import javax.crypto.*;
public class Symmetric_key {
	public static void main(String args[]) throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("DESede");//	获取密钥生成器
		kg.init(168);//	初始化密钥生成器
		SecretKey sk = kg.generateKey();//生成密钥
		FileOutputStream fos = new FileOutputStream("key1.dat");//将密钥保存在key1.dat文件中
		ObjectOutputStream b = new ObjectOutputStream(fos);
		b.writeObject(sk);
	}
}

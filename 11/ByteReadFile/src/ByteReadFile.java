import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class ByteReadFile {//操作运用多种方式读取文件的类
	public static void readFileByBytes(String fileName){//以字节为单位读取文件
		File file = new File(fileName);//创建文件
		InputStream in = null;
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节：");
			in = new FileInputStream(file);//将文件放入文件输入流中
			int tempbyte;
			while ((tempbyte = in.read()) != -1){	//一次读一个字节,循环将内容读出来
				System.out.write(tempbyte);
			}
			in.close();//关闭文件输入流
		} catch (IOException e) {//捕获异常
			e.printStackTrace();
			return;
		}
		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节：");
			// 一次读多个字节
			byte[] tempbytes = new byte[100];//声明长度为100的字节数组
			int byteread = 0;
			in = new FileInputStream(fileName);//将文件放入文件输入流中
			ByteReadFile.showAvailableBytes(in);////显示输入流中还剩的字节数
			// 读入多个字节到字节数组中，byteread为一次读入的字节数
			while ((byteread = in.read(tempbytes)) != -1){//一次读多个字节,循环将内容读出来
				System.out.write(tempbytes, 0, byteread);
			}
		} catch (Exception e1) {//捕获异常
			e1.printStackTrace();
		} finally {//内容总执行
			if (in != null) {
				try {
					in.close();//确保文件输入流关闭
				} catch (IOException e1) {
				}
			}
		}
	}
	private static void showAvailableBytes(InputStream in){//显示输入流中还剩的字节数
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {//捕获异常
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String fileName = "D:/text.txt";
		System.out.println("按字节为单位读取文件：");
		readFileByBytes(fileName);
	}
}

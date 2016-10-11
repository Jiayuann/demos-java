import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ShowCharacter {
	public static void main(String[] args) throws IOException {
		try {
			RandomAccessFile rf = new RandomAccessFile("D:\\test.txt", "r");
			// 创建一个RandomAccessFile类对象
			long count = Long.valueOf('i').longValue();
			// 由命令行参数传入一个数字count，表示显示文件中最后的count个字符
			long pos = rf.length();// 返回文件的长度
			pos -= count;
			if (pos < 0)
				pos = 0;
			rf.seek(pos);// 将指针移动到文件尾
			while (true) {
				try {
					byte b = rf.readByte();// 读取一个字节
					System.out.print((char) b);// 将读取的字节转换成字符输出
				} catch (EOFException e) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

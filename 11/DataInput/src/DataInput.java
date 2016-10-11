import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class DataInput {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/test.dat");//创建一个文件
			DataOutputStream dos = new DataOutputStream(os);
			int k = 0, i = 1, j = 1;
			for (k = 0; k < 20; k++) {
				try {
					dos.writeInt(i);	//将一个 int 值以 4-byte 值形式写入基础输出流中，先写入高字节。
				} catch (IOException e) {
					e.printStackTrace();
				}
				int in = i + j;
				i = j;
				j = in;
			}
			try {
				os.close();			// 关闭文件输出流
			} catch (IOException e) {
				System.out.println(e);// 输出异常
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件创建成功！");
		}
	}
}

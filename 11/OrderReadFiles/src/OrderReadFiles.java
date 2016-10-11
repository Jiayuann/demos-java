import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderReadFiles {
	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("D:/test1.java");				// 创建文件字符输出流对象
			BufferedReader br = new BufferedReader(fr);	// 创建缓冲字符输出流对象
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

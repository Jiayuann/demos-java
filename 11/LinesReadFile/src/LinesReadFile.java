import java.io.BufferedReader;//引入类
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class LinesReadFile {//操作运用多种方式读取文件的类
	public static void readFileByLines(String fileName){//以行为单位读取文件
		File file = new File(fileName);
		BufferedReader reader = null;//创建缓存读取
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));//将文件放在缓存读取中
			String tempString = null;
			int line = 1;
			//一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null){
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {//捕获异常
			e.printStackTrace();
		} finally {//内容总执行
			if (reader != null) {
				try {
					reader.close();//关闭缓存读取
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String fileName = "D:/text.txt";
		System.out.println("按行为单位读取文件：");
		readFileByLines(fileName);
	}
}

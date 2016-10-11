import java.io.File;										//引入类
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
public class CharsWriteFile {								//操作多种方式写文件的类
	
	public static void writeFileByChars(String fileName){	//以字符为单位写文件。
		File file = new File(fileName);						//创建文件
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(
				new FileOutputStream(file));				// 打开文件输出流
			String content = "静夜思  床前明月光，疑是地上霜。" +
					" 举头望明月， 低头思故乡。";
			writer.write(content);							// 写入文件
			System.out.println("写文件" + file.getAbsolutePath() + "成功！");
		} catch (IOException e){
			System.out.println("写文件" + file.getAbsolutePath() + "失败！");
			e.printStackTrace();
		} finally {										//内容总执行
			if (writer != null){
				try {
					writer.close(); 						// 关闭输出文件流
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(String[] args) {				//java程序主入口处
		String fileName = "D:/text3.txt";
		System.out.println("以字符为单位写文件:");
		CharsWriteFile.writeFileByChars(fileName);			//调用方法写文件	
	}
}

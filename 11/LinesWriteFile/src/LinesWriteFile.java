import java.io.File;	
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class LinesWriteFile {								//操作多种方式写文件的类
	
	public static void writeFileByLines(String fileName){	//以行为单位写文件
		File file = new File(fileName);						//创建文件
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(
				new FileOutputStream(file));				// 打开文件输出流
			writer.println("静夜思 "+" 床前明月光，疑是地上霜。" +
					" 举头望明月， 低头思故乡。"); 				// 写字符串
			writer.print(true);								//写入布尔类型
			writer.print(123);								//写入整数类型
			writer.println(); 								// 换行
			writer.flush();									// 写入刷新文件
			System.out.println("写文件" + file.getAbsolutePath() + "成功！");
		} catch (FileNotFoundException e) {
			System.out.println("写文件" + file.getAbsolutePath() + "失败！");
			e.printStackTrace();
		} finally {										//内容总执行
			if (writer != null){
				writer.close(); 							// 关闭输出文件流
			}
		}
	}
	
	public static void main(String[] args) {				//java程序主入口处
		String fileName = "D:/text4.txt";
		System.out.println("以行为单位写文件:");
		LinesWriteFile.writeFileByLines(fileName);			//调用方法写文件
	}
}

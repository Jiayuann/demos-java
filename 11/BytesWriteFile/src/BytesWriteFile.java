import java.io.File;										//引入类
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class BytesWriteFile {								//操作多种方式写文件的类
	public static void writeFileByBytes(String fileName)	{//以字节为单位写文件
		File file = new File(fileName);						//创建一个文件
		OutputStream out= null;
		try {
			out = new FileOutputStream(file);				// 打开文件输出流
			String content = "静夜思  床前明月光， 疑是地上霜。" +
					" 举头望明月， 低头思故乡。";
			byte[] bytes = content.getBytes(); 				//读取输出流中的字节
			out.write(bytes);								// 写入文件
			System.out.println("写文件" + file.getAbsolutePath() + "成功！");
		} catch (IOException e){
			System.out.println("写文件" + file.getAbsolutePath() + "失败！");
			e.printStackTrace();
		} finally {										//内容总执行
			if (out != null){
				try {
					out.close(); 							// 关闭输出文件流
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(String[] args) {				//java程序主入口处
		String fileName = "D:/text2.txt";
		System.out.println("以字节为单位写文件:");
		BytesWriteFile.writeFileByBytes(fileName);			//调用方法写文件
	}
}

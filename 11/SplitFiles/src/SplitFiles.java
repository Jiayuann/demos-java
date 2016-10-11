import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class SplitFiles {
	public static final String SUFFIX = ".txt"; // 分割后的文件名后缀
	// 将指定的文件按着给定的文件的字节数进行分割文件，其中name指的是需要进行分割的文件名，size指的是指定的小文件的大小
	public static String[] divide(String name, long size) throws Exception {
		File file = new File(name);
		if (!file.exists() || (!file.isFile())) {
			throw new Exception("指定文件不存在！");
		}
		
		File parentFile = file.getParentFile();// 获得被分割文件父文件，将来被分割成的小文件便存在这个目录下
		
		long fileLength = file.length();// 取得文件的大小
		if (size <= 0) {
			size = fileLength / 2;
		}
		// 取得被分割后的小文件的数目
		int num = (fileLength % size != 0) ? (int) (fileLength / size + 1)
				: (int) (fileLength / size);
		
		String[] fileNames = new String[num];// 存放被分割后的小文件名
		
		FileInputStream in = new FileInputStream(file);// 输入文件流，即被分割的文件
		long end = 0;// 读输入文件流的开始和结束下标
		int begin = 0;
		
		for (int i = 0; i < num; i++) {// 根据要分割的数目输出文件
			// 对于前num - 1个小文件，大小都为指定的size
			File outFile = new File(parentFile, file.getName() + i + SUFFIX);
			
			FileOutputStream out = new FileOutputStream(outFile);// 构建小文件的输出流
			
			end += size;// 将结束下标后移size
			end = (end > fileLength) ? fileLength : end;
			
			for (; begin < end; begin++) {// 从输入流中读取字节存储到输出流中
				out.write(in.read());
			}
			out.close();
			fileNames[i] = outFile.getAbsolutePath();
		}
		in.close();
		return fileNames;
	}
	public static void readFileMessage(String fileName) {// 将分割成的小文件中的内容读出
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String string = null;
			// 按行读取内容，直到读入null则表示读取文件结束
			while ((string = reader.readLine()) != null) {
				System.out.println(string);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(final String[] args) throws Exception {
		String name = "D:/热爱生活.txt";
		long size = 250;
		String[] fileNames = SplitFiles.divide(name, size);
		System.out.println("文件" + name + "分割的结果如下：");
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i] + "的内容如下：");
			SplitFiles.readFileMessage(fileNames[i]);
			System.out.println();
		}
	}
}

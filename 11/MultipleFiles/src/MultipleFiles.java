import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;

public class MultipleFiles implements Enumeration {
	String filesList[];// 创建一个字符串数组，装所有文件名的全路径
	int num = 0;	// 记载读取后文件的个数
	public MultipleFiles(String fileslist[]) {
		filesList = fileslist;
	}
	public boolean hasMoreElements() {// 判断是否有可提供使用的元素，有则返回true，否则返回false
		if (filesList == null)
			return false;
		if (num < filesList.length)
			return true;
		else
			return false;
	}
	public Object nextElement() {// 返回下一个可用的元素
		FileInputStream in = null;
		if (!hasMoreElements())
			return null;
		try {
			in = new FileInputStream(filesList[num]);// 将该元素加到输入流中
			++num;
		} catch (FileNotFoundException e) {
			System.err.println("打开文件" + filesList[num] + "错误！");
		}
		return in;
	}
	public static void main(String args[]) {
		MultipleFiles myList = new MultipleFiles(args);
		SequenceInputStream sin;
		FileOutputStream fout;
		int data;
		try {
			sin = new SequenceInputStream(myList);// 创建SequenceInputStream对象
			fout = new FileOutputStream(FileDescriptor.out);// 创建FileOutputStream对象
			while ((data = sin.read()) != -1) {
				fout.write(data);// 将输入流中的信息写出
			}
			sin.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件无法打开！");
		} catch (IOException e) {
			System.out.println("读写文件有误!");
		}
	}
}

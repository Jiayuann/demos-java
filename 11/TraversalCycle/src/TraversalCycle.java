import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TraversalCycle {
	public static void main(String[] args){
		int i=0;
		FileInputStream fis = null;
		try {
			fis=new FileInputStream("D:/test/file1.txt");			//指定一个文件
		} catch (FileNotFoundException e) {
			System.out.println("没有找到指定的文件。");  //如果没有找到文件，捕获异常
			System.exit(-1);
		}catch (ArrayIndexOutOfBoundsException e){
			System.exit(-2);
		}
		
		try {
			while((i=fis.read())!=-1) 					//循环遍历文件内容
				System.out.print((char)i);				//输出文件里的内容
			fis.close();
		} catch (IOException e) {
			System.out.println("显示文件名");
		}
	}
}

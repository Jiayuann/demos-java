import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TraversalCycle {
	public static void main(String[] args){
		int i=0;
		FileInputStream fis = null;
		try {
			fis=new FileInputStream("D:/test/file1.txt");			//ָ��һ���ļ�
		} catch (FileNotFoundException e) {
			System.out.println("û���ҵ�ָ�����ļ���");  //���û���ҵ��ļ��������쳣
			System.exit(-1);
		}catch (ArrayIndexOutOfBoundsException e){
			System.exit(-2);
		}
		
		try {
			while((i=fis.read())!=-1) 					//ѭ�������ļ�����
				System.out.print((char)i);				//����ļ��������
			fis.close();
		} catch (IOException e) {
			System.out.println("��ʾ�ļ���");
		}
	}
}

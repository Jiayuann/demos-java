import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderReadFiles {
	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("D:/test1.java");				// �����ļ��ַ����������
			BufferedReader br = new BufferedReader(fr);	// ���������ַ����������
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

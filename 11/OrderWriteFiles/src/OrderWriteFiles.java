import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderWriteFiles {
	public static void main(String[] args) {
		FileWriter fw;
		try {
			fw = new FileWriter("D:/test1.java");				// �����ַ����������
			BufferedWriter bf = new BufferedWriter(fw);	// ���������ַ����������
			for (int i = 0; i < 10; i++) {					// ���ַ���д���ļ�
				bf.write("Java" + i+"\n");
			}
			bf.close();								// �رջ����ַ������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

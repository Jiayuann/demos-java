import java.io.BufferedReader;//������
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class LinesReadFile {//�������ö��ַ�ʽ��ȡ�ļ�����
	public static void readFileByLines(String fileName){//����Ϊ��λ��ȡ�ļ�
		File file = new File(fileName);
		BufferedReader reader = null;//���������ȡ
		try {
			System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
			reader = new BufferedReader(new FileReader(file));//���ļ����ڻ����ȡ��
			String tempString = null;
			int line = 1;
			//һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while ((tempString = reader.readLine()) != null){
				// ��ʾ�к�
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {//�����쳣
			e.printStackTrace();
		} finally {//������ִ��
			if (reader != null) {
				try {
					reader.close();//�رջ����ȡ
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String fileName = "D:/text.txt";
		System.out.println("����Ϊ��λ��ȡ�ļ���");
		readFileByLines(fileName);
	}
}

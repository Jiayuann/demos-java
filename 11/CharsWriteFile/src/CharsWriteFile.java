import java.io.File;										//������
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
public class CharsWriteFile {								//�������ַ�ʽд�ļ�����
	
	public static void writeFileByChars(String fileName){	//���ַ�Ϊ��λд�ļ���
		File file = new File(fileName);						//�����ļ�
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(
				new FileOutputStream(file));				// ���ļ������
			String content = "��ҹ˼  ��ǰ���¹⣬���ǵ���˪��" +
					" ��ͷ�����£� ��ͷ˼���硣";
			writer.write(content);							// д���ļ�
			System.out.println("д�ļ�" + file.getAbsolutePath() + "�ɹ���");
		} catch (IOException e){
			System.out.println("д�ļ�" + file.getAbsolutePath() + "ʧ�ܣ�");
			e.printStackTrace();
		} finally {										//������ִ��
			if (writer != null){
				try {
					writer.close(); 						// �ر�����ļ���
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(String[] args) {				//java��������ڴ�
		String fileName = "D:/text3.txt";
		System.out.println("���ַ�Ϊ��λд�ļ�:");
		CharsWriteFile.writeFileByChars(fileName);			//���÷���д�ļ�	
	}
}

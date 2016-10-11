import java.io.File;	
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class LinesWriteFile {								//�������ַ�ʽд�ļ�����
	
	public static void writeFileByLines(String fileName){	//����Ϊ��λд�ļ�
		File file = new File(fileName);						//�����ļ�
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(
				new FileOutputStream(file));				// ���ļ������
			writer.println("��ҹ˼ "+" ��ǰ���¹⣬���ǵ���˪��" +
					" ��ͷ�����£� ��ͷ˼���硣"); 				// д�ַ���
			writer.print(true);								//д�벼������
			writer.print(123);								//д����������
			writer.println(); 								// ����
			writer.flush();									// д��ˢ���ļ�
			System.out.println("д�ļ�" + file.getAbsolutePath() + "�ɹ���");
		} catch (FileNotFoundException e) {
			System.out.println("д�ļ�" + file.getAbsolutePath() + "ʧ�ܣ�");
			e.printStackTrace();
		} finally {										//������ִ��
			if (writer != null){
				writer.close(); 							// �ر�����ļ���
			}
		}
	}
	
	public static void main(String[] args) {				//java��������ڴ�
		String fileName = "D:/text4.txt";
		System.out.println("����Ϊ��λд�ļ�:");
		LinesWriteFile.writeFileByLines(fileName);			//���÷���д�ļ�
	}
}

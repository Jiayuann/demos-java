import java.io.File;										//������
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class BytesWriteFile {								//�������ַ�ʽд�ļ�����
	public static void writeFileByBytes(String fileName)	{//���ֽ�Ϊ��λд�ļ�
		File file = new File(fileName);						//����һ���ļ�
		OutputStream out= null;
		try {
			out = new FileOutputStream(file);				// ���ļ������
			String content = "��ҹ˼  ��ǰ���¹⣬ ���ǵ���˪��" +
					" ��ͷ�����£� ��ͷ˼���硣";
			byte[] bytes = content.getBytes(); 				//��ȡ������е��ֽ�
			out.write(bytes);								// д���ļ�
			System.out.println("д�ļ�" + file.getAbsolutePath() + "�ɹ���");
		} catch (IOException e){
			System.out.println("д�ļ�" + file.getAbsolutePath() + "ʧ�ܣ�");
			e.printStackTrace();
		} finally {										//������ִ��
			if (out != null){
				try {
					out.close(); 							// �ر�����ļ���
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(String[] args) {				//java��������ڴ�
		String fileName = "D:/text2.txt";
		System.out.println("���ֽ�Ϊ��λд�ļ�:");
		BytesWriteFile.writeFileByBytes(fileName);			//���÷���д�ļ�
	}
}

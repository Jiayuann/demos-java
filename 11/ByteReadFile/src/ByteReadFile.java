import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class ByteReadFile {//�������ö��ַ�ʽ��ȡ�ļ�����
	public static void readFileByBytes(String fileName){//���ֽ�Ϊ��λ��ȡ�ļ�
		File file = new File(fileName);//�����ļ�
		InputStream in = null;
		try {
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
			in = new FileInputStream(file);//���ļ������ļ���������
			int tempbyte;
			while ((tempbyte = in.read()) != -1){	//һ�ζ�һ���ֽ�,ѭ�������ݶ�����
				System.out.write(tempbyte);
			}
			in.close();//�ر��ļ�������
		} catch (IOException e) {//�����쳣
			e.printStackTrace();
			return;
		}
		try {
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
			// һ�ζ�����ֽ�
			byte[] tempbytes = new byte[100];//��������Ϊ100���ֽ�����
			int byteread = 0;
			in = new FileInputStream(fileName);//���ļ������ļ���������
			ByteReadFile.showAvailableBytes(in);////��ʾ�������л�ʣ���ֽ���
			// �������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���
			while ((byteread = in.read(tempbytes)) != -1){//һ�ζ�����ֽ�,ѭ�������ݶ�����
				System.out.write(tempbytes, 0, byteread);
			}
		} catch (Exception e1) {//�����쳣
			e1.printStackTrace();
		} finally {//������ִ��
			if (in != null) {
				try {
					in.close();//ȷ���ļ��������ر�
				} catch (IOException e1) {
				}
			}
		}
	}
	private static void showAvailableBytes(InputStream in){//��ʾ�������л�ʣ���ֽ���
		try {
			System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());
		} catch (IOException e) {//�����쳣
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String fileName = "D:/text.txt";
		System.out.println("���ֽ�Ϊ��λ��ȡ�ļ���");
		readFileByBytes(fileName);
	}
}

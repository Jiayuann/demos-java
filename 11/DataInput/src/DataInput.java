import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class DataInput {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/test.dat");//����һ���ļ�
			DataOutputStream dos = new DataOutputStream(os);
			int k = 0, i = 1, j = 1;
			for (k = 0; k < 20; k++) {
				try {
					dos.writeInt(i);	//��һ�� int ֵ�� 4-byte ֵ��ʽд�����������У���д����ֽڡ�
				} catch (IOException e) {
					e.printStackTrace();
				}
				int in = i + j;
				i = j;
				j = in;
			}
			try {
				os.close();			// �ر��ļ������
			} catch (IOException e) {
				System.out.println(e);// ����쳣
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ɹ���");
		}
	}
}

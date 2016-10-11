import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ShowCharacter {
	public static void main(String[] args) throws IOException {
		try {
			RandomAccessFile rf = new RandomAccessFile("D:\\test.txt", "r");
			// ����һ��RandomAccessFile�����
			long count = Long.valueOf('i').longValue();
			// �������в�������һ������count����ʾ��ʾ�ļ�������count���ַ�
			long pos = rf.length();// �����ļ��ĳ���
			pos -= count;
			if (pos < 0)
				pos = 0;
			rf.seek(pos);// ��ָ���ƶ����ļ�β
			while (true) {
				try {
					byte b = rf.readByte();// ��ȡһ���ֽ�
					System.out.print((char) b);// ����ȡ���ֽ�ת�����ַ����
				} catch (EOFException e) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

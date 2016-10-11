import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;

public class MultipleFiles implements Enumeration {
	String filesList[];// ����һ���ַ������飬װ�����ļ�����ȫ·��
	int num = 0;	// ���ض�ȡ���ļ��ĸ���
	public MultipleFiles(String fileslist[]) {
		filesList = fileslist;
	}
	public boolean hasMoreElements() {// �ж��Ƿ��п��ṩʹ�õ�Ԫ�أ����򷵻�true�����򷵻�false
		if (filesList == null)
			return false;
		if (num < filesList.length)
			return true;
		else
			return false;
	}
	public Object nextElement() {// ������һ�����õ�Ԫ��
		FileInputStream in = null;
		if (!hasMoreElements())
			return null;
		try {
			in = new FileInputStream(filesList[num]);// ����Ԫ�ؼӵ���������
			++num;
		} catch (FileNotFoundException e) {
			System.err.println("���ļ�" + filesList[num] + "����");
		}
		return in;
	}
	public static void main(String args[]) {
		MultipleFiles myList = new MultipleFiles(args);
		SequenceInputStream sin;
		FileOutputStream fout;
		int data;
		try {
			sin = new SequenceInputStream(myList);// ����SequenceInputStream����
			fout = new FileOutputStream(FileDescriptor.out);// ����FileOutputStream����
			while ((data = sin.read()) != -1) {
				fout.write(data);// ���������е���Ϣд��
			}
			sin.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ��޷��򿪣�");
		} catch (IOException e) {
			System.out.println("��д�ļ�����!");
		}
	}
}

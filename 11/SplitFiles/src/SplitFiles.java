import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class SplitFiles {
	public static final String SUFFIX = ".txt"; // �ָ����ļ�����׺
	// ��ָ�����ļ����Ÿ������ļ����ֽ������зָ��ļ�������nameָ������Ҫ���зָ���ļ�����sizeָ����ָ����С�ļ��Ĵ�С
	public static String[] divide(String name, long size) throws Exception {
		File file = new File(name);
		if (!file.exists() || (!file.isFile())) {
			throw new Exception("ָ���ļ������ڣ�");
		}
		
		File parentFile = file.getParentFile();// ��ñ��ָ��ļ����ļ����������ָ�ɵ�С�ļ���������Ŀ¼��
		
		long fileLength = file.length();// ȡ���ļ��Ĵ�С
		if (size <= 0) {
			size = fileLength / 2;
		}
		// ȡ�ñ��ָ���С�ļ�����Ŀ
		int num = (fileLength % size != 0) ? (int) (fileLength / size + 1)
				: (int) (fileLength / size);
		
		String[] fileNames = new String[num];// ��ű��ָ���С�ļ���
		
		FileInputStream in = new FileInputStream(file);// �����ļ����������ָ���ļ�
		long end = 0;// �������ļ����Ŀ�ʼ�ͽ����±�
		int begin = 0;
		
		for (int i = 0; i < num; i++) {// ����Ҫ�ָ����Ŀ����ļ�
			// ����ǰnum - 1��С�ļ�����С��Ϊָ����size
			File outFile = new File(parentFile, file.getName() + i + SUFFIX);
			
			FileOutputStream out = new FileOutputStream(outFile);// ����С�ļ��������
			
			end += size;// �������±����size
			end = (end > fileLength) ? fileLength : end;
			
			for (; begin < end; begin++) {// ���������ж�ȡ�ֽڴ洢���������
				out.write(in.read());
			}
			out.close();
			fileNames[i] = outFile.getAbsolutePath();
		}
		in.close();
		return fileNames;
	}
	public static void readFileMessage(String fileName) {// ���ָ�ɵ�С�ļ��е����ݶ���
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String string = null;
			// ���ж�ȡ���ݣ�ֱ������null���ʾ��ȡ�ļ�����
			while ((string = reader.readLine()) != null) {
				System.out.println(string);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	public static void main(final String[] args) throws Exception {
		String name = "D:/�Ȱ�����.txt";
		long size = 250;
		String[] fileNames = SplitFiles.divide(name, size);
		System.out.println("�ļ�" + name + "�ָ�Ľ�����£�");
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i] + "���������£�");
			SplitFiles.readFileMessage(fileNames[i]);
			System.out.println();
		}
	}
}

import java.io.File;
import java.io.IOException;//������
public class CreateFileAndDir {//�������ļ���Ŀ¼
	public static boolean createFile(String filePath) {//���������ļ�
		File file = new File(filePath);
		if (file.exists()) {//�ж��ļ��Ƿ����
			System.out.println("Ŀ���ļ��Ѵ���"+filePath);
			return false;
		}
		if (filePath.endsWith(File.separator)) {//�ж��ļ��Ƿ�ΪĿ¼
			System.out.println("Ŀ���ļ�����ΪĿ¼��");
			return false;
		}
		if (!file.getParentFile().exists()) {// �ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
			// ���Ŀ���ļ����ڵ��ļ��в����ڣ��򴴽����ļ���
			System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
			if (!file.getParentFile().mkdirs()) {//�жϴ���Ŀ¼�Ƿ�ɹ�
				System.out.println("����Ŀ���ļ����ڵ�Ŀ¼ʧ�ܣ�");
				return false;
			}
		}
		try {
			if (file.createNewFile()) {//����Ŀ���ļ�
				System.out.println("�����ļ��ɹ�:"+filePath);
				return true;
			} else {
				System.out.println("�����ļ�ʧ�ܣ�");
				return false;
			}
		} catch (IOException e) {//�����쳣
			e.printStackTrace();
			System.out
					.println("�����ļ�ʧ�ܣ�" + e.getMessage());
			return false;
		}
	}
	public static boolean createDir(String destDirName) {//����Ŀ¼
		File dir = new File(destDirName);
		if (dir.exists()) {//�ж�Ŀ¼�Ƿ����
			System.out.println("����Ŀ¼ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {//��β�Ƿ���"/"����
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// ����Ŀ��Ŀ¼
			System.out.println("����Ŀ¼�ɹ���"+destDirName);
			return true;
		} else {
			System.out.println("����Ŀ¼ʧ�ܣ�");
			return false;
		}
	}
	public static String createTempFile(String prefix, String suffix,
			String dirName) {//������ʱ�ļ�
		File tempFile = null;
		if (dirName == null) {//Ŀ¼���Ϊ��
			try {
				tempFile = File.createTempFile(prefix, suffix);//��Ĭ���ļ����´�����ʱ�ļ�
				return tempFile.getCanonicalPath();// ������ʱ�ļ���·��
			} catch (IOException e) {//�����쳣
				e.printStackTrace();
				System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage());
				return null;
			}
		} else {//ָ��Ŀ¼����
			File dir = new File(dirName);//����Ŀ¼
			if (!dir.exists()) {//���Ŀ¼�������򴴽�Ŀ¼
				if (CreateFileAndDir.createDir(dirName)) {
					System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ����ڵ�Ŀ¼��");
					return null;
				}
			}
			try {
				tempFile = File.createTempFile(prefix, suffix, dir);// ��ָ��Ŀ¼�´�����ʱ�ļ�
				return tempFile.getCanonicalPath();//������ʱ�ļ���·��
			} catch (IOException e) {//�����쳣
				e.printStackTrace();
				System.out.println("������ʱ�ļ�ʧ��!" + e.getMessage());
				return null;
			}
		}
	}

	public static void main(String[] args) {//java���������ڴ�
		String dirName = "D:/createFile/";// ����Ŀ¼
	    CreateFileAndDir.createDir(dirName);//���÷�������Ŀ¼
		String fileName = dirName + "/file1.txt";// �����ļ�
		CreateFileAndDir.createFile(fileName);//���÷��������ļ�
		String prefix = "temp";// ������ʱ�ļ�
		String surfix = ".txt";//��׺
		for (int i = 0; i < 10; i++) {//ѭ����������ļ�
			System.out.println("������ʱ�ļ�: "//���÷���������ʱ�ļ�
					+ CreateFileAndDir.createTempFile(prefix, surfix, dirName));
		}
	}
}


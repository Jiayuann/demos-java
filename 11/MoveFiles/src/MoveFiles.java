import java.io.File;
public class MoveFiles {
	// �ƶ�ĳ��ָ�����ļ������ƶ��ɹ��󲻻Ḳ���Ѵ��ڵ�Ŀ���ļ�
	public static boolean moveA_File(String sourceFileName,
			String targetFileName) {
		return MoveFiles.moveA_File(sourceFileName, targetFileName, false);
	}
	// �ƶ�ĳ��ָ�����ļ������ƶ��ɹ�����Ը���isOverlay��ֵ�������Ƿ񸲸��Ѵ��ڵ�Ŀ���ļ�
	public static boolean moveA_File(String sourceFileName,
			String targetFileName, boolean isOverlay) {
		// �ж�ԭ�ļ��Ƿ����
		File sourceFile = new File(sourceFileName);
		if (!sourceFile.exists()) {
			System.out.println("�ƶ��ļ�ʧ�ܣ�ԭ�ļ�" + sourceFileName + "�����ڣ�");
			return false;
		} else if (!sourceFile.isFile()) {
			System.out.println("�ƶ��ļ�ʧ�ܣ�" + sourceFileName + "����һ���ļ���");
			return false;
		}
		File targetFile = new File(targetFileName);
		if (targetFile.exists()) {// �ж�Ŀ���ļ��Ƿ����
			if (isOverlay) {// ���Ŀ���ļ����ڣ��Ƿ�������Ŀ���ļ�
				// ɾ���Ѵ��ڵ�Ŀ���ļ�������Ŀ���ļ���Ŀ¼���ǵ����ļ�
				System.out.println("���ļ��Ѵ��ڣ�׼��ɾ������");
				if (!DeleteFile.deleteAnyone(targetFileName)) {
					System.out.println("�ļ��ƶ�ʧ�ܣ�ɾ���ļ�" + targetFileName + "ʧ�ܣ�");
					return false;
				}
			} else {
				System.out.println("�ļ��ƶ�ʧ�ܣ��ļ�" + targetFileName + "�Ѵ��ڣ�");
				return false;
			}
		} else {
			if (!targetFile.getParentFile().exists()) {
				// ���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽�Ŀ¼
				System.out.println("���ļ�����Ŀ¼�����ڣ����ڴ�����");
				if (!targetFile.getParentFile().mkdirs()) {
					System.out.println("�ƶ��ļ�ʧ�ܣ������ļ����ڵ�Ŀ¼ʧ�ܣ�");
					return false;
				}
			}
		}
		// �ƶ�ԭ�ļ���Ŀ���ļ�
		if (sourceFile.renameTo(targetFile)) {
			System.out.println("�ƶ��ļ�" + sourceFileName + "��" + targetFileName
					+ "�ɹ���");
			return true;
		} else {
			System.out.println("�ƶ��ļ�" + sourceFileName + "��" + targetFileName
					+ "ʧ�ܣ�");
			return true;
		}
	}
	public static boolean moveDir(String sourceDirName, String targetDirName) {
		// Ĭ��Ϊ������Ŀ���ļ�
		return MoveFiles.moveDir(sourceDirName, targetDirName, false);
	}
	// �ƶ�ĳ��ָ����Ŀ¼�����ƶ��ɹ�����Ը���isOverlay��ֵ�������Ƿ񸲸ǵ�ǰ�Ѵ��ڵ�Ŀ��Ŀ¼
	public static boolean moveDir(String sourceDirName, String targetDirName,
			boolean isOverlay) {
		// �ж�ԭĿ¼�Ƿ����
		File sourceDir = new File(sourceDirName);
		if (!sourceDir.exists()) {
			System.out.println("�ƶ�Ŀ¼ʧ�ܣ�ԭʼĿ¼" + sourceDirName + "�����ڣ�");
			return false;
		} else if (!sourceDir.isDirectory()) {
			System.out.println("�ƶ�Ŀ¼ʧ�ܣ�" + sourceDirName + "����һ��Ŀ¼��");
			return false;
		}
		// ���Ŀ���ļ����������ļ��ָ�����β���Զ�����ļ��ָ���
		if (!targetDirName.endsWith(File.separator)) {
			targetDirName = targetDirName + File.separator;
		}
		File targetDir = new File(targetDirName);
		// ���Ŀ���ļ��д��ڣ�
		if (targetDir.exists()) {
			if (isOverlay) {
				// ��������ɾ���Ѵ��ڵ�Ŀ��Ŀ¼
				System.out.println("��Ŀ¼�Ѵ��ڣ�׼��ɾ������");
				if (!DeleteFile.deleteAnyone(targetDirName)) {
					System.out.println("�ƶ�Ŀ¼ʧ�ܣ�ɾ��Ŀ¼" + targetDirName + "ʧ�ܣ�");
				}
			} else {
				System.out.println("�ƶ�Ŀ¼ʧ�ܣ���Ŀ¼" + targetDirName + "�Ѵ��ڣ�");
				return false;
			}
		} else {
			// ����Ŀ��Ŀ¼
			System.out.println("��Ŀ¼�����ڣ����ڴ�����");
			if (!targetDir.mkdirs()) {
				System.out.println("�ƶ�Ŀ¼ʧ�ܣ�������Ŀ¼ʧ�ܣ�");
				return false;
			}
		}
		boolean flag = true;
		// �ƶ�ԭĿ¼�µ��ļ�����Ŀ¼��Ŀ��Ŀ¼��
		File[] files = sourceDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// �ƶ����ļ�
			if (files[i].isFile()) {
				flag = MoveFiles.moveA_File(files[i].getAbsolutePath(),
						targetDirName + files[i].getName(), isOverlay);
				if (!flag) {
					break;
				}
			}
			// �ƶ���Ŀ¼
			else if (files[i].isDirectory()) {
				flag = MoveFiles.moveDir(files[i].getAbsolutePath(),
						targetDirName + files[i].getName(), isOverlay);
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("Ŀ¼" + sourceDirName + "�ƶ���" + targetDirName
					+ "ʧ�ܣ�");
			return false;
		}
		// ɾ��ԭĿ¼
		if (DeleteFile.deleteDir(sourceDirName)) {
			System.out.println("Ŀ¼" + sourceDirName + "�ƶ���" + targetDirName
					+ "�ɹ���");
			return true;
		} else {
			System.out.println("Ŀ¼" + sourceDirName + "�ƶ���" + targetDirName
					+ "ʧ�ܣ�");
			return false;
		}
	}
	public static void main(String[] args) {
		// �ƶ��ļ������Ŀ���ļ����ڣ����滻
		System.out.println("����moveA_File�����Ľ�����£�");
		String sourceFileName = "D:\\createFile\\file1.txt";
		String targetFileName = "D:\\test\\file1.txt.";
		MoveFiles.moveA_File(sourceFileName, targetFileName, true);
		// �ƶ�Ŀ¼�����Ŀ��Ŀ¼���ڣ��򲻸���
		System.out.println("\n����moveDir�����Ľ�����£�");
		String sourceDirName = "D:\\createFile\\dir";
		String targetDirName = "C:\\abc";
		MoveFiles.moveDir(sourceDirName, targetDirName);
	}
}

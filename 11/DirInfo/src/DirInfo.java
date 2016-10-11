import java.io.File;
import java.io.FilenameFilter;
public class DirInfo {
	static class MyFilenameFilter implements FilenameFilter {
		private String sf = ""; 					// �����ļ��ĺ�׺��
		public MyFilenameFilter(String surfix) {		// �ù��췽��Ϊsf������ֵ
			this.sf = surfix;
		}
		public boolean accept(File dir, String name) {	// ��дFilenameFilter�ӿ��е�accept�������ж�ָ�����ļ��Ƿ���ָ����Ŀ¼��
			if (new File(dir, name).isFile()) {			// �����ǰ��File������һ���ļ����򷵻����Ƿ���ָ���ĺ�׺�������Ƿ���true
				return name.endsWith(sf);
			} else {
				// ������ļ��У���ֱ�ӷ���true
				return true;
			}
		}
	}
	public static void getAllFiles(String dirName) {		// �г�ָ��Ŀ¼�������ļ�����Ŀ¼��·��
		// ���dir�����ļ��ָ�����β���Զ�����ļ��ָ�����
		if (!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		// ���dir��Ӧ���ļ������ڣ����߲���һ���ļ��У����˳�
		if (!dirFile.exists() || (!dirFile.isDirectory())) {
			System.out.println("ʧ�ܣ��Ҳ���ָ����Ŀ¼��" + dirName);
			return;
		}
		// �г�Դ�ļ����������ļ���������Ŀ¼��
		File[] fileArray = dirFile.listFiles();
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				System.out.print(fileArray[i].getAbsolutePath() + "      ");
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath() + "      ");
				DirInfo.getAllFiles(fileArray[i].getAbsolutePath());
			}
			if ((i + 1) % 2 == 0)
				System.out.println();
		}
	}
	public static void getFilesByFilter(FilenameFilter filter,// ��ȡ��ָ��Ŀ¼�·���ָ����׺�ļ����������ļ�
			String dir_Path) {
		if (!dir_Path.endsWith(File.separator)) {// ���Ŀ¼·���������ļ��ָ�����β���Զ�����ļ��ָ�����
			dir_Path = dir_Path + File.separator;
		}
		File dir_File = new File(dir_Path);
		if (!dir_File.exists() || (!dir_File.isDirectory())) {// ���ָ����Ŀ¼�����ڻ���һ��Ŀ¼�򷵻�
			System.out.println("ʧ�ܣ��Ҳ���ָ��Ŀ¼��" + dir_Path);
			return;
		}
		// �г�ָ��Ŀ¼�µ����з��Ϲ������������ļ���������Ŀ¼��
		File[] fileArray = dir_File.listFiles(filter);
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getAbsolutePath() + " ���ļ�!");
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath() + " ��Ŀ¼!");
				DirInfo.getFilesByFilter(filter, fileArray[i]
						.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		String dir = "D:\\createFile";
		System.out.println((dir + "Ŀ¼�µ�����: "));
		DirInfo.getAllFiles(dir);
		System.out.println();
		System.out.println("���Ϲ������������ļ����£�");
		// �½�һ���ļ���������������Ϊ".txt"
		FilenameFilter myFilenameFilter = new DirInfo.MyFilenameFilter(
				".txt");
		DirInfo.getFilesByFilter(myFilenameFilter, dir);
	}
}

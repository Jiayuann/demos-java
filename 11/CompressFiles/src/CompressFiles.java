import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class CompressFiles {
	// ѹ���ļ�����Ŀ¼�����У�dirPath��ѹ���ĸ�Ŀ¼��srcName��
	// dirPathĿ¼�µ������ļ�������Ŀ¼��targetName��ѹ�����zip�ļ�
	public static void compressAllZip(String dirPath, String srcName,
			String targetName) {
		if (dirPath == null) {// �жϸ�Ŀ¼�Ƿ����
			System.out.println("ѹ��ʧ��" + dirPath + "Ŀ¼������");
			return;
		}
		File baseDir = new File(dirPath);// �ж�dirPath�ǲ���Ŀ¼
		if (!baseDir.exists() || (!baseDir.isDirectory())) {
			System.out.println("ѹ��ʧ��" + dirPath + "Ŀ¼������");
			return;
		}
		String basicRootDir = baseDir.getAbsolutePath();
		File targetFile = new File(targetName);// ����zip�ļ�
		try {
			// ����һ��zip�������ѹ�����ݲ�д�뵽zip�ļ�
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					targetFile));
			if (srcName.equals("*")) {
				CompressFiles.compressDirToZip(basicRootDir, baseDir, out);// ��baseDirĿ¼�µ������ļ�ѹ����ZIP
			} else {
				File file = new File(baseDir, srcName);
				if (file.isFile()) {
					CompressFiles.compressFileToZip(basicRootDir, file, out);
				} else {
					CompressFiles.compressDirToZip(basicRootDir, file, out);
				}
			}
			out.close();
			System.out.println("�ļ�ѹ���ɹ���ѹ�������ļ���Ϊ��" + targetName);
		} catch (IOException e) {
			System.out.println("ѹ��ʧ�ܣ�" + e);
			e.printStackTrace();
		}
	}
	// ����ZipOutputStream��Ŀ¼��ѹ��
	private static void compressDirToZip(String basicRootDir, File dir,ZipOutputStream out) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();// �г�dirĿ¼�������ļ�
			if (files.length == 0) {// ����ǿ��ļ���
				ZipEntry entry = new ZipEntry(getFileName(basicRootDir, dir));// �洢Ŀ¼��Ϣ	
				try {
					out.putNextEntry(entry);
					out.closeEntry();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					// ������ļ�������compressFileToZip����
					CompressFiles.compressFileToZip(basicRootDir, files[i], out);
				} else {
					// �����Ŀ¼���ݹ����
					CompressFiles.compressDirToZip(basicRootDir, files[i], out);
				}
			}
		}
	}
	// ����ZipOutputStream���ļ���ѹ��
	private static void compressFileToZip(String basicRootDir, File file, ZipOutputStream out) {
		FileInputStream in = null;
		ZipEntry entry = null;
		byte[] buffer = new byte[4096];// �������ƻ�����
		int bytes_read;
		if (file.isFile()) {
			try {
				in = new FileInputStream(file); // ����һ���ļ�������
				// ����ѹ���ļ������ֹ���һ��ZipEntry���󣬴����ʾzip���е��ļ���Ŀ
				entry = new ZipEntry(getFileName(basicRootDir, file));
				out.putNextEntry(entry); // �洢����Ϣ��ѹ���ļ�
				// ���ļ�������ͨ���ֽ����鸴�Ƶ�ѹ���ļ���
				while ((bytes_read = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes_read);
				}
				out.closeEntry();
				in.close();
				System.out
						.println("����ļ�" + file.getAbsolutePath() + "��ZIP�ļ��У�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String getFileName(String basicRootDir, File file) {// ��ȡ�ȴ�ѹ�����ļ����ļ���
		if (!basicRootDir.endsWith(File.separator)) {
			basicRootDir += File.separator;
		}
		String filePath = file.getAbsolutePath();
		
		if (file.isDirectory()) {// ����Ŀ¼��������entry���ֺ������"/"����ʾ������Ŀ¼��洢
			filePath += "/";
		}
		int index = filePath.indexOf(basicRootDir);
		return filePath.substring(index + basicRootDir.length());
	}
	public static void main(String[] args) {
		// ѹ��D���µ�ͼƬĿ¼��ѹ������ļ���D:/ͼƬ/ͼƬ.zip
		String dirPath = "D:/";
		String srcName = "ͼƬ/";
		String zipFileName = "D:/ͼƬ/ͼƬ.zip";
		CompressFiles.compressAllZip(dirPath, srcName, zipFileName);
	}
}

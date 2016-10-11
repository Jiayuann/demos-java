import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DecompressFiles {
	public static void main(String[] args) {
		// ���մ�����ͼƬ.zip�ļ���ѹ����D�̵�tempĿ¼��
		String fileName = "D:/ͼƬ2";
		String zipName = "D:/ͼƬ/ͼƬ.zip";
		DecompressFiles.upzipFile(zipName, fileName);
	}
	// ��ָ����zip�ļ���ѹ��targetDirNameĿ¼�£����У�zipName��zip�����ļ�����targetDirName�����ѹ����Ŀ¼
	public static void upzipFile(String zipName, String targetDirName) {
		if (!targetDirName.endsWith(File.separator)) {
			targetDirName += File.separator;
		}
		try {
			
			ZipFile zipFile = new ZipFile(zipName);// ����zip�ļ�����ZipFile���󣬴���������Ǵ�zip�ļ���ȡ��Ŀ
			ZipEntry zn = null;
			String entryName = null;
			String targetFileName = null;
			byte[] buffer = new byte[4096];
			int bytes_read;
			Enumeration entrys = zipFile.entries();// ��ȡZIP�ļ������е��ļ���Ŀ������
			while (entrys.hasMoreElements()) {// ѭ���������е��ļ���Ŀ������
				zn = (ZipEntry) entrys.nextElement();
				
				entryName = zn.getName();// ���ÿһ���ļ�������
				targetFileName = targetDirName + entryName;
				if (zn.isDirectory()) {					
					new File(targetFileName).mkdirs();// ���zn��һ��Ŀ¼���򴴽�Ŀ¼
					continue;
				} else {					
					new File(targetFileName).getParentFile().mkdirs();// ���zn��һ���ļ����򴴽���Ŀ¼
				}				
				File targetFile = new File(targetFileName);// ���򴴽��ļ�
				System.out.println("���ڴ����ļ���" + targetFile.getAbsolutePath());				
				FileOutputStream os = new FileOutputStream(targetFile);// ���ļ������
				InputStream is = zipFile.getInputStream(zn);// ��ZipFile�����д�entry��������
				while ((bytes_read = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytes_read);
				}		
				os.close();// �ر���
				is.close();
			}
			System.out.println("��ѹ��"+zipName+"�ɹ���");
		} catch (IOException err) {
			System.err.println("��ѹ��"+zipName+"ʧ��: " + err);
		}
	}
}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class CopyFile {
	// �����ļ�,������Ƿ��Ƴɹ���������Ƴɹ����򷵻�true�����򷵻�false
	public static boolean copy_File(String sourceFileName,
			String targetFileName, boolean overlay) {
		// �ж�ԭ�ļ��Ƿ����
		File srcFile = new File(sourceFileName);
		if (!srcFile.exists()) {
			System.out.println("�����ļ�ʧ�ܣ�ԭ�ļ�" + sourceFileName + "�����ڣ�");
			return false;
		} else if (!srcFile.isFile()) {
			System.out.println("�����ļ�ʧ�ܣ�" + sourceFileName + "����һ���ļ���");
			return false;
		}
		// �ж�Ŀ���ļ��Ƿ����
		File targetFile = new File(targetFileName);
		if (targetFile.exists()) {
			// ���Ŀ���ļ��Ѵ����������ǣ� ɾ���Ѵ��ڵ�Ŀ���ļ�������Ŀ���ļ���Ŀ¼���ǵ����ļ�
			if (overlay) {
				System.out.println("�ļ��Ѵ��ڣ���ɾ����");
				if (!deleteAnyone(targetFileName)) {
					System.out.println("ɾ���ļ�" + targetFileName + "ʧ�ܣ�");
					return false;
				}
			} else {
				System.out.println("�����ļ�ʧ�ܣ��ļ�" + targetFileName + "�Ѵ��ڣ�");
				return false;
			}
		} else {
			if (!targetFile.getParentFile().exists()) {
				// ���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽�Ŀ¼
				System.out.println("Ŀ���ļ����ڵ�Ŀ¼�����ڣ�׼����������");
				if (!targetFile.getParentFile().mkdirs()) {
					System.out.println("�����ļ�ʧ�ܣ�����Ŀ���ļ����ڵ�Ŀ¼ʧ�ܣ�");
					return false;
				}
			}
		}
		int byteread = 0; // ��ȡ�ļ����ֽ���
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(srcFile); // ����ԭ�ļ���������
			out = new FileOutputStream(targetFile);// ����ԭ�ļ��������
			byte[] buffer = new byte[1024];
			// һ�ζ�ȡ1024���ֽڣ���bytereadΪ-1ʱ��ʾ�ļ��Ѿ�����
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread); // ����ȡ���ֽ�д�������
			}
			System.out.println("�����ļ�" + sourceFileName + "��" + targetFileName
					+ "�ɹ���");
			return true;
		} catch (Exception e) {
			System.out.println("�����ļ�ʧ�ܣ�" + e.getMessage());
			return false;
		} finally {
			// �ر������������ע���ȹر���������ٹر�������
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	 public static boolean deleteAnyone(String fileName) {  
		         File file = new File(fileName);  
		         if (!file.exists()) {  
		             System.out.println("�ļ�ɾ��ʧ�ܣ�" + fileName + "�ļ������ڣ�");  
		            return false;  
		        } else {  
		            if (file.isFile()) {  
		                 return deleteFiles(fileName);  
		            } else {  
		                return deleteDir(fileName);  
		             }  
		         }  
		     }  
	 public static boolean deleteFiles(String fileName) {  
	       File file = new File(fileName);  
		      // ����ļ�·����Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ����  
		         if (file.exists() && file.isFile()) {  
		            if (file.delete()) {  
		                System.out.println("�ļ���" + fileName + "ɾ���ɹ���");  
		                return true;  
		           } else {  
		                System.out.println("�ļ�" + fileName + "ɾ��ʧ�ܣ�");  
		               return false;  
		            }  
		       } else {  
		            System.out.println("�ļ�ɾ��ʧ�ܣ�" + fileName + "�ļ������ڣ�");  
		           return false;  
		        }  
		    }  
		    // �ж�ɾ��ָ����Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ��Ƿ�ɹ����ɹ��򷵻�true���򷵻�false  
		    public static boolean deleteDir(String dir) {  
		         // ���dir�����ļ��ָ�����β���Զ�����ļ��ָ�����  
		        if (!dir.endsWith(File.separator)) {  
		            dir = dir + File.separator;  
		        }  
		        File dirFile = new File(dir);  
		       // ���dir��ʾ���ļ������ڣ����߲���һ���ļ��У����˳�  
		        if (!dirFile.exists() || (!dirFile.isDirectory())) {  
		            System.out.println("Ŀ¼ɾ��ʧ�ܣ�" + dir + "Ŀ¼�����ڣ�");  
		            return false;  
		        }
				return false;  
		    }


	// ��������Ŀ¼�����ݣ����ж��Ƿ��Ƴɹ���������Ƴɹ�����true�����򷵻�false
	public static boolean copy_Dir(String sourceDirName, String targetDirName,
			boolean overlay) {
		// �ж�ԭĿ¼�Ƿ����
		File sourceDir = new File(sourceDirName);
		if (!sourceDir.exists()) {
			System.out.println("����Ŀ¼ʧ�ܣ�ԭĿ¼" + sourceDirName + "�����ڣ�");
			return false;
		} else if (!sourceDir.isDirectory()) {
			System.out.println("����Ŀ¼ʧ�ܣ�" + sourceDirName + "����һ��Ŀ¼��");
			return false;
		}
		// ���Ŀ���ļ����������ļ��ָ�����β���Զ�����ļ��ָ���
		if (!targetDirName.endsWith(File.separator)) {
			targetDirName = targetDirName + File.separator;
		}
		File targetDir = new File(targetDirName);
		// ���Ŀ���ļ��д�����������ʱ����ɾ���Ѵ��ڵ�Ŀ��Ŀ¼
		if (targetDir.exists()) {
			if (overlay) {
				System.out.println("Ŀ¼�Ѵ��ڣ�׼��ɾ������");
				if (!deleteAnyone(targetDirName)) {
					System.out.println("����ʧ�ܣ�Ŀ¼" + targetDirName + "�Ѵ��ڣ�");
				}
			} else {
				System.out.println("����ʧ�ܣ�Ŀ¼" + targetDirName + "�Ѵ��ڣ�");
				return false;
			}
		} else {
			// ���Ŀ¼�������򴴽�Ŀ��Ŀ¼
			System.out.println("Ŀ¼�����ڣ����ڴ�����");
			if (!targetDir.mkdirs()) {
				System.out.println("����Ŀ¼ʧ�ܣ�");
				return false;
			}
		}
		boolean flag = true;
		// �г�Դ�ļ����������ļ���������Ŀ¼�����ļ���
		File[] files = sourceDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// �����һ���ļ�������и���
			if (files[i].isFile()) {
				flag = CopyFile.copy_File(files[i].getAbsolutePath(),
						targetDirName + files[i].getName(), false);
				if (!flag) {
					break;
				}
			}
			// �������Ŀ¼����������Ŀ¼
			if (files[i].isDirectory()) {
				flag = CopyFile.copy_Dir(files[i].getAbsolutePath(),
						targetDirName + files[i].getName(), false);
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("����Ŀ¼" + sourceDirName + "��" + targetDirName
					+ "ʧ�ܣ�");
			return false;
		}
		System.out
				.println("����Ŀ¼" + sourceDirName + "��" + targetDirName + "�ɹ���");
		return true;
	}
	public static void main(String[] args) {
		String sourcePath = "D:/text/text.txt";
		String targetPath = "D:/temp/temp1.txt";
		// �����ļ������Ŀ����ڣ��򸲸�
		CopyFile.copy_File(sourcePath, targetPath, true);
		// ���Ŀ����ڣ��򲻸���
		CopyFile.copy_File(sourcePath, targetPath, false);
		System.out.println();
		String sourceDir = "D:/text";
		String targetDir = "D:/temp";
		// �����ļ��У����Ŀ����ڣ��򸲸�
		CopyFile.copy_Dir(sourceDir, targetDir, true);
	}
}

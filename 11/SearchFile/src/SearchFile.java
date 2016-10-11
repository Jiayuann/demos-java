import java.io.File;//������
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
public class SearchFile {// ���������ļ�����
	static int countFiles = 0;// ����ͳ���ļ������ı���
	static int countFolders = 0;// ����ͳ���ļ��еı���
	public static File[] searchFile(File folder, final String keyWord) {// �ݹ���Ұ����ؼ��ֵ��ļ�
		File[] subFolders = folder.listFiles(new FileFilter(){//�����ڲ����������ļ�
			public boolean accept(File pathname){//ʵ��FileFilter���accept����
				if (pathname.isFile())//������ļ�
					countFiles++;
				else//�����Ŀ¼
					countFolders++;
				if (pathname.isDirectory()
						|| (pathname.isFile() && pathname.getName().contains(
								keyWord)))//Ŀ¼���ļ������ؼ���
					return true;
				return false;
			}
		});
		List result = new ArrayList();//����һ������
		for (int i = 0; i < subFolders.length; i++){//ѭ����ʾ�ļ��л��ļ�
			if (subFolders[i].isFile()) {// ������ļ����ļ���ӵ�����б���
				result.add(subFolders[i]);
			} else {// ������ļ��У���ݹ���ñ�������Ȼ������е��ļ��ӵ�����б���
				File[] foldResult = searchFile(subFolders[i], keyWord);
				for (int j = 0; j < foldResult.length; j++){//ѭ����ʾ�ļ�
					result.add(foldResult[j]);//�ļ����浽������
				}
			}
		}
		File files[] = new File[result.size()];//�����ļ����飬����Ϊ���ϵĳ���
		result.toArray(files);//�������黯
		return files;
	}
	public static void main(String[] args) {// java���������ڴ�
		File folder = new File("D:/text");// Ĭ��Ŀ¼
		String keyword = "txt";
		if (!folder.exists()) {// ����ļ��в�����
			System.out.println("Ŀ¼�����ڣ�" + folder.getAbsolutePath());
			return;
		}
		File[] result = searchFile(folder, keyword);// ���÷�������ļ�����
		System.out.println("�� " + folder + " �Լ��������ļ�ʱ���Ҷ���" + keyword);
		System.out.println("������" + countFiles + " ���ļ���" + countFolders
				+ " ���ļ��У����ҵ� " + result.length + " �������������ļ���");
		for (int i = 0; i < result.length; i++) {//ѭ����ʾ�ļ�
			File file = result[i];
			System.out.println(file.getAbsolutePath() + " ");//��ʾ�ļ�����·��
		}
	}
}

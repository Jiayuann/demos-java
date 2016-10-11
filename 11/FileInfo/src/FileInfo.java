import java.io.File;
public class FileInfo {
	public static void main(String[] args) {
		File file = new File("D:\\createFile\\file1.txt");	// ����ָ����·������һ��File����
		System.out.println("�ļ���Ϊ��" + file.getName());	// ��ȡ��File���������
		System.out.println("����·��Ϊ��" + file.getAbsolutePath());// ��ȡ��File����ľ���·��
		System.out.println("·��Ϊ��" + file.getPath());	// ��ȡ��File��������·��
		System.out.println("��������Ŀ¼Ϊ��" + file.getParent());	//��ȡ��File�����Ŀ¼
		if (!file.exists()) {
			file.mkdir();
		}
		System.out.println("��·������ʾ���ļ���һ��Ŀ¼�𣿣�" + file.isDirectory());// �жϸ�File�����ǲ���Ŀ¼
		System.out.println("���Ǵ��ڿɶ�״̬�𣿣�" + file.canRead());	// �жϸ�File�����Ƿ�ɶ�
		System.out.println("���Ǵ��ڿ�д״̬��" + file.canWrite());	// �жϸ�File�����Ƿ��д
		System.out.println("���ļ�����Ϊ��" + file.length() + "�ֽ�");	// ��ȡ��File�����е��ַ�����
		System.out.println("���ļ�����޸ĵ�ʱ��Ϊ��" + file.lastModified());// ��ȡ��File��������޸�ʱ��
	}
}

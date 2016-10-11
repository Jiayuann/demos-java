import java.util.*;											//������
import java.util.jar.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
public class TextOperatorJAR {									//����JAR�ļ�����
	public static void readJARList(String fileName) throws IOException{//��ʾJAR�ļ������б�
		JarFile jarFile = new JarFile(fileName);					// ����JAR�ļ�����
		Enumeration en = jarFile.entries();			// ö�ٻ��JAR�ļ��ڵ�ʵ��,�����·��
		System.out.println("�ļ���\t�ļ���С\tѹ����Ĵ�С");
		while (en.hasMoreElements()) {						// ������ʾJAR�ļ��е�������Ϣ
			process(en.nextElement());					// ���÷�����ʾ����
		}
	}
	private static void process(Object obj) {// ��ʾ������Ϣ
		JarEntry entry = (JarEntry) obj;// ����ת����Jar����
		String name = entry.getName();// �ļ�����
		long size = entry.getSize();// �ļ���С
		long compressedSize = entry.getCompressedSize();// ѹ����Ĵ�С
		System.out.println(name + "\t" + size + "\t" + compressedSize);
	}
	public static void readJARFile(String jarFileName, String fileName)
			throws IOException {// ��ȡJAR�ļ��еĵ����ļ���Ϣ
		JarFile jarFile = new JarFile(jarFileName);// ���ݴ���JAR�ļ�����JAR�ļ�����
		JarEntry entry = jarFile.getJarEntry(fileName);// ���JAR�ļ��еĵ����ļ���JARʵ��
		InputStream input = jarFile.getInputStream(entry);// ����ʵ�崴��������
		readFile(input);//���÷�������ļ���Ϣ
		jarFile.close();//�ر�JAR�ļ�������
	}
	public static void readFile(InputStream input) throws IOException {// ����JAR�ļ��е����ļ���Ϣ
		InputStreamReader in = new InputStreamReader(input);//�����������
		BufferedReader reader = new BufferedReader(in);//�����������
		String line;
		while ((line = reader.readLine()) != null) {//ѭ����ʾ�ļ�����
			System.out.println(line);
		}
		reader.close();//�رջ������
	}
	public static void main(String args[]) throws IOException {// java��������ڴ�
		TextOperatorJAR j=new TextOperatorJAR();
		System.out.println("1.����һ��JAR�ļ�(����·���ͺ�׺)");
		Scanner scan = new Scanner(System.in);// ��������ֵ
		String jarFileName = scan.next();// ��ü��������ֵ
		readJARList(jarFileName);// ���÷�����ʾJAR�ļ��е��ļ���Ϣ
		System.out.println("2.�鿴��JAR�ļ��е��ĸ��ļ���Ϣ?");
		String fileName=scan.next();// ��������ֵ
		readJARFile(jarFileName,fileName);// ��ü��������ֵ
	}
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Java_Matcher {
	static String str = "I love Java.";
	public static void main(String[] args) {
		Pattern pa = Pattern.compile("\\bJava");// ����Pattern�����ұ���һ���򵥵�������ʽ"\\bJava"
		Matcher ma = pa.matcher(str);// ��Pattern���matcher()��������һ��Matcher����
		System.out.println("�ַ�����" + str);
		System.out.println("������ʽ��" + "\\bJava");
		System.out.println("�ַ�����ƥ������" + ma.matches());
		System.out.println("�Ӵ�ƥ������" + ma.find());
		System.out.println("ƥ���ַ�������ʼ���֣�" + ma.lookingAt());
	}
}

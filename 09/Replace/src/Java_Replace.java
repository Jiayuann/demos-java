import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java_Replace {
	public static void main(String[] args) {
		String str = "lester and limo are good fridends!";
		Pattern p = Pattern.compile("good");// ����Pattern�����ұ���һ���򵥵�������ʽ"good"
		Matcher mc = p.matcher(str);// ��Pattern���matcher()��������һ��Matcher����
		StringBuffer sb = new StringBuffer();
		int count = 0;
		boolean result;
		// ʹ��ѭ�������������е�good�ҳ����滻�ٽ����ݼӵ�sb��
		while (mc.find()) {
			mc.appendReplacement(sb, "excellent");
			count++;
			System.out.println("\n��" + count + "��ƥ���StringBuffer�������ǣ�\n" + sb+"\n");
		}
		mc.appendTail(sb);// ������appendTail()���������һ��ƥ����ʣ���ַ����ӵ�StringBuffer�
		System.out.println("����appendTail������StringBuffer������������:\n"+ sb.toString());
	}
}

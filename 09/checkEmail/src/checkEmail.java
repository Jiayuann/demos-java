import java.util.regex.*;
public class checkEmail {
	public static void main(String[] args) {
		String str = "lester:12��3@sina.com";
		// ��������Email��ַ�Ƿ��� �Ƿ�����"."��"@"��Ϊ��ʼ�ַ�
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(str);
		if (m.find()) {
			System.err.println("EMAIL��ַ������'.'��'@'��Ϊ��ʼ�ַ�");
		}
		// ����Ƿ���"www."Ϊ��ʼ
		p = Pattern.compile("^www\\.");
		m = p.matcher(str);
		if (m.find()) {
			System.out.println("EMAIL��ַ������'www.'��ʼ");
		}
		// ����Ƿ�����Ƿ��ַ�
		p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		boolean deletedIllegalChars = false;
		while (result) {
			// ����ҵ��˷Ƿ��ַ���ô�����±��
			deletedIllegalChars = true;
			// �����������Ƿ��ַ���ð��˫���ŵȣ���ô�Ͱ�������ȥ���ӵ�SB����
			m.appendReplacement(sb, "");
			result = m.find();
		}
		m.appendTail(sb);
		String str1 = sb.toString();
		if (deletedIllegalChars) {
			System.out.println("�����EMAIL��ַ�������ð�š����ŵȷǷ��ַ������޸�");
			System.out.println("�����ڵ�����Ϊ: " + str);
			System.out.println("�޸ĺ�Ϸ��ĵ�ַӦ����: " + str1);
		}
	}

}


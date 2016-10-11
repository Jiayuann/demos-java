import java.util.regex.*;
public class checkEmail {
	public static void main(String[] args) {
		String str = "lester:12，3@sina.com";
		// 检测输入的Email地址是否以 非法符号"."或"@"作为起始字符
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(str);
		if (m.find()) {
			System.err.println("EMAIL地址不能以'.'或'@'作为起始字符");
		}
		// 检测是否以"www."为起始
		p = Pattern.compile("^www\\.");
		m = p.matcher(str);
		if (m.find()) {
			System.out.println("EMAIL地址不能以'www.'起始");
		}
		// 检测是否包含非法字符
		p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		boolean deletedIllegalChars = false;
		while (result) {
			// 如果找到了非法字符那么就设下标记
			deletedIllegalChars = true;
			// 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到SB里面
			m.appendReplacement(sb, "");
			result = m.find();
		}
		m.appendTail(sb);
		String str1 = sb.toString();
		if (deletedIllegalChars) {
			System.out.println("输入的EMAIL地址里包含有冒号、逗号等非法字符，请修改");
			System.out.println("您现在的输入为: " + str);
			System.out.println("修改后合法的地址应类似: " + str1);
		}
	}

}


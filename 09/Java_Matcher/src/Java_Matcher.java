import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Java_Matcher {
	static String str = "I love Java.";
	public static void main(String[] args) {
		Pattern pa = Pattern.compile("\\bJava");// 生成Pattern对象并且编译一个简单的正则表达式"\\bJava"
		Matcher ma = pa.matcher(str);// 用Pattern类的matcher()方法生成一个Matcher对象
		System.out.println("字符串：" + str);
		System.out.println("正则表达式：" + "\\bJava");
		System.out.println("字符串的匹配结果：" + ma.matches());
		System.out.println("子串匹配结果：" + ma.find());
		System.out.println("匹配字符串的起始部分：" + ma.lookingAt());
	}
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java_Replace {
	public static void main(String[] args) {
		String str = "lester and limo are good fridends!";
		Pattern p = Pattern.compile("good");// 生成Pattern对象并且编译一个简单的正则表达式"good"
		Matcher mc = p.matcher(str);// 用Pattern类的matcher()方法生成一个Matcher对象
		StringBuffer sb = new StringBuffer();
		int count = 0;
		boolean result;
		// 使用循环将句子里所有的good找出并替换再将内容加到sb里
		while (mc.find()) {
			mc.appendReplacement(sb, "excellent");
			count++;
			System.out.println("\n第" + count + "次匹配后StringBuffer的内容是：\n" + sb+"\n");
		}
		mc.appendTail(sb);// 最后调用appendTail()方法将最后一次匹配后的剩余字符串加到StringBuffer里；
		System.out.println("调用appendTail方法后StringBuffer的最终内容是:\n"+ sb.toString());
	}
}

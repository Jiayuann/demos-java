import java.text.SimpleDateFormat;
import java.util.*;
public class Simple_Date_Format {
	public static void main(String[] args) {
		Simple_Date_Format.Simple_Format();// 调用Simple_Date方法
	}

	public static void Simple_Format() {
		System.out.println("SimpleDateFormat类获取系统当前的时间如下：");
		// 创建一个日期格式化，日期的形式为EEEE-MMMM-dd-yyyy
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(
				"EEEE-MMMM-dd-yyyy");
		// 创建一个日期格式化，日期的形式为yyyy.MM.dd G 'at' HH:mm:ss z
		SimpleDateFormat b = new SimpleDateFormat(
				"yyyy.MM.dd G 'at' HH:mm:ss z");
		// 创建一个日期格式化，日期的形式为EEE, MMM d, ''yy
		SimpleDateFormat b1 = new SimpleDateFormat("EEE, MMM d, ''yy");
		// 创建一个日期格式化，日期的形式为h:mm a
		SimpleDateFormat b2 = new SimpleDateFormat("h:mm a");
		// 创建一个日期格式化，日期的形式为EEE, d MMM yyyy HH:mm:ss Z
		SimpleDateFormat b3 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		// 创建一个日期格式化，日期的形式为yyMMddHHmmssZ
		SimpleDateFormat b4 = new SimpleDateFormat("yyMMddHHmmssZ");
		Date date = new Date();
		System.out.println("日期的形式为EEEE-MMMM-dd-yyyy：" + bartDateFormat.format(date));
		System.out.println("日期的形式为yyyy.MM.dd G 'at' HH:mm:ss z：" + b.format(date));
		System.out.println("日期的形式为EEE, MMM d, ''yy：" + b1.format(date));
		System.out.println("日期的形式为h:mm a：" + b2.format(date));
		System.out.println("日期的形式为EEE, d MMM yyyy HH:mm:ss Z：" + b3.format(date));
		System.out.println("日期的形式为yyMMddHHmmssZ：" + b4.format(date));
	}
}

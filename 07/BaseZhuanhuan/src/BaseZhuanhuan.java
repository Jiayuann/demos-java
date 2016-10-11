import java.util.Scanner;
public class BaseZhuanhuan { 					// 定义一个进制转换的类
	public static int ZhuanToTen(int a, String str) {	// 其它进制转成十进制
		double d = 0; 						// 声明转换后的数值
		String subString;
		// 根据字符串的长度循环获得单个元素
		for (int i = 0; i < str.length(); i++) {
			subString = str.substring(i, i + 1); 	// 将字符串按循环截取
			if (a == 16) { 					// 判断是否是十六进制
				subString = sixteenToNumber(subString); // 将字母转换成数字
			}
			d += Integer.parseInt(subString)			// 返回转换的结果
					* Math.pow(a, str.length() - i - 1);
		}
		return (int) d;
	}
	public static String TenToNumber(int a, String str) {		// 十进制转成其他进制
		int current = Integer.parseInt(str); 				// 将字符转换成整数
		String opResult = "";
		// 判断转换后的数制是否是16进制
		if (a == 16) {
		// 判断传入的数是否大于16，大于则逢16进一
			while (current >= a) {
				opResult += sixteenNumberToChar(current % a);// 将数字转换成字母
				current /= a;
			}
			if (current != 0)
				opResult += sixteenNumberToChar(current);
		} else {
		// 判断传入的值是否大于转换后的数制
			while (current >= a) {
				opResult += current % a;
				current /= a;
			}
			if (current != 0)
				opResult += current;
		}
		String riResult = ""; 								// 倒序二进制字符串
		// 根据二进制的转换方式进行循环输出
		for (int i = opResult.length() - 1; i >= 0; i--) {
			riResult = riResult + opResult.substring(i, i + 1);
		}
		return riResult;
	}
	public static String sixteenToNumber(String s) { 			// 十六进制字母对应数字
		String num = "";
		if (s.equals("A") || s.equals("a"))
			num = "10";
		else if (s.equals("B") || s.equals("b"))
			num = "11";
		else if (s.equals("C") || s.equals("c"))
			num = "12";
		else if (s.equals("D") || s.equals("d"))
			num = "13";
		else if (s.equals("E") || s.equals("e"))
			num = "14";
		else if (s.equals("F") || s.equals("f"))
			num = "15";
		else
			num = s;
		return num;
	}
	public static String sixteenNumberToChar(int num) { 		// 十六进制数字对应字母
		String c = "";
		if (num == 10)
			c = "A";
		else if (num == 11)
			c = "B";
		else if (num == 12)
			c = "C";
		else if (num == 13)
			c = "D";
		else if (num == 14)
			c = "E";
		else if (num == 15)
			c = "F";
		else
			c = String.valueOf(num);
		return c;
	}
	public static void main(String[] args) { 		// java程序的主入口处
		String number; 					// 要转换的数
		int a, b;							// a表示转换前的进制，b表示转换后的进制
		String result = "";					// 经过数制转换后的结果
		String stop = "";
		Scanner read = new Scanner(System.in); // 得到用户输入的值
		do {
			System.out.println("输入三个整数：待转换的数据   要转换之前的进制  要转换后的进制");
			number = read.next();
			a = read.nextInt();
			b = read.nextInt();
			stop = "Quit";
		} while (stop != "Quit");
		try {
			if (a != 10) {					// 判断转换前的数制是否是十进制
				String temp = String.valueOf(ZhuanToTen(a, number)); 	// 转换成十进制的数
				result = String.valueOf(TenToNumber(b, temp)); 		// 十进制转换成其它进制
			} else {
				result = String.valueOf(TenToNumber(b, number)); 		// 十进制转换成其它进制
			}
			System.out.println(a + "进制的数:" + number + ",转换成" + b + "进制的数为："
					+ result);
		} catch (Exception e) {
			System.out.print("转换失败，请正确输入！");
			System.exit(-1);
		}
	}
}

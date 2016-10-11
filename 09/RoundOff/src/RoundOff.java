import java.util.Scanner;
public class RoundOff{
	public static void main(String[] args) {
		double num;
		Scanner in = new Scanner(System.in);// 由键盘输入一个浮点数
		System.out.print("请输入一个浮点数：");
		num = in.nextDouble();// 获取这个浮点数
		int rint = (int) Math.rint(num);// 调用Math类的rint方法
		System.out.println(num + "四舍五入得到整数：" + rint);
		long round = Math.round(num);// 调用Math类的round方法
		System.out.println(num + "四舍五入得到长整数：" + round);
		int max = (int) Math.floor(num);// 调用Math类的floor方法
		System.out.println("小于" + num + "的最大正整数：" + max);
		int min = (int) Math.ceil(num);// 调用Math类的ceil方法
		System.out.println("大于" + num + "的最小正整数：" + min);
	}
}

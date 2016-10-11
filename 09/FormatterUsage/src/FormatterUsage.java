import java.util.Formatter;
public class FormatterUsage {
	public static void main(String[] args) {
		Object[] ob = new Object[2];// 创建Object数组
		// 给数组赋值
		ob[0] = Integer.valueOf(51);
		ob[1] = Integer.valueOf(1293);
		Formatter fmt = null;
		System.out.println("第一种输出方式：");
		fmt = new Formatter(); // 以默认的存储区为目标，创建对象
		Object[] ob1 = new Object[2];
		ob1[0] = Double.valueOf(1112.12675456);
		ob1[1] = Double.valueOf(0.1258989);
		fmt.format("输出到自带存储区，每个输出项占8个字符位：%4.3f %5.2f\n", ob1); // 格式化输出数据，输出到自己的存储区
		System.out.print(fmt); // 再从对象的存储区中输出到屏幕
		System.out.println("\n第二种输出方式：");
		fmt = new Formatter(System.out); // 以标准输出设备为目标，创建对象
		fmt.format("直接输出，每个输出项占5个字符位：%5d%5d\n\n", ob); // 格式化输出数据，并输出到标准输出设备
		System.out.println("第三种输出方式：");
		StringBuffer buf = new StringBuffer();
		fmt = new Formatter(buf); // 以指定的字符串为目标，创建对象
		fmt.format("输出到指定的缓冲区，每个输出项占8个字符位：%8d%8d\n\n", ob); // 格式化输出数据，输出到buf中
		System.out.print(buf); // 再从buf中输出到屏幕

	}

}

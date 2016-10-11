import java.util.Random;
public class RandomClass {

	public static void randomTypes() {// 获取各种数据类型的随机数
		System.out.println("1. 使用Random类的构造方法生成随机数的示例如下:");
		Random rdm = new Random();// 使用默认的构造方法创建一个Random对象
		int a = 0, b = 0, c = 0, d = 0, e = 0;// 定义计算变量
		while (true) {// 随机产生5个各种类型的随机数
			if (a < 5) {
				if (a == 0) {
					System.out.println("生成double型的随机数列如下:");
				}
				System.out.print(rdm.nextDouble() + " "); // 按均匀分布产生[0,
				// 1)范围的double
				a++;
			} else if (a == 5 && b < 5) {
				if (a == 5 && b == 0) {
					System.out.println("\n生成float型的随机数列如下:");
				}
				System.out.print(rdm.nextFloat() + " "); // 按均匀分布产生大于等于0，小于1的float
				b++;
			} else if (b == 5 && c < 5) {
				if (b == 5 && c == 0) {
					System.out.println("\n生成long型的随机数列如下:");
				}
				System.out.print(rdm.nextLong() + " "); // 按均匀分布产生长整数
				c++;
			} else if (c == 5 && d < 5) {
				if (c == 5 && d == 0) {
					System.out.println("\n生成int型的随机数列如下:");
				}
				System.out.print(rdm.nextInt() + " "); // 按均匀分布产生整数
				d++;
			} else if (d == 5 && e < 5) {
				if (d == 5 && e == 0) {
					System.out.println("\n生成按正态分布产生的double型随机数列如下:");
				}
				System.out.print(rdm.nextGaussian() + " "); // 按正态分布产生随机数
				e++;
			} else if (e == 5) {
				break;
			}
		}
	}

	public static void nextInt() { // 获取指定范围内的随机数
		System.out.println("\n\n2. 在指定范围内产生随机序列：");
		System.out.print("在[0,8)的范围内产生的随机整数序列如下: ");
		Random rdm = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.print(rdm.nextInt(7) + "  "); // Random的nextInt(int,n)方法返回一个[0,
			// n]范围内的随机数
		}
		System.out.println();
		System.out.print("在[5,50)的范围内产生的随机整数序列如下:");
		for (int i = 0; i < 5; i++) {
			System.out.print(5 + rdm.nextInt(45) + "  ");
		}
		System.out.println();
		System.out.print("在[0,100)范围内生成float型的随机整数序列如下: ");
		for (int i = 0; i < 5; i++) {
			System.out.print((int) (rdm.nextFloat() * 100) + "  ");
		}
		System.out.println("\n");
	}

	

	public static void main(String[] args) {// 调用各方法
		randomTypes();
		nextInt();
		
	}
}

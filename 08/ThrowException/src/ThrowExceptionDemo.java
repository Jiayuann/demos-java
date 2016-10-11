public class ThrowExceptionDemo {
	public static void main(String argv[]) {
		try {
			// 由于ThrowException声明会抛出异常，所以编译器会强制程序员在此捕获异常
			ThrowException();
		} catch (Exception e) {
			System.out.println("这是由ThrowException方法抛出\n" + "在main方法中捕获的异常：" + e);
		}
	}
	public static void ThrowException() {// 这里还是可以声明要抛出异常
		double a = Math.random();
		if (a < 0.1)
			System.out.println(a);
		else
			throw new NumberFormatException();
	}
}

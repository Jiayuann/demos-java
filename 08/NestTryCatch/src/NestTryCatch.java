public class NestTryCatch {
	public static void main(String[] args) {
		int array[] = new int[5];
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		for (int i = 0; i < 10; i++) {			// 该循环中可能会出现数组索引越界异常
			try {
				try {
					n = array[i] / (i - 1);	// 这里可能会出现除0异常
				} catch (ArithmeticException e) {
					System.out.println("0不能做被除数");
				}
				System.out.println(n);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("数组索引越界");
			}
		}
	}
}

public class TryCatch {
	public static void main(String[] args) {
		int array[] = { 0, 1, 2, 3, 4, 5, 6 };
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("array[" + i + "]=" + array[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("array[]的长度是" + array.length + "，数组下标越界了");
		}
		System.out.println("运行完毕");
	}
}
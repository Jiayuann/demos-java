public class ThrowsException {
	public static void main(String args[]) {
		try { // 由于ShowException会抛出异常，所以编译器会强制程序员在此捕获异常
			ShowException();
		} catch (Exception e) {
			System.out.println("这是只在ShowException中声明\n" + "并在main方法中捕获的异常：\n"
					+ e);
		}
	}
	public static void ShowException() throws Exception {// 在这里声明要抛出的异常
		Object x = new Integer(0);
		System.out.println((String) x);
	}
}

public class TryCatchFinally {
	public static void hasException() {
		Object obj[] = new String[4];
		for (int i = 0; i < obj.length; i++) {
			try {
				if (i % 2 == 1)
					obj[i] = new Integer(i);// 此句会发生ArrayStoreException异常
				else
					obj[i] = new Integer(i) + "";
				System.out.print(" " + obj[i] + "\n");
			} catch (ArrayStoreException e) {
				System.out.println("出现ArrayStoreException异常，数组内的元素类型与数组类型不匹配");
			} finally {
				System.out.println("这是finally块，是程序必须执行的部分\n");
			}
		}
		System.out.println("方法执行结束");
	}
	public static void main(String argv[]) {
		hasException();
		System.out.println("程序正常结束");
	}
}

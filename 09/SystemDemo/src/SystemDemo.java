public class SystemDemo {
	public static void main(String args[]) {
		try {
			long start = System.currentTimeMillis();// 记录程序开始执行时的时间
			System.out.println("开始执行的时间为：" + start);
			Thread.sleep(3000);
			long end = System.currentTimeMillis();// 记录程序结束执行时的时间
			System.out.println("结束执行的时间为: " + end);
			System.out.println("共执行了：" + (end - start) + "毫秒");// 结束时间-开始时间=执行了的时间
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
	}
}

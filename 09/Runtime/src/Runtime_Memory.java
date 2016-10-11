public class Runtime_Memory {
	public static void main(String args[]) {
		try {
			Runtime run = Runtime.getRuntime();// 获取与当前运行类相关联的runtime实例
			System.out.println("内存可用空间：" + run.totalMemory());
			System.out.println("未创建数组时剩余内存空间：" + run.freeMemory());
			int base[] = new int[10240]; // 申请空间
			System.out.println("创建数组后剩余内存空间：" + run.freeMemory());
			run.gc();// 启动垃圾收集线程
			Thread.sleep(1000);
			System.out.println("启动垃圾收集之后剩余空间：" + run.freeMemory());
			System.out.println("======为数组分配空间=====");
			for (int i = 0; i < 10240; ++i)
				base[i] = i + 1;
			Thread.sleep(2000);
			System.out.println("分配空间之后剩余空间：" + run.freeMemory());
			run.gc();// 启动垃圾收集线程
			Thread.sleep(2000);
			System.out.println("启动垃圾收集之后剩余空间：" + run.freeMemory());
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
	}
}

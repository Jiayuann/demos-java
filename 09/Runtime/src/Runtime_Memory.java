public class Runtime_Memory {
	public static void main(String args[]) {
		try {
			Runtime run = Runtime.getRuntime();// ��ȡ�뵱ǰ�������������runtimeʵ��
			System.out.println("�ڴ���ÿռ䣺" + run.totalMemory());
			System.out.println("δ��������ʱʣ���ڴ�ռ䣺" + run.freeMemory());
			int base[] = new int[10240]; // ����ռ�
			System.out.println("���������ʣ���ڴ�ռ䣺" + run.freeMemory());
			run.gc();// ���������ռ��߳�
			Thread.sleep(1000);
			System.out.println("���������ռ�֮��ʣ��ռ䣺" + run.freeMemory());
			System.out.println("======Ϊ�������ռ�=====");
			for (int i = 0; i < 10240; ++i)
				base[i] = i + 1;
			Thread.sleep(2000);
			System.out.println("����ռ�֮��ʣ��ռ䣺" + run.freeMemory());
			run.gc();// ���������ռ��߳�
			Thread.sleep(2000);
			System.out.println("���������ռ�֮��ʣ��ռ䣺" + run.freeMemory());
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
	}
}

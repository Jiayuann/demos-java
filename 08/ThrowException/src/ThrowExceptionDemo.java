public class ThrowExceptionDemo {
	public static void main(String argv[]) {
		try {
			// ����ThrowException�������׳��쳣�����Ա�������ǿ�Ƴ���Ա�ڴ˲����쳣
			ThrowException();
		} catch (Exception e) {
			System.out.println("������ThrowException�����׳�\n" + "��main�����в�����쳣��" + e);
		}
	}
	public static void ThrowException() {// ���ﻹ�ǿ�������Ҫ�׳��쳣
		double a = Math.random();
		if (a < 0.1)
			System.out.println(a);
		else
			throw new NumberFormatException();
	}
}

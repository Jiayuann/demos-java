public class NestTryCatch {
	public static void main(String[] args) {
		int array[] = new int[5];
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		for (int i = 0; i < 10; i++) {			// ��ѭ���п��ܻ������������Խ���쳣
			try {
				try {
					n = array[i] / (i - 1);	// ������ܻ���ֳ�0�쳣
				} catch (ArithmeticException e) {
					System.out.println("0������������");
				}
				System.out.println(n);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("��������Խ��");
			}
		}
	}
}

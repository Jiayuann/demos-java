public class Pi {
	public static void main(String[] args) {
		int n = 100000;// Ͷ�ĵ���
		int m = 0;// Ͷ�еĸ���
		double x, y;// x��y�����
		for (int i = 0; i < n; i++) {
			// �������һ����
			x = Math.random();
			y = Math.random();
			// �����������λ��Բ�ڻ���Բ��
			if (x * x + y * y <= 1)// �ж������������ǲ�����Բ��
				m++;
		}
		// ͳ�Ƶõ��е�ֵ
		System.out.println("�������������еĽ�����£�");
		System.out.println("\tpi =" + (double) m / n * 4);
	}
}

import java.util.Random;
public class RandomClass {

	public static void randomTypes() {// ��ȡ�����������͵������
		System.out.println("1. ʹ��Random��Ĺ��췽�������������ʾ������:");
		Random rdm = new Random();// ʹ��Ĭ�ϵĹ��췽������һ��Random����
		int a = 0, b = 0, c = 0, d = 0, e = 0;// ����������
		while (true) {// �������5���������͵������
			if (a < 5) {
				if (a == 0) {
					System.out.println("����double�͵������������:");
				}
				System.out.print(rdm.nextDouble() + " "); // �����ȷֲ�����[0,
				// 1)��Χ��double
				a++;
			} else if (a == 5 && b < 5) {
				if (a == 5 && b == 0) {
					System.out.println("\n����float�͵������������:");
				}
				System.out.print(rdm.nextFloat() + " "); // �����ȷֲ��������ڵ���0��С��1��float
				b++;
			} else if (b == 5 && c < 5) {
				if (b == 5 && c == 0) {
					System.out.println("\n����long�͵������������:");
				}
				System.out.print(rdm.nextLong() + " "); // �����ȷֲ�����������
				c++;
			} else if (c == 5 && d < 5) {
				if (c == 5 && d == 0) {
					System.out.println("\n����int�͵������������:");
				}
				System.out.print(rdm.nextInt() + " "); // �����ȷֲ���������
				d++;
			} else if (d == 5 && e < 5) {
				if (d == 5 && e == 0) {
					System.out.println("\n���ɰ���̬�ֲ�������double�������������:");
				}
				System.out.print(rdm.nextGaussian() + " "); // ����̬�ֲ����������
				e++;
			} else if (e == 5) {
				break;
			}
		}
	}

	public static void nextInt() { // ��ȡָ����Χ�ڵ������
		System.out.println("\n\n2. ��ָ����Χ�ڲ���������У�");
		System.out.print("��[0,8)�ķ�Χ�ڲ��������������������: ");
		Random rdm = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.print(rdm.nextInt(7) + "  "); // Random��nextInt(int,n)��������һ��[0,
			// n]��Χ�ڵ������
		}
		System.out.println();
		System.out.print("��[5,50)�ķ�Χ�ڲ��������������������:");
		for (int i = 0; i < 5; i++) {
			System.out.print(5 + rdm.nextInt(45) + "  ");
		}
		System.out.println();
		System.out.print("��[0,100)��Χ������float�͵����������������: ");
		for (int i = 0; i < 5; i++) {
			System.out.print((int) (rdm.nextFloat() * 100) + "  ");
		}
		System.out.println("\n");
	}

	

	public static void main(String[] args) {// ���ø�����
		randomTypes();
		nextInt();
		
	}
}

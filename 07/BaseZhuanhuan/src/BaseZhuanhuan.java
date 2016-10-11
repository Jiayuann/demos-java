import java.util.Scanner;
public class BaseZhuanhuan { 					// ����һ������ת������
	public static int ZhuanToTen(int a, String str) {	// ��������ת��ʮ����
		double d = 0; 						// ����ת�������ֵ
		String subString;
		// �����ַ����ĳ���ѭ����õ���Ԫ��
		for (int i = 0; i < str.length(); i++) {
			subString = str.substring(i, i + 1); 	// ���ַ�����ѭ����ȡ
			if (a == 16) { 					// �ж��Ƿ���ʮ������
				subString = sixteenToNumber(subString); // ����ĸת��������
			}
			d += Integer.parseInt(subString)			// ����ת���Ľ��
					* Math.pow(a, str.length() - i - 1);
		}
		return (int) d;
	}
	public static String TenToNumber(int a, String str) {		// ʮ����ת����������
		int current = Integer.parseInt(str); 				// ���ַ�ת��������
		String opResult = "";
		// �ж�ת����������Ƿ���16����
		if (a == 16) {
		// �жϴ�������Ƿ����16���������16��һ
			while (current >= a) {
				opResult += sixteenNumberToChar(current % a);// ������ת������ĸ
				current /= a;
			}
			if (current != 0)
				opResult += sixteenNumberToChar(current);
		} else {
		// �жϴ����ֵ�Ƿ����ת���������
			while (current >= a) {
				opResult += current % a;
				current /= a;
			}
			if (current != 0)
				opResult += current;
		}
		String riResult = ""; 								// ����������ַ���
		// ���ݶ����Ƶ�ת����ʽ����ѭ�����
		for (int i = opResult.length() - 1; i >= 0; i--) {
			riResult = riResult + opResult.substring(i, i + 1);
		}
		return riResult;
	}
	public static String sixteenToNumber(String s) { 			// ʮ��������ĸ��Ӧ����
		String num = "";
		if (s.equals("A") || s.equals("a"))
			num = "10";
		else if (s.equals("B") || s.equals("b"))
			num = "11";
		else if (s.equals("C") || s.equals("c"))
			num = "12";
		else if (s.equals("D") || s.equals("d"))
			num = "13";
		else if (s.equals("E") || s.equals("e"))
			num = "14";
		else if (s.equals("F") || s.equals("f"))
			num = "15";
		else
			num = s;
		return num;
	}
	public static String sixteenNumberToChar(int num) { 		// ʮ���������ֶ�Ӧ��ĸ
		String c = "";
		if (num == 10)
			c = "A";
		else if (num == 11)
			c = "B";
		else if (num == 12)
			c = "C";
		else if (num == 13)
			c = "D";
		else if (num == 14)
			c = "E";
		else if (num == 15)
			c = "F";
		else
			c = String.valueOf(num);
		return c;
	}
	public static void main(String[] args) { 		// java���������ڴ�
		String number; 					// Ҫת������
		int a, b;							// a��ʾת��ǰ�Ľ��ƣ�b��ʾת����Ľ���
		String result = "";					// ��������ת����Ľ��
		String stop = "";
		Scanner read = new Scanner(System.in); // �õ��û������ֵ
		do {
			System.out.println("����������������ת��������   Ҫת��֮ǰ�Ľ���  Ҫת����Ľ���");
			number = read.next();
			a = read.nextInt();
			b = read.nextInt();
			stop = "Quit";
		} while (stop != "Quit");
		try {
			if (a != 10) {					// �ж�ת��ǰ�������Ƿ���ʮ����
				String temp = String.valueOf(ZhuanToTen(a, number)); 	// ת����ʮ���Ƶ���
				result = String.valueOf(TenToNumber(b, temp)); 		// ʮ����ת������������
			} else {
				result = String.valueOf(TenToNumber(b, number)); 		// ʮ����ת������������
			}
			System.out.println(a + "���Ƶ���:" + number + ",ת����" + b + "���Ƶ���Ϊ��"
					+ result);
		} catch (Exception e) {
			System.out.print("ת��ʧ�ܣ�����ȷ���룡");
			System.exit(-1);
		}
	}
}

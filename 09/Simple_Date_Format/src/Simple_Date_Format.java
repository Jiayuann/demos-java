import java.text.SimpleDateFormat;
import java.util.*;
public class Simple_Date_Format {
	public static void main(String[] args) {
		Simple_Date_Format.Simple_Format();// ����Simple_Date����
	}

	public static void Simple_Format() {
		System.out.println("SimpleDateFormat���ȡϵͳ��ǰ��ʱ�����£�");
		// ����һ�����ڸ�ʽ�������ڵ���ʽΪEEEE-MMMM-dd-yyyy
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(
				"EEEE-MMMM-dd-yyyy");
		// ����һ�����ڸ�ʽ�������ڵ���ʽΪyyyy.MM.dd G 'at' HH:mm:ss z
		SimpleDateFormat b = new SimpleDateFormat(
				"yyyy.MM.dd G 'at' HH:mm:ss z");
		// ����һ�����ڸ�ʽ�������ڵ���ʽΪEEE, MMM d, ''yy
		SimpleDateFormat b1 = new SimpleDateFormat("EEE, MMM d, ''yy");
		// ����һ�����ڸ�ʽ�������ڵ���ʽΪh:mm a
		SimpleDateFormat b2 = new SimpleDateFormat("h:mm a");
		// ����һ�����ڸ�ʽ�������ڵ���ʽΪEEE, d MMM yyyy HH:mm:ss Z
		SimpleDateFormat b3 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		// ����һ�����ڸ�ʽ�������ڵ���ʽΪyyMMddHHmmssZ
		SimpleDateFormat b4 = new SimpleDateFormat("yyMMddHHmmssZ");
		Date date = new Date();
		System.out.println("���ڵ���ʽΪEEEE-MMMM-dd-yyyy��" + bartDateFormat.format(date));
		System.out.println("���ڵ���ʽΪyyyy.MM.dd G 'at' HH:mm:ss z��" + b.format(date));
		System.out.println("���ڵ���ʽΪEEE, MMM d, ''yy��" + b1.format(date));
		System.out.println("���ڵ���ʽΪh:mm a��" + b2.format(date));
		System.out.println("���ڵ���ʽΪEEE, d MMM yyyy HH:mm:ss Z��" + b3.format(date));
		System.out.println("���ڵ���ʽΪyyMMddHHmmssZ��" + b4.format(date));
	}
}

import java.util.Scanner;
public class RoundOff{
	public static void main(String[] args) {
		double num;
		Scanner in = new Scanner(System.in);// �ɼ�������һ��������
		System.out.print("������һ����������");
		num = in.nextDouble();// ��ȡ���������
		int rint = (int) Math.rint(num);// ����Math���rint����
		System.out.println(num + "��������õ�������" + rint);
		long round = Math.round(num);// ����Math���round����
		System.out.println(num + "��������õ���������" + round);
		int max = (int) Math.floor(num);// ����Math���floor����
		System.out.println("С��" + num + "�������������" + max);
		int min = (int) Math.ceil(num);// ����Math���ceil����
		System.out.println("����" + num + "����С��������" + min);
	}
}

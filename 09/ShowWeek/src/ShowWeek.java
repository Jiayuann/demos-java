import java.util.Calendar;
public class ShowWeek {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();// ��ȡһ��Calendar����
		int count = 0;// ����һ����������
		calendar.set(Calendar.YEAR, 2013);// �������
		calendar.set(Calendar.MONTH, 1);// �����·�
		calendar.set(Calendar.DATE, 20);// ��������
		System.out.println("2013��1��20��һ���ڵ��������£�");
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		while (count < 7) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);// �����������������Ϊ1
			int day = calendar.getTime().getDay();// ��ȡ���������ڼ���ʾ�������磺0����ʾ������
			if (count == 0) {// �������ڼ����������뼸��tab
				for (int i = 0; i < day; i++) {
					System.out.print("\t");
				}
			}
			if (day == 0) {// ���������������
				System.out.println();
			}
			System.out.print(calendar.getTime().getDate() + "\t");// ��ȡ������������
			count++;
		}
	}
}

import java.util.Formatter;
public class FormatterUsage {
	public static void main(String[] args) {
		Object[] ob = new Object[2];// ����Object����
		// �����鸳ֵ
		ob[0] = Integer.valueOf(51);
		ob[1] = Integer.valueOf(1293);
		Formatter fmt = null;
		System.out.println("��һ�������ʽ��");
		fmt = new Formatter(); // ��Ĭ�ϵĴ洢��ΪĿ�꣬��������
		Object[] ob1 = new Object[2];
		ob1[0] = Double.valueOf(1112.12675456);
		ob1[1] = Double.valueOf(0.1258989);
		fmt.format("������Դ��洢����ÿ�������ռ8���ַ�λ��%4.3f %5.2f\n", ob1); // ��ʽ��������ݣ�������Լ��Ĵ洢��
		System.out.print(fmt); // �ٴӶ���Ĵ洢�����������Ļ
		System.out.println("\n�ڶ��������ʽ��");
		fmt = new Formatter(System.out); // �Ա�׼����豸ΪĿ�꣬��������
		fmt.format("ֱ�������ÿ�������ռ5���ַ�λ��%5d%5d\n\n", ob); // ��ʽ��������ݣ����������׼����豸
		System.out.println("�����������ʽ��");
		StringBuffer buf = new StringBuffer();
		fmt = new Formatter(buf); // ��ָ�����ַ���ΪĿ�꣬��������
		fmt.format("�����ָ���Ļ�������ÿ�������ռ8���ַ�λ��%8d%8d\n\n", ob); // ��ʽ��������ݣ������buf��
		System.out.print(buf); // �ٴ�buf���������Ļ

	}

}

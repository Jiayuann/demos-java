import java.util.Date;
public class CurrentTime {
	public static void main(String[] args) {
		Date date = new Date();// ����һ��Date����
		System.out.println("��1970��1��1��00:00:00ʱ���Ѿ�����" + date.getTime() + "����");// ����Date���getTime����
		System.out.println("��ǰ��ʱ�䣺" + date.toGMTString());// ����Date���toGMTString�����������˷����ѹ�ʱ
	}
}

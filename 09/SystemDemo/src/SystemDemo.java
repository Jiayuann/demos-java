public class SystemDemo {
	public static void main(String args[]) {
		try {
			long start = System.currentTimeMillis();// ��¼����ʼִ��ʱ��ʱ��
			System.out.println("��ʼִ�е�ʱ��Ϊ��" + start);
			Thread.sleep(3000);
			long end = System.currentTimeMillis();// ��¼�������ִ��ʱ��ʱ��
			System.out.println("����ִ�е�ʱ��Ϊ: " + end);
			System.out.println("��ִ���ˣ�" + (end - start) + "����");// ����ʱ��-��ʼʱ��=ִ���˵�ʱ��
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
	}
}

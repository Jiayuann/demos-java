public class ThrowsException {
	public static void main(String args[]) {
		try { // ����ShowException���׳��쳣�����Ա�������ǿ�Ƴ���Ա�ڴ˲����쳣
			ShowException();
		} catch (Exception e) {
			System.out.println("����ֻ��ShowException������\n" + "����main�����в�����쳣��\n"
					+ e);
		}
	}
	public static void ShowException() throws Exception {// ����������Ҫ�׳����쳣
		Object x = new Integer(0);
		System.out.println((String) x);
	}
}

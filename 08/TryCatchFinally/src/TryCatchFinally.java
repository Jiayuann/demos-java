public class TryCatchFinally {
	public static void hasException() {
		Object obj[] = new String[4];
		for (int i = 0; i < obj.length; i++) {
			try {
				if (i % 2 == 1)
					obj[i] = new Integer(i);// �˾�ᷢ��ArrayStoreException�쳣
				else
					obj[i] = new Integer(i) + "";
				System.out.print(" " + obj[i] + "\n");
			} catch (ArrayStoreException e) {
				System.out.println("����ArrayStoreException�쳣�������ڵ�Ԫ���������������Ͳ�ƥ��");
			} finally {
				System.out.println("����finally�飬�ǳ������ִ�еĲ���\n");
			}
		}
		System.out.println("����ִ�н���");
	}
	public static void main(String argv[]) {
		hasException();
		System.out.println("������������");
	}
}

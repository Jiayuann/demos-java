public class ArrayStoreExcp {
	public static void main(String[] args) {
		Object obj[] = new String[5];
		for (int i = 0; i < obj.length; i++) {
			obj[i] = new Integer(i);
			System.out.print(" " + obj[i]);
		}
	}
}

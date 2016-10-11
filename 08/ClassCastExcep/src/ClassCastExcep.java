
public class ClassCastExcep {
	public static void main(String[] args) {
		Object x = new Integer(0);				// 创建一个Integer类型的对象x
		System.out.println((String) x);			// 将x转换为一个String类型的变量

	}
}

public class Generics<T, V> {
	T t;
	V v;
	Generics(T t1, V v1) {// ���췽��Ҳ����ʹ�����������Ͳ���
		t = t1;
		v = v1;
	}
	void printTypes() {// ��ʾT��V������
		System.out.println("����T�Ķ�������Ϊ�� " + t.getClass().getName());
		System.out.println("����V�Ķ�������Ϊ�� " + v.getClass().getName());
	}
	T getT() {
		return t;
	}
	V getV() {
		return v;
	}
	public static void main(String args[]) {
		Generics<Integer, Double> tv; // ָ�����Ͳ�����ʵ������
		// ���췽������Ҫ�ٴ�ָ�����Ͳ�����ͬʱ��Ҫ����ʵ�ʲ���
		tv = new Generics<Integer, Double>(100, 12.56);
		tv.printTypes();
		int num = tv.getT();
		System.out.println("num�����е�ֵΪ: " + num);
		double dou = tv.getV();
		System.out.println("dou�����е�ֵΪ:" + dou);
	}
}

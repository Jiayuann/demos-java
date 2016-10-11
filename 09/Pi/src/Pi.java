public class Pi {
	public static void main(String[] args) {
		int n = 100000;// 投的点数
		int m = 0;// 投中的个数
		double x, y;// x和y坐标点
		for (int i = 0; i < n; i++) {
			// 随机产生一个点
			x = Math.random();
			y = Math.random();
			// 计算这个点是位于圆内还是圆外
			if (x * x + y * y <= 1)// 判断掷入的这个点是不是在圆内
				m++;
		}
		// 统计得到π的值
		System.out.println("根据随机数计算π的结果如下：");
		System.out.println("\tpi =" + (double) m / n * 4);
	}
}

public class Lover {
	public static void main(String[] args) {
		MatchMarry group1 = new MatchMarry("Lester", "万冰"); // 实例化对象
		MatchMarry group2 = new MatchMarry("王颖", "莫莫");
		MatchMarry group3 = new MatchMarry("李健", "白倩兰");
		MatchMarry group4 = new MatchMarry("丁雪峰", "刘凤");
		MatchMarry group5 = new MatchMarry("范万腾", "郭颖");
		System.out.println("非诚勿扰！情比金坚！");
		group1.start(); // 启动线程
		try {
			group1.join(); // 等待线程运行结束
		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		}
		group2.start();
		try {
			group2.join(); // 等待线程运行结束
		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		}
		group3.start();
		try {
			group3.join(); // 等待线程运行结束
		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		}

		group4.start();
		try {
			group4.join(); // 等待线程运行结束
		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		}
		group5.start();
		try {
			group5.join(); // 等待线程运行结束
		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		}
		System.out.println("速配结束...");

	}

}

class MatchMarry extends Thread { // 测试匹配结婚的类
	private String name; // 人员名称

	private String otherName; // 结婚对象

	private boolean isMarry = false; // 是否结婚

	public MatchMarry(String name, String otherName) { // 带参数构造方法进行初始化
		this.name = name;
		this.otherName = otherName;
	}

	public void run() {
		try {
			int person = (int) Math.floor((Math.random() * 10 + 1));// 获得随机数
			if (person % 2 == 0) {
				isMarry = true; // 设置标识
			} else {
				isMarry = false;
			}
			if (!isMarry) {
				System.out.println(name + "可以与" + otherName + "结婚，祝福你们");
			} else {
				System.out.println(otherName + "已婚，红色警告：对待婚姻不要有二心");
			}
			Thread.sleep(200); // 线程休眠

		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		}
	}
}

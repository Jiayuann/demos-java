import java.util.Date;
public class CurrentTime {
	public static void main(String[] args) {
		Date date = new Date();// 创建一个Date对象
		System.out.println("距1970年1月1日00:00:00时间已经过了" + date.getTime() + "毫秒");// 调用Date类的getTime方法
		System.out.println("当前的时间：" + date.toGMTString());// 调用Date类的toGMTString方法，不过此方法已过时
	}
}

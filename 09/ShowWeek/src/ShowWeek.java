import java.util.Calendar;
public class ShowWeek {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();// 获取一个Calendar对象
		int count = 0;// 定义一个计数变量
		calendar.set(Calendar.YEAR, 2013);// 设置年份
		calendar.set(Calendar.MONTH, 1);// 设置月份
		calendar.set(Calendar.DATE, 20);// 设置日期
		System.out.println("2013年1月20号一周内的日历如下：");
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		while (count < 7) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);// 设置添加日历的周期为1
			int day = calendar.getTime().getDay();// 获取日历的星期几表示数，例如：0：表示星期日
			if (count == 0) {// 根据星期几来决定输入几个tab
				for (int i = 0; i < day; i++) {
					System.out.print("\t");
				}
			}
			if (day == 0) {// 如果是周日了则换行
				System.out.println();
			}
			System.out.print(calendar.getTime().getDate() + "\t");// 获取日历中日期数
			count++;
		}
	}
}

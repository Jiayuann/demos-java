
public class length {
	double num;			// 数值
	String units;			// 单位
	String targetUnits;		// 目标单位
	double result = 0;		// 最后换算的结果
	String str = "";
	// 英寸:inch 英尺:feet 米：meter 厘米：cm
	public static void main(String[] args) {
		System.out.println("长度单位之间的换数如下：");
		// 创建类对象
		length cd = new length(3, "米", "厘米");
		length cd1 = new length(8, "米", "英尺");
		length cd2 = new length(8945.56, "厘米", "米");
		length cd3 = new length(12.5, "英尺", "米");
		length cd4 = new length(12.2, "英寸", "厘米");
		length cd5 = new length(45.96, "厘米", "英寸");
		length cd6 = new length(14.5, "英尺", "英寸");
		length cd7 = new length(30.2, "英寸", "英尺");
		// 调用方法并打印出相应的结果
		System.out.println(cd.unitConversion());
		System.out.println(cd1.unitConversion());
		System.out.println(cd2.unitConversion());
		System.out.println(cd3.unitConversion());
		System.out.println(cd4.unitConversion());
		System.out.println(cd5.unitConversion());
		System.out.println(cd6.unitConversion());
		System.out.println(cd7.unitConversion());
	}
	// 利用构造方法为成员变量赋值
	public length (double num, String units, String targetUnits) {
		this.num = num;
		this.targetUnits = targetUnits;
		this.units = units;
	}
	// 进行各长度单位之间的换算
	public String unitConversion() {
		if (targetUnits.equals("英寸") && units.equals("厘米")) {		// 厘米->英寸
			result = num * (1 / 2.54);
			str = num + "厘米 = " + result + "英寸";
		} else if (targetUnits.equals("厘米") && units.equals("英寸")) {	// 英寸->厘米
			result = num * 2.54;
			str = num + "英寸 = " + result + "厘米";
		} else if (targetUnits.equals("厘米") && units.equals("米")) {	// 米-> 厘米
			result = num * 100;
			str = num + "米 = " + result + "厘米";
		} else if (targetUnits.equals("米") && units.equals("厘米")) {	// 厘米-> 米
			result = num * (1 / 100.0);
			str = num + "厘米 = " + result + "米";
		} else if (targetUnits.equals("英尺") && units.equals("英寸")) {	// 英寸-> 英尺
			result = num * (1 / 12.0);
			str = num + "英寸 = " + result + "英尺";
		} else if (targetUnits.equals("英寸") && units.equals("英尺")) {	// 英尺-> 英寸
			result = num * 12;
			str = num + "英尺 = " + result + "英寸";
		} else if (targetUnits.equals("英尺") && units.equals("米")) {	// 米-> 英尺
			result = num * 3.2809;
			str = num + "米 = " + result + "英尺";
		} else if (targetUnits.equals("米") && units.equals("英尺")) {	// 英尺-> 米
			result = num * (1 / 3.2809);
			str = num + "英尺 = " + result + "米";
		}
		return str;
	}
}

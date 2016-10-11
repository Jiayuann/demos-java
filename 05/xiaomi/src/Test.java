import java.awt.Color;
public class Test {
    public static void main(String[] args) {
    	xiaomi xiaomi1 = new xiaomi("小米M1", "双核1.5Hz", 1299, Color.BLACK); // 创建小米1号
    	xiaomi xiaomi2 = new xiaomi("小米M1s","双核1.7Hz", 1499, Color.BLACK); // 创建小米2号
    	xiaomi xiaomi3 = new xiaomi("小米M2", "四核1.5Hz", 1999, Color.WHITE); // 创建小米3号
        System.out.println("小米1号：" + xiaomi1);// 输出小米1号
        System.out.println("小米2号：" + xiaomi2);// 输出小米2号
        System.out.println("小米3号：" + xiaomi3);// 输出小米3号
    }

}

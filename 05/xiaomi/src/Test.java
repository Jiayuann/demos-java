import java.awt.Color;
public class Test {
    public static void main(String[] args) {
    	xiaomi xiaomi1 = new xiaomi("С��M1", "˫��1.5Hz", 1299, Color.BLACK); // ����С��1��
    	xiaomi xiaomi2 = new xiaomi("С��M1s","˫��1.7Hz", 1499, Color.BLACK); // ����С��2��
    	xiaomi xiaomi3 = new xiaomi("С��M2", "�ĺ�1.5Hz", 1999, Color.WHITE); // ����С��3��
        System.out.println("С��1�ţ�" + xiaomi1);// ���С��1��
        System.out.println("С��2�ţ�" + xiaomi2);// ���С��2��
        System.out.println("С��3�ţ�" + xiaomi3);// ���С��3��
    }

}


public class StaticInner {
    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (100*Math.random());
        }
        System.out.println("Դ���飺");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("���ֵ��" + MaxMin.getResult(array).getMax());
        System.out.println("��Сֵ��" + MaxMin.getResult(array).getMin());
    }

}

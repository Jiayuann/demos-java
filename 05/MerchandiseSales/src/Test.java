import java.util.Random;
public class Test {
    public static void main(String[] args) {
        String[] titles = { "iphone5", "new ipad", "iphone4s" };// ������Ʒ��������
        for (int i = 0; i < 5; i++) {
            new MerchandiseSales(titles[new Random().nextInt(3)]);// ������Ʒ�������鴴��MerchandiseSales����
        }
        System.out.println("�ܼ�������" + MerchandiseSales.getCounter() + "����Ʒ��");// �����������ĸ���
    }

}

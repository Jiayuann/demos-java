public class MerchandiseSales {
    private static int counter = 0;		// ����һ��������
    public MerchandiseSales(String title) {
        System.out.println("���۵���Ʒ���ƣ�" + title);// �����Ʒ��
        counter++;// ��������һ
    }
    public static int getCounter() {// ��ü������Ľ��
        return counter;
    }
}

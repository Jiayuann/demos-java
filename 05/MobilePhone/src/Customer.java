public class Customer {
    public static void main(String[] args) {
        System.out.println("�˿�Ҫ����Iphone5:");
        MobilePhone Iphone5 = MobileFactory.getphone("Iphone5");		//�û�Ҫ����Iphone5
        System.out.println("��ȡ�ֻ���" + Iphone5.getInfo());	//��ȡIphone5
        System.out.println("�˿�Ҫ����SamsungI9300:");
        MobilePhone SamsungI9300 = MobileFactory.getphone("SamsungI9300");	//�û�Ҫ����SamsungI9300
        System.out.println("��ȡ�ֻ���" + SamsungI9300.getInfo());//��ȡSamsungI9300
    }
}
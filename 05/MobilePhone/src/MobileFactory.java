
public class MobileFactory {
    public static MobilePhone getphone(String name) {
        if (name.equalsIgnoreCase("Iphone5")) {//�����ҪIphone5�򴴽�Iphone5����
            return new Iphone5();
        } else if (name.equalsIgnoreCase("SamsungI9300")) {//�����ҪSamsungI9300�򴴽�SamsungI9300����
            return new SamsungI9300();
        } else {//��ʱ����֧����������
            return null;
        }
    }
}

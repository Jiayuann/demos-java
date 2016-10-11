
public class MobileFactory {
    public static MobilePhone getphone(String name) {
        if (name.equalsIgnoreCase("Iphone5")) {//如果需要Iphone5则创建Iphone5对象
            return new Iphone5();
        } else if (name.equalsIgnoreCase("SamsungI9300")) {//如果需要SamsungI9300则创建SamsungI9300对象
            return new SamsungI9300();
        } else {//暂时不能支持其他机型
            return null;
        }
    }
}

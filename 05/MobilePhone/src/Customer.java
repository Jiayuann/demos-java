public class Customer {
    public static void main(String[] args) {
        System.out.println("顾客要购买Iphone5:");
        MobilePhone Iphone5 = MobileFactory.getphone("Iphone5");		//用户要购买Iphone5
        System.out.println("提取手机：" + Iphone5.getInfo());	//提取Iphone5
        System.out.println("顾客要购买SamsungI9300:");
        MobilePhone SamsungI9300 = MobileFactory.getphone("SamsungI9300");	//用户要购买SamsungI9300
        System.out.println("提取手机：" + SamsungI9300.getInfo());//提取SamsungI9300
    }
}
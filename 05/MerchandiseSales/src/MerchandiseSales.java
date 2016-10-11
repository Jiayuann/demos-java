public class MerchandiseSales {
    private static int counter = 0;		// 定义一个计数器
    public MerchandiseSales(String title) {
        System.out.println("出售的商品名称：" + title);// 输出商品名
        counter++;// 计数器加一
    }
    public static int getCounter() {// 获得计数器的结果
        return counter;
    }
}

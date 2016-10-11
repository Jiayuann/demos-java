import java.util.Random;
public class Test {
    public static void main(String[] args) {
        String[] titles = { "iphone5", "new ipad", "iphone4s" };// 创建商品名称数组
        for (int i = 0; i < 5; i++) {
            new MerchandiseSales(titles[new Random().nextInt(3)]);// 利用商品名称数组创建MerchandiseSales对象
        }
        System.out.println("总计销售了" + MerchandiseSales.getCounter() + "件商品！");// 输出创建对象的个数
    }

}

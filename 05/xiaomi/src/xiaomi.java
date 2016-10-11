import java.awt.Color;

public class xiaomi {
    private String name; // 表示手机的名称
    private String model; // 表示手机的型号
    private int price; // 表示手机的价格
    private Color color; // 表示手机的颜色

    public xiaomi(String name, String model, int price, Color color) {// 初始化猫咪的属性
        this.name = name;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {// 重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append("名称：" + name + "\n");
        sb.append("型号：" + model + "\n");
        sb.append("价格：" + price + "\n");
        sb.append("颜色：" + color + "\n");
        return sb.toString();
    }
}
import java.awt.Color;

public class xiaomi {
    private String name; // ��ʾ�ֻ�������
    private String model; // ��ʾ�ֻ����ͺ�
    private int price; // ��ʾ�ֻ��ļ۸�
    private Color color; // ��ʾ�ֻ�����ɫ

    public xiaomi(String name, String model, int price, Color color) {// ��ʼ��è�������
        this.name = name;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {// ��дtoString()����
        StringBuilder sb = new StringBuilder();
        sb.append("���ƣ�" + name + "\n");
        sb.append("�ͺţ�" + model + "\n");
        sb.append("�۸�" + price + "\n");
        sb.append("��ɫ��" + color + "\n");
        return sb.toString();
    }
}
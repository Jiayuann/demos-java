import java.lang.reflect.Method;
public class DynamicMethod {
    public static void main(String[] args) {
        try {
            System.out.println("����Math��ľ�̬����sin()");
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println("1������ֵ�ǣ�" + sin1);
            System.out.println("����String��ķǾ�̬����equals()");
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean shili = (Boolean) equals.invoke(new String("Javaʵ��"), "Javaʵ��");
            System.out.println("�ַ����Ƿ���Javaʵ����" + shili);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
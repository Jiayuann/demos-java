import java.lang.reflect.Method;
public class DynamicMethod {
    public static void main(String[] args) {
        try {
            System.out.println("调用Math类的静态方法sin()");
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println("1的正弦值是：" + sin1);
            System.out.println("调用String类的非静态方法equals()");
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean shili = (Boolean) equals.invoke(new String("Java实例"), "Java实例");
            System.out.println("字符串是否是Java实例：" + shili);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
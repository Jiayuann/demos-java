import java.io.File;
import java.lang.reflect.Constructor;
public class DynamicInstantiation {
    public static void main(String[] args) {
        try {//���File���Constructor����
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            System.out.println("ʹ�÷��䴴��File����");
            File file = constructor.newInstance("d://Lester.txt");
            System.out.println("ʹ��File������D�̴����ļ���Lester.txt");
            file.createNewFile();//�����µ��ļ�
            System.out.println("�ļ��Ƿ񴴽��ɹ���" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
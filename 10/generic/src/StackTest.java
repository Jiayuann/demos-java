public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println("��ջ�������ַ�����");
        System.out.println("��������");
        System.out.println("���μ�");
        System.out.println("ˮ䰴�");
        System.out.println("��¥��");
        stack.push("��������");  //��ջ�������ַ���
        stack.push("���μ�");   //��ջ�������ַ���
        stack.push("ˮ䰴�"); //��ջ�������ַ���
        stack.push("��¥��"); //��ջ�������ַ���
        System.out.println("��ջ��ȡ���ַ�����");
        while (!stack.empty()) {
            System.out.println((String) stack.pop());//ɾ��ջ��ȫ��Ԫ�ز��������
        }
    }
}


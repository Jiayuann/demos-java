public class StringConnection {
  public static void main(String[] argv){
   String s1 = "Hello" + ", " + "World";
   System.out.println("ʹ�üӷ�����������"+s1);

   // ����StringBuffer���󣬲����һЩ�ַ���
   StringBuffer sb2 = new StringBuffer();
   sb2.append("Hello");
   sb2.append(',');
   sb2.append(' ');
   sb2.append("World");

   // ��StringBufferֵת��Ϊ�ַ����������
   String s2 = sb2.toString();
   System.out.println("ʹ��append()���������"+s2);
   
   // �����ظ�����Ĺ��������ǲ��ø�Ϊ�����ķ�ʽ
   StringBuffer sb3 = new StringBuffer().append("Hello").
   append(',').append(' ').append("World");
   System.out.println("append()��������һ����ʽ�����"+sb3.toString());
   }
} 
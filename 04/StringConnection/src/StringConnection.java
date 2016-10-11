public class StringConnection {
  public static void main(String[] argv){
   String s1 = "Hello" + ", " + "World";
   System.out.println("使用加法运算符输出："+s1);

   // 构造StringBuffer对象，并添加一些字符串
   StringBuffer sb2 = new StringBuffer();
   sb2.append("Hello");
   sb2.append(',');
   sb2.append(' ');
   sb2.append("World");

   // 将StringBuffer值转换为字符串，并输出
   String s2 = sb2.toString();
   System.out.println("使用append()方法输出："+s2);
   
   // 现在重复上面的工作，但是采用更为简明的方式
   StringBuffer sb3 = new StringBuffer().append("Hello").
   append(',').append(' ').append("World");
   System.out.println("append()方法的另一种形式输出："+sb3.toString());
   }
} 
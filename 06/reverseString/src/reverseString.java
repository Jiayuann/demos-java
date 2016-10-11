import java.io.*;
import java.util.*;
public class reverseString{
  public static void main(String argv[]){
    FileInputStream fin;
    FileOutputStream fout;
    char ch;
    //创建一个空栈，用于存放字符
    Stack <Character> stack = new Stack<Character>();
    try{
      fin=new FileInputStream(FileDescriptor.in);      
      System.out.println("请输入一行字符：");
      while((ch=(char)fin.read())!='\r')
          stack.push(ch);
      fin.close();
      fout=new FileOutputStream(FileDescriptor.out);
      //如果栈内还有元素，则反复输出
      while(!stack.empty())
        fout.write((char)stack.pop()); //弹出栈顶元素
      fout.close();
    }catch(IOException e){
        System.out.println("输入输出流有误!");
    }
  }
}
import java.io.*;
import java.util.*;
public class reverseString{
  public static void main(String argv[]){
    FileInputStream fin;
    FileOutputStream fout;
    char ch;
    //����һ����ջ�����ڴ���ַ�
    Stack <Character> stack = new Stack<Character>();
    try{
      fin=new FileInputStream(FileDescriptor.in);      
      System.out.println("������һ���ַ���");
      while((ch=(char)fin.read())!='\r')
          stack.push(ch);
      fin.close();
      fout=new FileOutputStream(FileDescriptor.out);
      //���ջ�ڻ���Ԫ�أ��򷴸����
      while(!stack.empty())
        fout.write((char)stack.pop()); //����ջ��Ԫ��
      fout.close();
    }catch(IOException e){
        System.out.println("�������������!");
    }
  }
}
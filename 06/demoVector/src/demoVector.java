import java.util.*;
public class demoVector{
  public static void main(String[] args){
    //ʹ��Vector�Ĺ��췽�����д��� 
    Vector<String> v = new Vector<String>(4);
    //ʹ��add����ֱ�����Ԫ��
    v.add("���μ�");
    v.add("��������");
    v.add("ˮ䰴�");
    v.add("��¥��");
    v.add("�����");
    System.out.println("�����е�ͼ�����ƣ�");
    showVector(v);
    //��Vector��ɾ��Ԫ��
    v.remove("�����"); //ɾ��ָ�����ݵ�Ԫ��
    v.remove(0);       //����������ɾ��Ԫ��
    //���Vector������Ԫ�صĸ���
    System.out.println("����ʣ���ͼ����Ŀ:" + v.size());
    System.out.println("��ʣ���ͼ�����ƣ�");
    showVector(v);
  }
  //����Vector�е�Ԫ��
  public static void  showVector(Vector<String> v){
    Iterator it = v.iterator();
    while(it.hasNext()){
      System.out.print(it.next()+" ");
    }
    System.out.println();
  }
}

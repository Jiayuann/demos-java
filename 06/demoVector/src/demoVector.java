import java.util.*;
public class demoVector{
  public static void main(String[] args){
    //使用Vector的构造方法进行创建 
    Vector<String> v = new Vector<String>(4);
    //使用add方法直接添加元素
    v.add("西游记");
    v.add("三国演义");
    v.add("水浒传");
    v.add("红楼梦");
    v.add("西厢记");
    System.out.println("向量中的图书名称：");
    showVector(v);
    //从Vector中删除元素
    v.remove("西厢记"); //删除指定内容的元素
    v.remove(0);       //按照索引号删除元素
    //获得Vector中现有元素的个数
    System.out.println("现在剩余的图书数目:" + v.size());
    System.out.println("所剩余的图书名称：");
    showVector(v);
  }
  //遍历Vector中的元素
  public static void  showVector(Vector<String> v){
    Iterator it = v.iterator();
    while(it.hasNext()){
      System.out.print(it.next()+" ");
    }
    System.out.println();
  }
}

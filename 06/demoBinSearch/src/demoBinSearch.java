import java.util.*; 
public class demoBinSearch{
  public static void main(String args[]){ 
    ArrayList<Integer> ls =new ArrayList<Integer>();
    Integer key;
    Scanner in = new Scanner(System.in); 
    boolean  goon=true;
    int index;
    for (int i=0;i<10;i++)
      ls.add((int)(Math.random()*1000));
    Collections.sort(ls);
    System.out.print("������������ǣ�");
    showList(ls); 
    System.out.println("��������Ҫ���ҵĹؼ��֣�С�ڵ���0��ʾ������");
    while(goon){
       System.out.print("��������Ҫ���ҵĹؼ��֣�");
       key = in.nextInt();
       if (key>0){
          index = Collections.binarySearch(ls,key);
          if(index>=0)	
            System.out.println("���ҳɹ�����"+index+"��λ��");
          else
            System.out.println("û���ҵ�"+key);
       }
       else
          goon=false;
    }
    in.close();
  }
  public static  void showList(ArrayList<Integer> ls){
     for(Integer elem : ls)
       System.out.print(elem + " ");
     System.out.println();
  }
}

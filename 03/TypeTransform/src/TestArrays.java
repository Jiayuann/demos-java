public class TestArrays{
    public static void main(String []args){
       int[][] a=new int[3][3];
       int[][] b=new int[3][3];
       int[][] c=new int[3][3];
       //ѭ����������ά���飬����Ǹ��������飬�Ϳ���ֱ��д����һ��ѭ����
       System.out.println("����A�ǣ�");
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a[0].length;j++){
                 a[i][j]=(int)((Math.random())*10);
                 System.out.println(a[i][j]+"   ");
           }
      }
      System.out.println("����B�ǣ�");
       for(int i=0;i<b.length;i++){
           for(int j=0;j<b[0].length;j++){
                 b[i][j]=(int)((Math.random())*10);
                 System.out.println(b[i][j]+"   ");
           }
      }
     System.out.println("����A X B�ǣ�");
           for(int i=0;i<c.length;i++){
                for(int j=0;j<c[0].length;j++){
                     c[i][j]=0;
                     for(int k=0;k<c.length;k++){
                            c[i][j]=a[i][k]*b[k][j]|c[i][j];
                     }
                     System.out.println(c[i][j]+"  ");
               }
               System.out.println();
         }
   }
}
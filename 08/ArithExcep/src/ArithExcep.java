
public class ArithExcep {
    public static void main(String[] args) {  
    	double a=1.0;
    	System.out.println(a/0);
        for (int i = 10; i > 0; i--) {  
            System.out.print(" " + (i / (i - 1)));  
            if (i % 5 == 0)  
               System.out.println();  
     }  
   }  
}

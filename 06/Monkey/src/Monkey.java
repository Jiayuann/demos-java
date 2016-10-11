import java.util.*;
public class Monkey{
   public static void main(String args[]){
     LinkedList <Integer> monkeys = new LinkedList<Integer>();
     int number, cnt;
     for (number=1; number<=100; ++number)
       monkeys.addLast(number);
     cnt = 100;
     number = 0;
     Iterator it = monkeys.iterator();
     while(cnt>1){
         if (it.hasNext()){
            it.next();
            ++number;                    
         }else{
            it = monkeys.iterator();
         }
         if(number == 14){
            number = 0;
            it.remove();
            --cnt;
         }         
     }
     System.out.println("´óÍõ±àºÅÎª£º"+monkeys.element());
   }
}
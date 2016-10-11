import java.util.*;
public class CompareScore implements Comparator<Student>{
  public int compare(Student st1, Student st2){
     if (st1.getScore() < st2.getScore())
       return 1;
     if (st1.getScore() > st2.getScore())  
       return -1;
     return 0;
  }
  public boolean equals(Object obj){
     return super.equals(obj);
  }
}
package StudentProject;
import java.util.ArrayList;
import java.util.Scanner;


public class nt extends StudentClass
{
    private int sum =0;
   nt () {}

   nt ( String ID_grade , String ID_class , String ID_teacher,int sum,String types)
   {
    super (ID_grade,ID_class,ID_teacher,types);
    this.sum=sum;
   }
    public int getSum ()
    {
        return sum;
    }
    public void setSum(int sum)
    {
        this.sum=sum;
    }
    
   

   @Override public int Price_student ()
   {
      sum = (3*price_item)+(3*price_place_rest)+pirce_tuition;
    return sum;

   } 
}

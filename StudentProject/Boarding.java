package StudentProject;
// import java.util.ArrayList;
// import java.util.Scanner;

public class Boarding extends StudentClass
{
  private int sum =0;
   
   
   Boarding () {}

   Boarding (String types , String ID_grade , String ID_class , String ID_teacher)
   {
    super (types,ID_grade,ID_class,ID_teacher);
    
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
      sum = (1*price_item)+(price_place_rest)+pirce_tuition;
      return sum;
   } 

}

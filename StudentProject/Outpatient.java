package StudentProject;

//import java.util.ArrayList;


public class Outpatient extends StudentClass
{
    
   private int sum =0;
   
   Outpatient () {}

   Outpatient (String types , String ID_grade , String ID_class , String ID_teacher)
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
      sum =pirce_tuition;
      return sum  ;
    }   
}

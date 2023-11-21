package StudentProject;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
 class StudentClass 
{
    private String ID_grade;
    private String ID_class;
    private String ID_teacher;
    public  int price_item = 23000;
    public int price_place_rest= 50000;
    private String types;
    public int pirce_tuition =500000;
    
    StudentClass() 
    {
        ID_grade ="";
        ID_class ="";
        ID_teacher="";
        types="";
    }

    StudentClass(String ID_grade, String ID_class, String ID_teacher,String types)
    {
        this.ID_grade = ID_grade;
        this.ID_class = ID_class;
        this.ID_teacher = ID_teacher;
        this.types=types;
    }

    public String getID_grade()
    {
        return ID_grade;
    }
    public String getID_class() 
    {
        return ID_class;
    }
      public String getID_teacher() 
    {
        return ID_teacher;

    }
    public String getTypes()
    {
        return types;
    }
   

    public void setID_grade(String ID_grade) 
    {
        this.ID_grade = ID_grade;
    }
    public void setID_class(String ID_class) 
    {
        this.ID_class = ID_class;
    }
    public void setID_teacher(String ID_teacher) 
    {
        this.ID_teacher= ID_teacher;
    }
    public void setTypes(String types)
    {
        this.types=types;
    }
   

    
    void input ()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print(" * Grade : ");
         ID_grade=sc.nextLine(); 

        System.out.print(" * Class : ");
         ID_class=sc.nextLine();

         System.out.print(" * ID teacher : ");
        ID_teacher=sc.nextLine();
    
         System.out.println ("     -----------There are 3 types of class ----------- ");
         System.out.println (" * Day boarding  ");
         System.out.println (" * Boarding ");
         System.out.println (" * Outpatient ");
            
            while (true)
         {   
            System.out.print(" enter name :");   
            types=sc.nextLine();
        
            if (types.equals("Day boarding") || types.equals("Boarding")||types.equals("Outpatient"))
            {
                  break;
            }
            else 
            {
                System.out.println("Invalid type. Please enter a valid type.");
            }
         }
    }
    
    public int Price_student() 
    {
        int sum =0;
       return sum;
    }
}
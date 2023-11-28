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
   

    
    void input() {
        Scanner sc = new Scanner(System.in);
        
        // Grade
        while (true) {
            System.out.print(" * Grade: ");
            ID_grade = sc.nextLine();
            
            if (ID_grade.equals("grade10") || ID_grade.equals("grade11") || ID_grade.equals("grade12")) {
                break;
            } else {
                System.out.println("Invalid grade. Please enter a valid grade (grade10, grade11, or grade12).");
            }
        }
        
        // Class
        while (true) {
            System.out.print(" * Class: ");
            ID_class = sc.nextLine(); 
            
            DSCLASS cl = new DSCLASS();
            boolean check = false;
            
            for (StudentClass CLASS : cl.is_classList()) {
                if (ID_class.equals(CLASS.getID_class())) {
                    check = true;
                    break;
                }
            }
            
            if (check) {
                System.out.println("This class already exists!");
                System.out.println("Invalid class ID. Please enter a valid class ID.");
            }else 
            {
                break;
            }
        }
        
        // ID teacher
        while (true) {
            System.out.print(" * ID-Teacher: ");
            ID_teacher = sc.nextLine(); 
            
            DSCLASS cl = new DSCLASS();
            int check = 0;
            
            for (StudentClass CLASS : cl.is_classList()) {
                if (ID_teacher.equals(CLASS.getID_teacher())) {
                    check = 1;
                }
            }
            
            if (check == 1) {
                System.out.println("This teacher has already been assigned a class.");
                System.out.println("Invalid teacher ID. Please enter a valid teacher ID.");
            } else {
                break;
            }
        }
        
        System.out.println("-----------There are 3 types of classes-----------");
        System.out.println(" * Day boarding");
        System.out.println(" * Boarding");
        System.out.println(" * Outpatient");
        
        while (true) {
            System.out.print("Enter class type: ");   
            types = sc.nextLine();
        
            if (types.equals("Day boarding") || types.equals("Boarding") || types.equals("Outpatient")) {
                break;
            } else {
                System.out.println("Invalid class type. Please enter a valid class type(Day boarding , Boarding ,Outpatient).");
            }
        }
    }
    
    public int Price_student() 
    {
        int sum =0;
       return sum;
    }
}
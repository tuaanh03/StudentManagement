package StudentProject;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
 

 class StudentClass 
{
    public String ID_childminder;   
    public String ID_grade;
    public String ID_class;
    public String ID_teacher;
    
    StudentClass() 
    {
        ID_grade ="";
        ID_class ="";
        ID_teacher="";
        ID_childminder="";


    }

    StudentClass(String ID_grade, String ID_class, String ID_teacher,String ID_childminder)
    {
        this.ID_grade = ID_grade;
        this.ID_class = ID_class;
        this.ID_teacher = ID_teacher;
        this.ID_childminder=ID_childminder;
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
    public String getID_childminder() 
    {
        return ID_childminder;
    }
    public void setID_childminder(String ID_childminder) 
    {
        this.ID_childminder= ID_childminder;
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
   

    // doc file
    public static ArrayList<StudentClass> is_Classes(String f)
    {
        ArrayList<StudentClass> classes = new ArrayList<StudentClass>();
        try 
        {
              File myObj = new File (f);
              Scanner e = new Scanner(myObj);
            while (e.hasNextLine()) 
            {
                String line = e.nextLine();
                String[] arr = line.split("\\s*,\\s*");
                StudentClass CLASS = new StudentClass();
                CLASS.setID_grade(arr[0].trim());
                CLASS.setID_class(arr[1].trim());
                CLASS.setID_teacher(arr[2].trim());
                classes.add(CLASS);
                
            }
            e.close();  
        } 
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return classes;
    }

    //xuat file
    public void output(ArrayList<StudentClass> classes) 
    {
        System.out.printf("%-15s%-15s%-15s\n", "Grade", "Class", "ID Teacher");
        System.out.println("-----------------------------------------------------------");
        for (StudentClass CLASS : classes) 
        {
            System.out.printf("%-15s%-15s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher());
        }
    }

     void input ()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print(" Grade : ");
         ID_grade=sc.nextLine(); 

        System.out.print(" Class : ");
         ID_class=sc.nextLine();

        System.out.print(" ID teacher : ");
        ID_teacher=sc.nextLine();

        System.out.print(" ID childminder : ");
        ID_childminder=sc.nextLine();
        
    }
    
    
     
   
}
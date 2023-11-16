package StudentProject;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class DSCLASS implements Function
{            
  ArrayList<StudentClass> classes = new ArrayList<StudentClass>();
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
                CLASS.setTypes(arr[3].trim());
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

  
  public void show ()
  {
    ArrayList<StudentClass> classes = new ArrayList<StudentClass>();
        try 
        {
              File myObj = new File ("D:\\StudentManagement\\StudentProject\\StudentClass.txt");
              Scanner e = new Scanner(myObj);
            while (e.hasNextLine()) 
            {
                String line = e.nextLine();
                String[] arr = line.split("\\s*,\\s*");
                StudentClass CLASS = new StudentClass();
                CLASS.setID_grade(arr[0].trim());
                CLASS.setID_class(arr[1].trim());
                CLASS.setID_teacher(arr[2].trim());
                CLASS.setTypes(arr[3].trim());
                classes.add(CLASS); 
            }
            e.close();  
        } 
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    System.out.println("\n");
    System.out.println ("---------------- Upload of class --------------");
    System.out.printf("%-15s%-15s%-15s%-20s\n" , "Grade", "Class", "ID Teacher", " Type of class");
    System.out.println("-----------------------------------------------------------");
    for (StudentClass CLASS : classes) 
    {
      System.out.print("\n");        
      System.out.printf("%-15s%-15s%-15s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes());
    }            
  }
      
  public void add()
  {
    Scanner r = new Scanner(System.in); 
    System.out.print(" Enter number class add : ");
    int n = r.nextInt();
    for (int i=0;i <n ;i++)
    {
      StudentClass Add_CLASS = new StudentClass();
      Add_CLASS.input();
      classes.add(Add_CLASS);  
    }
    show();    
  }
   
  public void delete()
  {
    Scanner r = new Scanner(System.in);
      // hien lai danh sach
    System.out.println ("----------------- List Class------------------");
    System.out.printf("%-15s%-15s%-15s%-20s\\n", "Grade", "Class", "ID Teacher", "ID Childminder,Types of class");
    System.out.println("-----------------------------------------------------------");
    for (StudentClass CLASS : classes) 
    {
      System.out.print("\n");        
      System.out.printf("%-15s%-15s%-15s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes());
    }

      // bat dau xoa
      // muốn xóa một phần tử tại một vị trí bất kỳ trong ArrayList sử dụng Iterator để duyệt qua danh sách và gọi phương thức iterator.remove() để xóa phần tử đó.
      //ArrayList, để xóa một phần tử sử dụng phương thức remove() và truyền vào chỉ số của phần tử cần xóa. Chỉ số của phần tử đầu tiên trong danh sách là 0, phần tử thứ hai là 1, và cứ tiếp tục như vậy.    
    System.out.println("\n");
    System.out.print(" If the information of class was not suitabled, you can delete it. Enter number class need delete  : ");
    int n = r.nextInt();
    for (int i=0;i <n ;i++)
    {
      System.out.println (" Which method do you want to delete ?  " );
      System.out.println("1. ID-CLASS");
      System.out.println("2. ID-Teacher");
      System.out.print (" Enter : ");
      int choice=r.nextInt();   
        if (choice==1)
        {
          System.out.println ("enter ID-Class want to delete : ");
          r.nextLine();
          String find = r.nextLine();
          Iterator<StudentClass> iterator= classes.iterator();// tao mot Iterator de duyet qua danh sach
          while (iterator.hasNext())// duyet qua danh sach va xoa phan tu tai vi tri mong muon
          {
            StudentClass studentClass= iterator.next();//được sử dụng để lấy phần tử tiếp theo trong danh sách ArrayList thông qua Iterator.
            if (find.equals(studentClass.getID_grade()))
            {
                iterator.remove();
            }
          }
        }

         else if (choice == 2)
        {
          System.out.println ("enter ID-Teacher want to delete : ");
          String find = r.nextLine();
          Iterator<StudentClass> iterator= classes.iterator();// tao mot Iterator de duyet qua danh sach
          while (iterator.hasNext())// duyet qua danh sach va xoa phan tu tai vi tri mong muon
          {
            StudentClass studentClass= iterator.next();//được sử dụng để lấy phần tử tiếp theo trong danh sách ArrayList thông qua Iterator.
            if (find.equals(studentClass.getID_teacher()))
            {
              iterator.remove();
            }
          }
        }
    }
      show();
    }
  public void search()
  {
    Scanner r = new Scanner(System.in);
    System.out.println ("\n");
    System.out.println (" Which method do you want to seacher?  " );
    System.out.println("1. ID-CLASS");
       System.out.println("2. ID-Teacher");
       System.out.print (" Enter : ");
       int choice =r.nextInt();
       r.nextLine();
       if (choice==1)
      {
        System.out.println("Enter ID-Class ");
        String find=r.nextLine();
        for (StudentClass CLASS:classes)
        {
          if (find.equals(CLASS.getID_class()))
          {
              System.out.printf("%-15s%-15s%-15s%-20s\\n" , "Grade", "Class", "ID Teacher", " Type of class");
              System.out.println("-----------------------------------------------------------");
              System.out.print("\n");        
              System.out.printf("%-15s%-15s%-15s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),CLASS);
  
          }
        }
      }
      else if (choice ==2)
      {
        System.out.print("Enter ID-Teacher ");
        String find=r.nextLine();
        for (StudentClass CLASS:classes)
        {
          if (find.equals(CLASS.getID_teacher()))
          {
              System.out.printf("%-15s%-15s%-15s%-20s\\n", "Grade", "Class", "ID Teacher", " Type of class");
              System.out.println("----------------------------------------------------------");
              System.out.print("\n");        
              System.out.printf("%-15s%-15s%-15s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes());
  
          }
        }
      }
    }


    public void modify()
    {
      Scanner r = new Scanner(System.in);
      System.out.println("\n");
      System.out.println ("---------------------------- Modify---------------");
      System.out.println ("Enter ID-CLASS : ");
      String find= r.nextLine();
      for (StudentClass CLASS:classes)
      {
        if (find.equals(CLASS.getID_class()))
        {
          CLASS.input();
        }
      }

      show();

    }

    public void show_all ()
    {
      System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", "Grade", "Class", "ID Teacher", " Type of class","Tuition free");
              System.out.println("--------------------------------------------------------------------------------------------------------------");
              for (StudentClass CLASS : classes)
              {
                 if (CLASS.getTypes().equals("Day boarding"))     
                 {
                   nt noitru= new nt();
                   System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),noitru.Price_student());
                 } 
                 else if (CLASS.getTypes().equals("Boarding"))
                 {
                   {
                     bt bantru= new bt();
                     System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),bantru.Price_student());
                   }
                 }
                 else if ( CLASS.getTypes().equals("Outpatient"))
                 {
                    ngt ngoaitru = new ngt();
                    System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),ngoaitru.Price_student());
                 }
              } 
    }



    
}



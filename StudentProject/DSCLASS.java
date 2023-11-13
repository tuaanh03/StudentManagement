package StudentProject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class DSCLASS extends StudentClass implements Function<StudentClass>
{
    
    //ArrayList<StudentClass> classes = new ArrayList<StudentClass>();
    DSCLASS (String ID_grade, String ID_class, String ID_teacher,String ID_childminder)
    {
        super(ID_grade, ID_class, ID_teacher,ID_childminder);
        
    }
    DSCLASS()
    {
        super();
        
    }

    public void show (ArrayList<StudentClass> classes)
    {
             System.out.println("\n");
              System.out.println ("---------------- Upload of class --------------");
              System.out.printf("%-15s%-15s%-20s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder");
              System.out.println("-----------------------------------------------------------");
               for (StudentClass CLASS : classes) 
                {
                System.out.print("\n");        
                System.out.printf("%-15s%-15s%-20s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getID_childminder());
                }            
    }
     
    @Override public void Add_Childminder (ArrayList<StudentClass>classes)
    {
          Scanner r = new Scanner(System.in);
          System.out.println("\n");
          System.out.println("------- ADD CHILDMINDER ------");
           System.out.println ("* Ruler ");
           System.out.println ("   + Boarding class : enter ID_childminder");
           System.out.println ("   + Not boarding class : null ");
          for (StudentClass CLASS :classes)
          {
             System.out.print(CLASS.getID_class() + ": " );
             ID_childminder= r.nextLine();// ở cái lớp đó . mình tạo dữ liệu cho lớp đó
             CLASS.setID_childminder(ID_childminder);// mình phải gán dữ liệu vào cái lớp đó
          }
         show(classes);
        System.out.println("\n");      
    }

    public void add(ArrayList<StudentClass>classes)
    {
        Scanner r = new Scanner(System.in);
     
      System.out.print(" Enter number class add : ");
      int n = r.nextInt();
       for (int i=0;i <n ;i++)
       {
         StudentClass Add_CLASS = new DSCLASS();
          Add_CLASS.input();
          classes.add(Add_CLASS);  
       }
        show(classes);    

    }
   
    public void delete(ArrayList<StudentClass>classes)
    {
      Scanner r = new Scanner(System.in);
      // hien lai danh sach
      System.out.println ("----------------- List Class------------------");
      System.out.printf("%-15s%-15s%-20s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder");
      System.out.println("-----------------------------------------------------------");
      for (StudentClass CLASS : classes) 
       {
         System.out.print("\n");        
         System.out.printf("%-15s%-15s%-20s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getID_childminder());
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

       show(classes);
    }
    public void search(ArrayList<StudentClass>classes)
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
              System.out.printf("%-15s%-15s%-20s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder");
              System.out.println("-----------------------------------------------------------");
              System.out.print("\n");        
              System.out.printf("%-15s%-15s%-20s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getID_childminder());
  
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
              System.out.printf("%-15s%-15s%-20s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder");
              System.out.println("-----------------------------------------------------------");
              System.out.print("\n");        
              System.out.printf("%-15s%-15s%-20s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getID_childminder());
  
          }
        }
      }
    }


    public void modify(ArrayList<StudentClass>classes)
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

      show(classes);

    }
}



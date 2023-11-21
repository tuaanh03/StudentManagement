package StudentProject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class DSCLASS implements Function
{            
  static ArrayList<StudentClass> classes = new ArrayList<StudentClass>();
   static ArrayList<Student> studentList = new ArrayList<Student>();
   
  
//   public static ArrayList<StudentClass> ReadData(String f)
//  {
//   // khoi tao rong
//   FileInputStream fis = null; // Lớp này được sử dụng để đọc dữ liệu từ một file trong hệ thống tệp tin. 
//   InputStreamReader reade = null;//Lớp này được sử dụng để đọc dữ liệu từ một luồng byte (byte stream) và chuyển đổi nó thành dữ liệu ký tự (character data). Trong đoạn mã trên, giá trị của reade được gán bằng null.
//   BufferedReader reader = null;//Lớp này cung cấp các phương thức để đọc dữ liệu từ một luồng ký tự (character stream) với hiệu suất tối ưu hơn. 
//   try 
//   {
//     fis = new FileInputStream("D:\\StudentManagement\\StudentProject\\StudentClass.txt");
//     reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
//     reader = new BufferedReader(reade);
//     String line = null;
//     while ((line = reader.readLine())  != null) 
//       {  
//         if (line.isEmpty())
//         {
//             continue;
//         }
//         String[] arr = line.split("\\s*,\\s*");
//         StudentClass CLASS = new StudentClass();
//         CLASS.setID_grade(arr[0].trim());
//         CLASS.setID_class(arr[1].trim());
//         CLASS.setID_teacher(arr[2].trim());
//         CLASS.setTypes(arr[3].trim());
//         classes.add(CLASS);      
//       }
//     System.out.println("Read File Successful");
//     reader.close();
//     }
//     catch (Exception e)
//     {
//       System.out.println("An error occurred: " + e.getMessage());
//       e.printStackTrace();
//     }
//      return classes;
  //}
  
  public void SaveData(String f)
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f)))
    {
      for (StudentClass CLASS :classes)
      {
        writer.write( CLASS.getID_grade() +","+ CLASS.getID_class() +","+ CLASS.getID_teacher()+","+CLASS.getTypes());
        writer.newLine();
      }
      System.out.println("Read File Successful");
      writer.close();
      } catch (Exception e) 
      {
        System.out.println("An error occurred: " + e.getMessage());
      }

  }
     public static ArrayList<StudentClass> Read_isclasses(String f)
 {
  // khoi tao rong
  FileInputStream fis = null; // Lớp này được sử dụng để đọc dữ liệu từ một file trong hệ thống tệp tin. 
  InputStreamReader reade = null;//Lớp này được sử dụng để đọc dữ liệu từ một luồng byte (byte stream) và chuyển đổi nó thành dữ liệu ký tự (character data). Trong đoạn mã trên, giá trị của reade được gán bằng null.
  BufferedReader reader = null;//Lớp này cung cấp các phương thức để đọc dữ liệu từ một luồng ký tự (character stream) với hiệu suất tối ưu hơn. 
  try 
  {
    fis = new FileInputStream("D:\\StudentManagement\\StudentProject\\StudentClass.txt");
    reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
    reader = new BufferedReader(reade);
    String line = null;
    while ((line = reader.readLine())  != null) 
      {  
        if (line.isEmpty())
        {
            continue;
        }
        String[] arr = line.split("\\s*,\\s*");
        StudentClass CLASS = new StudentClass();
        CLASS.setID_grade(arr[0].trim());
        CLASS.setID_class(arr[1].trim());
        CLASS.setID_teacher(arr[2].trim());
        CLASS.setTypes(arr[3].trim());
        classes.add(CLASS);      
      }
    System.out.println("Read File Successful");
    reader.close();
    }
    catch (Exception e)
    {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
     return classes;
  }


  public void show ()
  {
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
    System.out.printf("%-15s%-15s%-15s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder,Types of class");
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
          System.out.print ("enter ID-Class want to delete : ");
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
          System.out.print ("enter ID-Teacher want to delete : ");
          r.nextLine();
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
              System.out.printf("%-15s%-15s%-15s%-20s\n" , "Grade", "Class", "ID Teacher", " Type of class");
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
        Day_boarding noitru= new Day_boarding();
        System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),noitru.Price_student());
      } 
      else if (CLASS.getTypes().equals("Boarding"))
      {
        Boarding bantru= new Boarding();
        System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),bantru.Price_student());
      }
      else if ( CLASS.getTypes().equals("Outpatient"))
      {
        Outpatient ngoaitru = new Outpatient();
        System.out.printf("%-15s%-15s%-15s%-20s%-20s\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes(),ngoaitru.Price_student());
      }
    } 
  }
  public static ArrayList<Student> ReadData(String filePath) 
    {

      FileInputStream fis = null;
      InputStreamReader reade = null;
      BufferedReader reader = null;

      try  {
          fis = new FileInputStream("StudentFile.txt");
          reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
          reader = new BufferedReader(reade);
          String line = null;
          while ((line = reader.readLine())  != null) {
              if (line.isEmpty())
              {
                  continue;
              }
              Student stu = new Student();
              String[] arr = line.split(",");// 1 line chuoi nen la dung String
              stu.setName(arr[0].trim());
              stu.setBirth(arr[1].trim());
              stu.setAddress(arr[2].trim());
              stu.setGender(Integer.parseInt(arr[3].trim()));
              stu.setMail(arr[4].trim());
              stu.setPhoneNumber(Integer.parseInt(arr[5].trim()));
              stu.setID_STUDENT(arr[6]);
              stu.setGrade(Integer.parseInt(arr[7].trim()));
              stu.setStudentClass(arr[8]);
              studentList.add(stu);
          }
          System.out.println("Read File Successful");
          reader.close();
      } catch (Exception e) {
          System.out.println("An error occurred: " + e.getMessage());
      }
      return studentList;
  }
  
  public void show_tuition (String ID)
  {

    String e ; 
    System.out.println("---------------------- Show tuition of student------------------- ");
    for (Student st : studentList)
    {
      if (ID.equals(st.getID_STUDENT()))
      {
        e=st.getStudentClass();
        for (StudentClass CLASS :classes)
        {
          if (e.equals(CLASS.getID_class()))
          {
              System.out.println (CLASS.Price_student());
          }
        }
      }
      }

    }
    


  public void menu()
  { 
    int choice;
        Scanner sc = new Scanner(System.in);
        // do 
        // {
        //     System.out.println("1. Add Class");
        //     System.out.println("2. Delete Class");
        //     System.out.println("3. Search Class");
        //     System.out.println("4. Modify Class");
        //     System.out.println("5. Display Class");
        //     System.out.println("6. view fee");
        //     //System.out.println("7. Load From File");
        //     System.out.println("8. Save From File");
        //     System.out.println("0. Exit");
        //     System.out.println("Enter your choice: ");
        //      choice = sc.nextInt();
        //     switch (choice) 
        //     {
        //       case 1:
        //       {
        //         add();
        //         System.out.println("\n");
        //         break; 
        //       }
        //       case 2:
        //       {
        //         delete();
        //         System.out.println("\n");
        //         break;  
        //       }
        //       case 3: 
        //       {
        //         search();
        //         System.out.println("\n");
        //         break;
        //       }

        //       case 4:
        //       {
        //         modify();
        //         System.out.println("\n");
        //         break;
        //       }

        //       case 5:
        //       {
        //         Read_isclasses("StudentManagement\\StudentProject\\StudentClass.txt");
        //         show();
        //         System.out.println ("\n");
        //         break;
        //       }
        //       case 6 :
        //       {
        //         show_all();
        //         System.out.println("\n");
        //         break;
        //       }
        //       // case 7:
        //       // {
        //       //   Read_isclasses("StudentManagement\\StudentProject\\StudentClass.txt");
        //       //   show();
        //       //   System.out.println("\n");
        //       //   break;
        //       // }

        //       case 8:
        //       {
        //         SaveData("StudentManagement\\StudentProject\\StudentClass.txt");
        //         break;
        //       }
        //       case 0:
        //       {
        //         System.out.println("Thanks for using!");
        //         break;
        //       }
        //     default:
        //     {
        //         System.out.println("Invalid choice. Please try again.");
        //          System.out.println("\n");
        //         break;
        //     }
 
        //     }
        // } while (choice != 0);

  
    }

    public static void main(String[] args) 
    {
      DSCLASS a = new DSCLASS();
    //   a. show_tuition("966770042");  
    // ReadData("StudentManagement\\StudentProject\\StudentClass.txt");
     ReadData("StudentFile.txt");
    a.show_tuition("3122411007");
     }
}



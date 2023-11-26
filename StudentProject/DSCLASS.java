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
  public DSCLASS(){}
  static ArrayList<StudentClass> classes = new ArrayList<StudentClass>();
  public DSCLASS (String filePath)
  {

  FileInputStream fis = null; // Lớp này được sử dụng để đọc dữ liệu từ một file trong hệ thống tệp tin.
  InputStreamReader reade = null;//Lớp này được sử dụng để đọc dữ liệu từ một luồng byte (byte stream) và chuyển đổi nó thành dữ liệu ký tự (character data). Trong đoạn mã trên, giá trị của reade được gán bằng null.
  BufferedReader reader = null;//Lớp này cung cấp các phương thức để đọc dữ liệu từ một luồng ký tự (character stream) với hiệu suất tối ưu hơn.
  try
  {
    fis = new FileInputStream(filePath);
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
    reader.close();
    }
    catch (Exception e)
    {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }
  public ArrayList<StudentClass> is_classList(String filePath)
  {
    FileInputStream fis = null;
    InputStreamReader reade = null;
    BufferedReader reader = null;
  try
  {
    fis = new FileInputStream(filePath);
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
    reader.close();
    }
    catch (Exception e)
    {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
    return classes;
  }
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
      System.out.println ("                      Add class number "+(i+1));
      System.out.println (" --------------------------------------------------------------");
      StudentClass Add_CLASS = new StudentClass();
      Add_CLASS.input();
      classes.add(Add_CLASS);
    }
    show();
    r.close();
  }
  public void delete()
  {
    Scanner r = new Scanner(System.in);
    System.out.println ("----------------- List Class------------------");
    System.out.printf("%-15s%-15s%-15s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder,Types of class");
    System.out.println("-----------------------------------------------------------");
    for (StudentClass CLASS : classes)
    {
      System.out.print("\n");
      System.out.printf("%-15s%-15s%-15s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),CLASS.getTypes());
    }
    System.out.println("\n");
    System.out.print(" If the information of class was not suitable, you can delete it. Enter number class need delete  : ");
    int n = r.nextInt();
    for (int i=0;i <n ;i++)
    {
      System.out.println ("                      Delete class number "+(i+1));
      System.out.println (" * Which method do you want to delete ?  " );
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
            if (find.equals(studentClass.getID_class()))
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
    r.close();
  }


  public void search()
  {
    Scanner r = new Scanner(System.in);
    System.out.println ("\n");
    System.out.println (" Which method do you want to seacher?  " );
    System.out.println("1. ID CLASS");
    System.out.println("2. IDTeacher");
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
    r.close();
  }


  public void modify()
    {
      Scanner r = new Scanner(System.in);
      System.out.println("\n");
      System.out.println ("---------------------------- Modify---------------");
      System.out.print ("Enter ID-CLASS : ");
      String find= r.nextLine();
      for (StudentClass CLASS:classes)
      {
        if (find.equals(CLASS.getID_class()))
        {
          CLASS.input();
          show();
        }
        else
        {
          System.out.println ("The class you just searched for has been previously deleted");
          break;
        }
      }
      r.close();
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

  public void show_tuition (String ID)
  {
    DSStudent a =new DSStudent();
    for (Student st : a.is_stuList("StudentClass.txt"))
    {
      if (ID.equals(st.getID_STUDENT()))
      {
        String e=st.getStudentClass();
        for (StudentClass CLASS :classes)
        {
          if (e.equals(CLASS.getID_class()))
          {
            if (CLASS.getTypes().equals("Day boarding"))
          {
              Day_boarding noitru= new Day_boarding();
              System.out.println(" Show tuition of  "+ st.getName() +" has ID is "+ ID +" :"+noitru.Price_student());
          }
          else if (CLASS.getTypes().equals("Boarding"))
          {
            Boarding bantru= new Boarding();
            System.out.println(" Show tuition of  "+ st.getName() +" has ID is "+ ID +" :"+bantru.Price_student());
          }
          else if ( CLASS.getTypes().equals("Outpatient"))
          {
            Outpatient ngoaitru = new Outpatient();
            System.out.println(" Show tuition of  "+ st.getName() +" has ID is "+ ID +" :"+ngoaitru.Price_student());
          }
          }
        }
      }
      break;
    }
  }
  public void menu()
  {
    int choice;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("1. Add Class");
            System.out.println("2. Delete Class");
            System.out.println("3. Search Class");
            System.out.println("4. Modify Class");
            System.out.println("5. Display Class");
            System.out.println("6. View fee");
            System.out.println("7. Save From File");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice)
            {
              case 1:
              {
                add();
                System.out.println("\n");
                break;
              }
              case 2:
              {
                delete();
                System.out.println("\n");
                break;
              }
              case 3:
              {
                search();
                System.out.println("\n");
                break;
              }

              case 4:
              {
                modify();
                System.out.println("\n");
                break;
              }

              case 5:
              {
                show();
                System.out.println ("\n");
                break;
              }
              case 6 :
              {
                show_all();
                System.out.println("\n");
                break;
              }
              case 7:
              {
                SaveData("StudentManagement\\StudentProject\\StudentClass.txt");
                show();
                System.out.println("\n");
                break;
              }
              case 0:
              {
                System.out.println("Thanks for using!");
                break;
              }
            default:
            {
                System.out.println("Invalid choice. Please try again.");
                System.out.println("\n");
                break;
            }
            }
        } while (choice != 0);
    }


}
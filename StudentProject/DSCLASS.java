package StudentProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class DSCLASS implements Function 
{
  public DSCLASS() {}// khởi tạo constructor không tham số

  static ArrayList<StudentClass> classes = new ArrayList<StudentClass>();// khai báo và khởi tạo

  public DSCLASS(String filePath) // ko trả về mảng 
  {

    FileInputStream fis = null; // Lớp này được sử dụng để đọc dữ liệu từ một file trong hệ thống tệp tin.
    InputStreamReader reade = null;// Lớp này được sử dụng để đọc dữ liệu từ một luồng byte (byte stream) và chuyển
                                   // đổi nó thành dữ liệu ký tự (character data). Trong đoạn mã trên, giá trị của
                                   // reade được gán bằng null.
    BufferedReader reader = null;// Lớp này cung cấp các phương thức để đọc dữ liệu từ một luồng ký tự (character
                                 // stream) với hiệu suất tối ưu hơn.
    try {
      fis = new FileInputStream(filePath);
      reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
      reader = new BufferedReader(reade);
      String line = null;
      while ((line = reader.readLine()) != null) {
        if (line.isEmpty()) {
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
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }
  public ArrayList<StudentClass> is_classList() // trả về list. Như ngày trước là qua file khác mình cần đọc file lại mới sử dụng được trên file đó .
                                                // còn này sao khi đọc file return trả về list . qua file khác chỉ cần gọi file ra ko cần đọc lại
  {
    return classes;
  }

  public void SaveData(String f) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
      for (StudentClass CLASS : classes) {
        writer.write(
            CLASS.getID_grade() + "," + CLASS.getID_class() + "," + CLASS.getID_teacher() + "," + CLASS.getTypes());
        writer.newLine();
      }
      System.out.println("Save File Successful");
      writer.close();
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }

  }


  public void show() {
    System.out.println("+------------+---------------+---------------+--------------------+");
    System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", "Grade", "Class", "ID Teacher", "Type of Class");
    System.out.println("+------------+---------------+---------------+--------------------+");
    
    for (StudentClass CLASS : classes) {
        System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(), CLASS.getTypes());
    }
    
    System.out.println("+------------+---------------+---------------+--------------------+");
}

  public void add() {
    Scanner r = new Scanner(System.in);
    System.out.print(" Enter number class add : ");
    int n = r.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println("                      Add class number " + (i + 1));
      System.out.println(" --------------------------------------------------------------");
      StudentClass Add_CLASS = new StudentClass();
      Add_CLASS.input();
      boolean check =false;
      for (StudentClass CLASS :classes)
      {
        if (Add_CLASS.getID_class().equals(CLASS.getID_class())||Add_CLASS.getID_teacher().equals(CLASS.getID_teacher()))
        {
          check=true;
        }
      }
      if (check)
      {
        System.out.println (" The class you just added already exists"); 
      }
      else
      {
         classes.add(Add_CLASS);
        System.out.println (" Add to successful !");
       
      }
    }

    show();
   
  }

  public void delete() 
  {
     Scanner r = new Scanner(System.in);
    // System.out.println("----------------- List Class------------------");
    // System.out.printf("%-15s%-15s%-15s%-20s\n", "Grade", "Class", "ID Teacher", "ID Childminder,Types of class");
    // System.out.println("-----------------------------------------------------------");
    // for (StudentClass CLASS : classes)
    // {
    //   System.out.print("\n");
    //   System.out.printf("%-15s%-15s%-15s%-20s", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(),
    //       CLASS.getTypes());
    // }
    // System.out.println("\n");
    System.out.print(" If the information of class was not suitable, you can delete it. Enter number class need delete  : ");
    int n = r.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println("+------------------------------------------+");
      System.out.println("|       Delete class number "    +(i + 1)+  "|\n");
      System.out.println("|     Which method do you want to delete?  |");
      System.out.println("|----------------------------------------  |");
      System.out.println("|   1. ID-CLASS                            |");
      System.out.println("|   2. ID-Teacher                          |");
      System.out.println("|   3. Types's class                       |");
      System.out.println("+-------------------------------------------+");
      System.out.print(" Enter: ");
      int choice = r.nextInt();


      if (choice == 1) {
        System.out.print("enter ID-Class want to delete : ");
        r.nextLine();
        String find = r.nextLine();
        int check=0;
        Iterator<StudentClass> iterator = classes.iterator();// tao mot Iterator de duyet qua danh sach
        for (StudentClass CLASS:classes)
        {
          if (find.equals(CLASS.getID_class()))
          {
            check=1;
            break;
          } 
        }
        if (check==1)
        {
          while (iterator.hasNext())// duyet qua danh sach va xoa phan tu tai vi tri mong muon
          {
            StudentClass studentClass = iterator.next();// được sử dụng để lấy phần tử tiếp theo trong danh sách ArrayList
                                                      // thông qua Iterator.                                           
            if(find.equals(studentClass.getID_class())) 
            {
              iterator.remove();
              System.out.println(" Delete to successful !");
              break;
            }
          }
        }
        else if (check==0)
        {
          System.out.println("No found class with ID-CLASS : " + find);
        }
       SaveData("StudentClass.txt");
      }
      
      else if (choice == 2) 
      {
        System.out.print("enter ID-Teacher want to delete : ");
        r.nextLine();
        String find = r.nextLine();
        int check=0;
        Iterator<StudentClass> iterator = classes.iterator();// tao mot Iterator de duyet qua danh sach
        for (StudentClass CLASS:classes)
        {
          if (find.equals(CLASS.getID_teacher()))
          {
            check=1;// id teacher do ton tai thi check =1
            break;
          }
        }
        if (check==1)
        {
          while (iterator.hasNext())// duyet qua danh sach va xoa phan tu tai vi tri mong muon
        {
          StudentClass studentClass = iterator.next();// được sử dụng để lấy phần tử tiếp theo trong danh sách ArrayList
                                                      // thông qua Iterator.
          if (find.equals(studentClass.getID_teacher())) {
            iterator.remove();
            System.out.println(" Delete to successful !");
            break;
          }
        }
        }
        else
        {
          System.out.println("No found class with ID-Teacher : " + find);
        }
       
         SaveData("StudentClass.txt");
      }
       
      else if (choice == 3)
      {
        System.out.println("+--------------------------------------+");
        System.out.println("|   Which types's class do you want     |");
        System.out.println("|           to delete ?                 |");
        System.out.println("|---------------------------------------|");
        System.out.println("|   1. Day boarding                     |");
        System.out.println("|   2. Boarding                         |");
        System.out.println("|   3. Outpatient                       |");
        System.out.println("+--------------------------------------+");
        System.out.print(" Enter number types's class want to delete : ");
        
        int find =r.nextInt();
         Iterator<StudentClass> iterator = classes.iterator();
         while (iterator.hasNext())
         {
          StudentClass studentClass=iterator.next();
          if (find ==1)
          {
            if (studentClass.getTypes().equals("Day boarding"))
            {
              iterator.remove();
              System.out.println(" Delete to successful !");
            }
          }
          else if (find==2)
          {
            if (studentClass.getTypes().equals("Boarding"))
            {
              iterator.remove();
              System.out.println(" Delete to successful !");
            }
          }
          else if (find ==3)
          {
            if (studentClass.getTypes().equals("Outpatient"))
            {
              iterator.remove();
              System.out.println(" Delete to successful !");
            }
          }
          else
          {
            System.out.println("No found class with types's class : " + find);
          }
         }
      }
      
      
    }
    show();
   
  }

  public void search() 
  {
    Scanner r = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("+-----------------------------------+");
    System.out.println("|   Which method do you want to     |");
    System.out.println("|            search?                |");
    System.out.println("|-----------------------------------|");
    System.out.println("|   1. ID CLASS                     |");
    System.out.println("|   2. ID Teacher                   |");
    System.out.println("|   3. Types's class                |");
    System.out.println("|-----------------------------------|");
    System.out.print(" Enter: ");
    int choice = r.nextInt();
    r.nextLine();
    if (choice == 1) 
    {
      System.out.print("Enter ID-Class ");
      String find = r.nextLine();
      int check=0;
      for (StudentClass CLASS :classes)
      {
        if  (find.equals(CLASS.getID_class()))
        {
           check=1;
           break;
        }
      }

      if (check==1)
      {
        for (StudentClass CLASS : classes) 
        {
          if (find.equals(CLASS.getID_class())) 
          {
           System.out.println("+------------+---------------+---------------+--------------------+");
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", "Grade", "Class", "ID Teacher", "Type of Class");
              System.out.println("+------------+---------------+---------------+--------------------+");
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(), CLASS.getTypes());
              System.out.println("+------------+---------------+---------------+--------------------+");
            break;
          }
        }
      }
      else 
      {
        System.out.println("No found class with types's class : " + find);
      }
    } 
    else if (choice == 2) 
    {
      System.out.print("Enter ID-Teacher ");
      String find = r.nextLine();
      int check=0;
      for (StudentClass CLASS :classes)
      {
        if (find.equals(CLASS.getID_teacher()))
        {   check=1;
            break;
        }   
      }
      if (check==1)
      {
        for (StudentClass CLASS : classes) 
        {
          if (find.equals(CLASS.getID_teacher())) 
          {
            System.out.println("+------------+---------------+---------------+--------------------+");
            System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", "Grade", "Class", "ID Teacher", "Type of Class");
            System.out.println("+------------+---------------+---------------+--------------------+");
            System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(), CLASS.getTypes());
            System.out.println("+------------+---------------+---------------+--------------------+");
            break;
          }
        }
      }
      else
      {
        System.out.println("No found class with types's class : " + find);
      }
    }
    else if (choice==3)
    {
      System.out.println("+------------------------------------+");
      System.out.println("|      Which types's class do you     |");
      System.out.println("|          want to search ?           |");
      System.out.println("|------------------------------------ |");
      System.out.println("|   1. Day boarding                   |");
      System.out.println("|   2. Boarding                       |");
      System.out.println("|   3. Outpatient                     |");
      System.out.println("+------------------------------------+");
      System.out.print(" Enter number types's class want to search : ");
        int find =r.nextInt();
        
        if (find ==1)
        {
              System.out.println("+------------+---------------+---------------+--------------------+");
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", "Grade", "Class", "ID Teacher", "Type of Class");
              System.out.println("+------------+---------------+---------------+--------------------+");
          for (StudentClass CLASS : classes)
          {
            if (CLASS.getTypes().equals("Day boarding"))
            {
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(), CLASS.getTypes());
            }
          }
              System.out.println("+------------+---------------+---------------+--------------------+");
        }
      

        else if (find==2)
        {
              System.out.println("+------------+---------------+---------------+--------------------+");
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", "Grade", "Class", "ID Teacher", "Type of Class");
              System.out.println("+------------+---------------+---------------+--------------------+");
          for (StudentClass CLASS : classes)
          {
            if (CLASS.getTypes().equals("Day boarding"))
            {
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(), CLASS.getTypes());
            }
          }
              System.out.println("+------------+---------------+---------------+--------------------+");
        }


        else if (find ==3)
        {
              System.out.println("+------------+---------------+---------------+--------------------+");
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", "Grade", "Class", "ID Teacher", "Type of Class");
              System.out.println("+------------+---------------+---------------+--------------------+");
          for (StudentClass CLASS : classes)
          {
            if (CLASS.getTypes().equals("Outpatient"))
            {  
              System.out.printf("| %-10s | %-13s | %-13s | %-18s |\n", CLASS.getID_grade(), CLASS.getID_class(), CLASS.getID_teacher(), CLASS.getTypes());
            }
          }
              System.out.println("+------------+---------------+---------------+--------------------+");
        }
        else 
        {
           System.out.println("No found class with types's class : " + find);
        }
      
    }
    else 
    {
      System.out.print("This option does not exist");
    }
    
    
  }
public void modify()
{
  Scanner r= new Scanner(System.in);
  System.out.print("Enter class you want to fix  :");
  String find= r.nextLine();

  
  for (StudentClass CLASS:classes)
  {
    
    if (find.equals(CLASS.getID_class()))
    {
      int choice = r.nextInt();
      do
      {
      System.out.println("+-----------------------------------+");
      System.out.println("|   Which method do you want to     |");
      System.out.println("|            search?                |");
      System.out.println("|-----------------------------------|");
      System.out.println("|   1. ID CLASS                     |");
      System.out.println("|   2. ID Teacher                   |");
      System.out.println("|   3. Types's class                |");
      System.out.println("|   0. exit                         |");
      System.out.println("|-----------------------------------|");
      System.out.print(" Enter: ");
      
      
      switch(choice)
      {
        case 1:
        {
          int check=0;
          while (true)
          {
            System.out.println("enter ID class need to fix :");
            r.nextLine();
            String CL= r.nextLine();
            for (StudentClass y :classes )
            {
              if (CL.equals(y.getID_class()))
              {
                check=1 ;
                break;
              }
            }
            if (check==1)
            {
              System.out.println("This class already exists!");
              System.out.println("Invalid class ID. Please enter a valid class ID.");
            }
            else
            {
              CLASS.setID_class(CL);
              break;
            }

          }
          break;
        }
        case 2:
        {
          int check=0;
          while (true)
          {
            System.out.println("enter ID teacher need to fix");
            r.nextLine();
            String CL= r.nextLine();
            for (StudentClass y :classes )
            {
              if (CL.equals(y.getID_teacher()))
              {
                check=1 ;
                break;
              }
            }
            if (check==1)
            {
              System.out.println("This class already exists!");
              System.out.println("Invalid class ID. Please enter a valid class ID.");
            }
            else
            {
              CLASS.setID_teacher(CL);
              break;
            }

          }
          break;
        }

        case 3:
        {

          while (true)
          {
            System.out.println("-----------There are 3 types of classes-----------");
            System.out.println(" * Day boarding");
            System.out.println(" * Boarding");
            System.out.println(" * Outpatient");
            
            while (true) {
                System.out.print("Enter class type: ");   
                 String t = r.nextLine();
            
                if (t.equals("Day boarding") || t.equals("Boarding") || t.equals("Outpatient")) {
                  CLASS.setTypes(t);  
                  break;
                } else {
                    System.out.println("Invalid class type. Please enter a valid class type(Day boarding , Boarding ,Outpatient).");
                }
            } 
           break;
          }  
        }
        
        
       
      }
    
    }while(!choice=0)
  }
}
  
 



  public void show_all() {
    System.out.printf("| %-15s| %-15s| %-15s| %-20s| %-20s|\n" , "Grade", "Class", "ID Teacher", " Type of class", "Tuition free");
    System.out.println("+----------------+----------------+----------------+--------------------+--------------------+");
    for (StudentClass CLASS : classes) {
      if (CLASS.getTypes().equals("Day boarding")) {
        Day_boarding noitru = new Day_boarding();
        System.out.printf("| %-15s| %-15s| %-15s| %-20s| %-20s|\n", CLASS.getID_grade(), CLASS.getID_class(),
            CLASS.getID_teacher(), CLASS.getTypes(), noitru.Price_student());
      } else if (CLASS.getTypes().equals("Boarding")) {
        Boarding bantru = new Boarding();
        System.out.printf("| %-15s| %-15s| %-15s| %-20s| %-20s|\n", CLASS.getID_grade(), CLASS.getID_class(),
            CLASS.getID_teacher(), CLASS.getTypes(), bantru.Price_student());
      } else if (CLASS.getTypes().equals("Outpatient")) {
        Outpatient ngoaitru = new Outpatient();
        System.out.printf("| %-15s| %-15s| %-15s| %-20s| %-20s|\n", CLASS.getID_grade(), CLASS.getID_class(),
            CLASS.getID_teacher(), CLASS.getTypes(), ngoaitru.Price_student());
      }
    }
    System.out.println("+----------------+----------------+----------------+--------------------+--------------------+");
  }

  public void show_tuition(String ID, ArrayList<Student> a) {
    for (Student st : a) {
      if (ID.equals(st.getID_STUDENT())) {
        String e = st.getStudentClass();
        for (StudentClass CLASS : classes) {
          if (e.equals(CLASS.getID_class())) {
            if (CLASS.getTypes().equals("Day boarding")) {
              Day_boarding noitru = new Day_boarding();
              System.out.println(
                  " Show tuition of " + st.getName() + " has ID " + ID + " is: " + noitru.Price_student() + " VND");
            } else if (CLASS.getTypes().equals("Boarding")) {
              Boarding bantru = new Boarding();
              System.out
                  .println(" Show tuition of " + st.getName() + " has ID " + ID + " is:" + bantru.Price_student());
            } else if (CLASS.getTypes().equals("Outpatient")) {
              Outpatient ngoaitru = new Outpatient();
              System.out
                  .println(" Show tuition of  " + st.getName() + " has ID " + ID + " is:" + ngoaitru.Price_student());
            }
          }
        }
      }
      break;
    }
  }

  public void menu() {
    int choice;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.println("+--------------------------------+");
      System.out.println("|      MENU CLASS MANAGEMENT     |");
      System.out.println("+--------------------------------+");
      System.out.println("| 1. Add Class                   |");
      System.out.println("| 2. Delete Class                |");
      System.out.println("| 3. Search Class                |");
      System.out.println("| 4. Modify Class                |");
      System.out.println("| 5. Display Class               |");
      System.out.println("| 6. View fee                    |");
      System.out.println("| 7. Save From File              |");
      System.out.println("| 0. Exit                        |");
      System.out.println("+--------------------------------+");
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();
      switch (choice) {
        case 1: {
          add();
          System.out.println("\n");
          break;
        }
        case 2: {
          delete();
          System.out.println("\n");
          break;
        }
        case 3: {
          search();
          System.out.println("\n");
          break;
        }

        case 4: {
          modify();
          System.out.println("\n");
          break;
        }

        case 5: {
          show();
          System.out.println("\n");
          break;
        }
        case 6: {
          show_all();
          System.out.println("\n");
          break;
        }
        case 7: {
          SaveData("StudentClass.txt");
          show();
          System.out.println("\n");
          break;
        }
        case 0: {
          System.out.println("Thanks for using!");
          break;
        }
        default: {
          System.out.println("Invalid choice. Please try again.");
          System.out.println("\n");
          break;
        }
      }
    } while (choice != 0);
  }
  public static void main(String[] args) {
    DSCLASS a = new DSCLASS("StudentClass.txt");
    a.menu();
  }
}
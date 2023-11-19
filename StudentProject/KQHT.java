package StudentProject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;

import java.util.Iterator;

public class KQHT
{
    
    static ArrayList<Subject> subjectList = new ArrayList<Subject>();
    public static ArrayList<Subject> isLearning_results(String f)
 {
  // khoi tao rong
  FileInputStream fis = null; // Lớp này được sử dụng để đọc dữ liệu từ một file trong hệ thống tệp tin. 
  InputStreamReader reade = null;//Lớp này được sử dụng để đọc dữ liệu từ một luồng byte (byte stream) và chuyển đổi nó thành dữ liệu ký tự (character data). Trong đoạn mã trên, giá trị của reade được gán bằng null.
  BufferedReader reader = null;//Lớp này cung cấp các phương thức để đọc dữ liệu từ một luồng ký tự (character stream) với hiệu suất tối ưu hơn. 
  try 
  {
    fis = new FileInputStream("StudentManagement\\StudentProject\\SubjectFile.txt");
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
        StudentClass KQHT = new StudentClass();
        KQHT.setID_STUDENT(arr[0].trim());
        KQHT.setname_SJ(arr[1].trim());
        KQHT.setpointGK_SJ(arr[2].trim());
        KQHT.setpointCK_SJ(arr[3].trim());
        KQHT.add(subjectList);      
      }
    System.out.println("Read File Successful");
    reader.close();
    }
    catch (Exception e)
    {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
     return subjectList;
 }

 public void SaveData(String f)
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f)))
    {
      for (Subject sb : subjectList)
      {
        writer.write( sb.getID_STUDENT() +","+ sb.getname_SJ() +","+ sb.getpointGK_SJ()+","+sb.getpointCK_SJ());
        writer.newLine();
      }
      System.out.println("Read File Successful");
      writer.close();
      } catch (Exception e) 
      {
        System.out.println("An error occurred: " + e.getMessage());
      }

  }

}
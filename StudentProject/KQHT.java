package StudentProject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class KQHT
{ 
  // private double maxAVG;
  // private double getMaxAVG()
  // {
  //   return maxAVG;
  // }
  // public void setMaxAVG(double max)
  // {
  //   maxAVG=max;
  // }
  static ArrayList<Subject> subjectList = new ArrayList<Subject>();
  public KQHT (String filePath)
  {
      
      FileInputStream fis = null;
      InputStreamReader reade = null;
      BufferedReader reader = null;

      try  {
          fis = new FileInputStream(filePath);
          reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
          reader = new BufferedReader(reade);
          String line = null;
          while ((line = reader.readLine())  != null) {
              if (line.isEmpty())
              {
                  continue;
              }
              Subject sb = new Subject();
              String[] arr = line.split(",");// 1 line chuoi nen la dung String
              sb.setID_STUDENT(arr[0].trim());
              sb.setname_SJ(arr[1].trim());
              sb.setpointGK_SJ(Double.parseDouble(arr[2].trim()));
              sb.setpointCK_SJ(Double.parseDouble(arr[3].trim()));
              subjectList.add(sb);
          }
          System.out.println("Read File Successful");
          reader.close();
      } catch (Exception e) {
          System.out.println("An error occurred: " + e.getMessage());
      }
  }

  // public void pointAVG(String id)
  // {
  //   for (Subject sb : subjectList) {
  //     if(id.equals(sb.getID_STUDENT()))
  //     {
  //       sb.setAVG((sb.getpointGK_SJ()+2*sb.getpointCK_SJ())/3);
        
  //     }
  //   }
  // }
  // public double pointMax()
  // {
  //   double max;
  //   for (int i = 0; i < subjectList.size() - 1; i++) {
  //     Subject sb = subjectList.get(i);
  //     Subject nextSb = subjectList.get(i + 1);
  //     if (sb.getAVG() >= nextSb.getAVG()) {
  //       max=sb.getAVG();
  //     }
  // }
  // return max;
  // }
  public void studyResultByID(String id) //id student truyen vao o main
  {
    System.out.println("                                 Show result of the sudent has ID is : "+id );
    System.out.println("------------------------------------------------------------------------------------------------------------");
       System.out.printf("%-20s%-15s%-15s%-15s\n" , "Name Subject" ,"Point GK", "Point CK","Point Average");
       for (Subject sb : subjectList) {
        if (id.equals(sb.getID_STUDENT())) {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%.2f\n", sb.getname_SJ(), sb.getpointGK_SJ(), sb.getpointCK_SJ(), sb.getAVG());
        }
    }

    System.out.println();
  }
  public void studyResultBySubject() //sb student truyen vao o main
  {
    Scanner r = new Scanner(System.in);
    String subject;
    while (true)
    {
      System.out.println (" ------------------Find point results by subject-----------------");
      System.out.println(" Enter subject : ");
      subject = r.nextLine();
      if (subject.equals("toan")|| subject.equals("ly")|| subject.equals("hoa"))
      { 
        System.out.println("                                Name subject : "+subject.toUpperCase()+"                        ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s\n" , "ID Student" ,"Point GK", "Point CK","Point average ");
        for (Subject sb :subjectList)
       {
        if (subject.equals(sb.getname_SJ()))
          {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%.2f\n",sb.getID_STUDENT(),sb.getpointGK_SJ(),sb.getpointCK_SJ(),sb.getAVG());
          }break;
      }
      }
      else
      {
        System.out.println("Invalid type. Please enter a valid name subject .");
      }
    }
   
  }
}
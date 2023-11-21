package StudentProject;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileInputStream;
// import java.io.FileWriter;
// import java.io.InputStreamReader;
// import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;

// import java.util.Iterator;

public class KQHT
{ private String ID_STUDENT;
  private ArrayList<Subject> name_SJ;
  public String getID_STUDENT()
  {
    return ID_STUDENT;
  }
  public ArrayList<Subject> getName_SJ()
  {
    return name_SJ;
  }
  public void setID_STUDENT(String id)
  {
    ID_STUDENT=id;
  }
  public void setname_SJ(ArrayList<Subject> a)
  {
    name_SJ=a;
  }
  public void studyResultByID(String id) //id student truyen vao o main
  {
    DSSubject a =new DSSubject();
    a.ReadData("StudentManagement//StudentProject//StudentFile.txt");
        // System.out.println("-------Student's ID: "+id+"-------");
    // for (StudentProject.Subject sb:a.ReadData("c:\\Users\\ngocn\\StudentManagement\\StudentProject\\StudentFile.txt")) 
    // {
    //   if(sb.getID_STUDENT().equals(id))
    //   {
    //     System.out.println("Subject's name :" +sb.getname_SJ());
    //     System.out.println("Point GK :"+sb.getpointGK_SJ());
    //     System.out.println("Point CK :"+sb.getpointCK_SJ());
    //     System.out.println("---------------------------");
    //   }
    // }
  }
  public void studyResultBySubject() //sb student truyen vao o main
  {
    Scanner sc=new Scanner(System.in);
    String sub=sc.nextLine();
    DSSubject a=new DSSubject();
    a.ReadData("StudentProject//SubjectFile.txt");
    a.show();
    //     System.out.println("-------Subject's name: "+sub+"-------");
    // for (StudentProject.Subject sb:a.ReadData("StudentProject\\SubjectFile.txt")) 
    // {
    //   if(sb.getname_SJ().equals(sub))
    //   {
    //     System.out.println("Student's ID :"+sb.getID_STUDENT());
    //     System.out.println("Subject's name :" +sb.getname_SJ());
    //     System.out.println("Point GK :"+sb.getpointGK_SJ());
    //     System.out.println("Point CK :"+sb.getpointCK_SJ());
    //     System.out.println("---------------------------");
    //   }
    // }
  }
  public static void main(String[] args) {
    KQHT a=new KQHT();
    a.studyResultByID("3122411007");
  }
}
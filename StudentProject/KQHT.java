package StudentProject;
import java.util.Scanner;

public class KQHT
{
  public KQHT (){}
  public void studyResultByID(String id) //id student truyen vao o main
  {
    double sum=0;
    int count=0;
    DSStudent student=new DSStudent();
    for (Student stu : student.is_stuList("StudentFile.txt")) {
      if(id.equals(stu.getID_STUDENT()))
      {
        System.out.println("Student's name : "+stu.getName());
        System.out.println("Student's ID : "+stu.getID_STUDENT());
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s\n" , "Name Subject" ,"Point GK", "Point CK","Point Average");
        DSSubject sub=new DSSubject();
        for (Subject sb :  sub.is_SubList("SubjectFile.txt")) {
        if (id.equals(sb.getID_STUDENT())) {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%.2f\n", sb.getName_SJ(), sb.getPointGK_SJ(), sb.getPointCK_SJ(), sb.getAVG());
            sum+=sb.getAVG();
            count+=1;
        }
    }
          System.out.println("------------------------------------------------------------------");
          System.out.printf("Final Result : %.2f\n" ,(double)(sum/count));
      }
    }
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
      if (subject.equals("math")|| subject.equals("physics")|| subject.equals("chemistry"))
      {
        System.out.println("                                Name subject : "+subject.toUpperCase()+"                        ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s\n" , "ID Student" ,"Point GK", "Point CK","Point average ");
        DSSubject sub=new DSSubject();
        for (Subject sb :  sub.is_SubList("SubjectFile.txt"))
        {
          if (subject.equals(sb.getName_SJ()))
          {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%.2f\n",sb.getID_STUDENT(),sb.getPointGK_SJ(),sb.getPointCK_SJ(),sb.getAVG());          }
          break;
      }

      }
      else
      {
        System.out.println("Invalid type. Please enter a valid name subject .");
      }
    r.close();
    }
  }
  public void studyResultByClass()
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter class you want view result study :");
    String in=sc.nextLine();
    // DSCLASS Class=new DSCLASS();
    System.out.printf("%-20s%-15s%-15s%-15s%-15s\n" , "ID Student","Name subject" ,"Point GK", "Point CK","Point average ");
    DSStudent student =new DSStudent();
    DSSubject sub=new DSSubject();
    for (Student stu : student.is_stuList("StudentFile.txt")) {
      if(in.equals(stu.getStudentClass()))
      {
        String id=stu.getID_STUDENT();
        for (Subject sb : sub.is_SubList("SubjectFile.txt")) {
          if(id.equals(sb.getID_STUDENT()))
          {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%-15s%.2f\n", sb.getID_STUDENT(),sb.getName_SJ(),sb.getPointGK_SJ(),sb.getPointCK_SJ(),sb.getAVG());
          }
        }
      }
    }
  }
  public void menu()
  {
    int choice;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("1. View result by ID");
            System.out.println("2. View result by subject");
            System.out.println("3. View result by Class");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                  System.out.print("Enter Student's ID : ");
                  String id=sc.nextLine();
                    studyResultByID(id);
                    break;
                }
                case 2: {
                    studyResultBySubject();
                    System.out.print("\n");
                    break;
                }
                case 3: {
                    studyResultByClass();
                    System.out.print("\n");
                    break;
                }
                case 0: {
                    System.out.println("Thanks for using!");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        } while (choice != 0);
        sc.close();
  }
}
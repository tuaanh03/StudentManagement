package StudentProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class KQHT {
  public KQHT() {
  }

  public static void clrscr()
	{
		try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
	}


  public double finalPointID(String id)
  {
    double sum = 0;
    int count = 0;
    DSStudent st=new DSStudent();
    for (Student stu : st.is_stuList()) {
      if (id.equals(stu.getID_STUDENT())) {
        DSSubject sub=new DSSubject();
        for (Subject sb : sub.is_SubList()) {
          if (id.equals(sb.getID_STUDENT())) {
            double a = sb.pointAVG();
            sb.setAVG(a);
            sum += sb.getAVG();
            count += 1;
            break;
          }
        }
      }
    }
    return (double)sum/count;
  }
  public void studyResultByID(String id) // id student truyen vao o main
  {
    int check = 0;
    double sum = 0;
    int count = 0;
    DSStudent st = new DSStudent();
    for (Student stu : st.is_stuList()) {
      if (id.equals(stu.getID_STUDENT())) {
        System.out.println("Student's name : " + stu.getName());
        System.out.println("Student's ID : " + stu.getID_STUDENT());
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s\n", "Name Subject", "Point GK", "Point CK", "Point Average");
        DSSubject sub = new DSSubject();
        for (Subject sb : sub.is_SubList()) {
          if (id.equals(sb.getID_STUDENT())) {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%.2f\n", sb.getName_SJ(), sb.getPointGK_SJ(), sb.getPointCK_SJ(),
            sb.getAVG());
            sum += sb.getAVG();
            count += 1;
          }
        }
        check = 1;
        System.out.println("------------------------------------------------------------------");
        System.out.printf("Final Result : %.2f\n", (double) (sum / count));  
      }

    }
    if (check == 0)
    {
        System.out.println("ID'student doesn't exist !");
    }
  }

  public void studyResultBySubject() // sb student truyen vao o main
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Subject you want find :");
    String name = sc.nextLine();
    DSSubject sb = new DSSubject();
    System.out.printf("%-20s%-15s%-15s%-15s%-15s\n", "ID Student", "Name subject", "Point GK", "Point CK",
        "Point average ");
    for (Subject sub : sb.is_SubList()) {
      if (name.equals(sub.getName_SJ())) {
        double a = sub.pointAVG();
        sub.setAVG(a);
        System.out.printf("%-20s%-15s%-15s%-15s%.2f\n", sub.getID_STUDENT(), sub.getName_SJ(), sub.getPointGK_SJ(),
            sub.getPointCK_SJ(), sub.getAVG());
      }
    }
  }

  public void studyResultByClass() {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> a=new ArrayList<>();
    System.out.print("Enter class you want view result study :");
    String in = sc.nextLine();
    System.out.println("------------------------------------------------------------------");
    DSStudent st=new DSStudent();
    for (Student stu : st.is_stuList()) {
      if (in.equals(stu.getStudentClass())) {
        String id = stu.getID_STUDENT();
        a.add(id);
      }
    }
    for (String out : a) {
      studyResultByID(out);
      System.out.println("------------------------------------------------------------------");
    }
  }

  public void menu() {
    int choice;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.println("1. View result by ID");
      System.out.println("2. View result by subject");
      System.out.println("3. View result by Class");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1: {
          clrscr();
          System.out.print("Enter Student's ID : ");
          String id = sc.nextLine();
          studyResultByID(id);
          break;
        }
        case 2: {
          clrscr();
          studyResultBySubject();
          System.out.print("\n");
          break;
        }
        case 3: {
          clrscr();
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
  }
  public void AllResultForTeacher(String id)
  {
    ArrayList<String> a= new ArrayList<>();
    QLTeacher tea=new QLTeacher();
    for (Teacher t : tea.is_TeacherList()) {
      if(id.equals(t.getID_GV()))
      {
        String cls=t.getID_CLASS();
        System.out.println("Your class : "+cls);
        DSStudent stu=new DSStudent();
        for (Student st : stu.is_stuList()) {
          if(cls.equals(st.getStudentClass()))
          {
            a.add(st.getID_STUDENT());
          }
        }
      }
    }
    for (String in : a) {
      studyResultByID(in);
      System.out.println("------------------------------------------------------------------");
    }
  }
public void IDResultForTeacher(String id)
{
  ArrayList<String> a= new ArrayList<>();
    QLTeacher tea=new QLTeacher();
    DSStudent stu=new DSStudent();
    for (Teacher t : tea.is_TeacherList()) {
      if(id.equals(t.getID_GV()))
      {
        String cls=t.getID_CLASS();
        System.out.println("Your class : "+cls);
        for (Student st : stu.is_stuList()) {
          if(cls.equals(st.getStudentClass()))
          {
            a.add(st.getID_STUDENT());
          }
        }
      }
    }
    int count=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter student's ID in your class :");
    String IDstu=sc.nextLine();
    for (String in : a) {
      if(in.equals(IDstu))
      {
        studyResultByID(IDstu);
        break;
      }
      else
      {
        count++;
        if(count==a.size())
        {
          System.out.println("Don't find this ID in your class!!!");
          break;
        }
      }
    }
}
public void maxPointInClassOfTeacher(String id)
{
  ArrayList<String> a= new ArrayList<>();
    QLTeacher tea=new QLTeacher();
    for (Teacher t : tea.is_TeacherList()) {
      if(id.equals(t.getID_GV()))
      {
        String cls=t.getID_CLASS();
        System.out.println("Your class : "+cls);
        DSStudent stu=new DSStudent();
        for (Student st : stu.is_stuList()) {
          if(cls.equals(st.getStudentClass()))
          {
            a.add(st.getID_STUDENT());
          }
        }
      }
    }
    double max=0;
    String best="";
    for (String in : a) {
      if(finalPointID(in)>=max)
      {
        max=finalPointID(in);
        best=in;
      }
    }
    System.out.println("--------Student is the best in your class------");
    studyResultByID(best);
}
public void menuForTeacher(String idTeacher)
{
int choice;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.println("1. View result by ID");
      System.out.println("2. View all result in your class");
      System.out.println("3. View student have best core in your class");
      System.out.println("0. Exit");
      System.out.println("Enter your choice: ");
      choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1: {
          clrscr();
          IDResultForTeacher(idTeacher);
          break;
        }
        case 2: {
          clrscr();
          AllResultForTeacher(idTeacher);
          break;
        }
        case 3:
        {
          clrscr();
          maxPointInClassOfTeacher(idTeacher);
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
  }
}
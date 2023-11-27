package StudentProject;

import java.util.ArrayList;
import java.util.Scanner;

public class KQHT {
  public KQHT() {
  }

  public void studyResultByID(String id, ArrayList<Student> st, ArrayList<Subject> sub) // id student truyen vao o main
  {
    double sum = 0;
    int count = 0;
    for (Student stu : st) {
      if (id.equals(stu.getID_STUDENT())) {
        System.out.println("Student's name : " + stu.getName());
        System.out.println("Student's ID : " + stu.getID_STUDENT());
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s\n", "Name Subject", "Point GK", "Point CK", "Point Average");
        for (Subject sb : sub) {
          if (id.equals(sb.getID_STUDENT())) {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%.2f\n", sb.getName_SJ(), sb.getPointGK_SJ(), sb.getPointCK_SJ(),
                sb.getAVG());
            sum += sb.getAVG();
            count += 1;

          }
        }
        System.out.println("------------------------------------------------------------------");
        System.out.printf("Final Result : %.2f\n", (double) (sum / count));
      }
      }
  }

  public void studyResultBySubject() // sb student truyen vao o main
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Subject you want find :");
    String name=sc.nextLine();
    DSSubject sb=new DSSubject();
    System.out.printf("%-20s%-15s%-15s%-15s%-15s\n", "ID Student", "Name subject", "Point GK", "Point CK","Point average ");
    for (Subject sub : sb.is_SubList()) {
      if(name.equals(sub.getName_SJ()))
      {
        double a = sub.pointAVG();
        sub.setAVG(a);
        System.out.printf("%-20s%-15s%-15s%-15s%.2f\n", sub.getID_STUDENT(), sub.getName_SJ(), sub.getPointGK_SJ(),sub.getPointCK_SJ(), sub.getAVG());
      }
    }
  }

  public void studyResultByClass(String in,ArrayList<Student> st, ArrayList<Subject> sub) {
    System.out.printf("%-20s%-15s%-15s%-15s%-15s\n", "ID Student", "Name subject", "Point GK", "Point CK","Point average ");
    for (Student stu : st) {
      if (in.equals(stu.getStudentClass())) {
        String id = stu.getID_STUDENT();
        for (Subject sb : sub) {
          if (id.equals(sb.getID_STUDENT())) {
            double a = sb.pointAVG();
            sb.setAVG(a);
            System.out.printf("%-20s%-15s%-15s%-15s%.2f\n", sb.getID_STUDENT(), sb.getName_SJ(), sb.getPointGK_SJ(),
                sb.getPointCK_SJ(), sb.getAVG());
          }
        }
      }
      break;
    }
  }
}
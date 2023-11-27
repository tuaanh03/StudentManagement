package StudentProject;

import java.io.IOException;
import java.util.Scanner;

public class KQHT {
  public KQHT() {
  }

  public static void clrscr() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
    }
  }

  public void studyResultByID(String id) // id student truyen vao o main
  {
    double sum = 0;
    int count = 0;
    DSStudent student = new DSStudent();
    for (Student stu : student.is_stuList()) {
      if (id.equals(stu.getID_STUDENT())) {
        System.out.println("Student's name : " + stu.getName());
        System.out.println("Student's ID : " + stu.getID_STUDENT());
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%-15s\n", "Name Subject", "Point GK", "Point CK", "Point Average");
        DSSubject sub = new DSSubject();
        // DSStudent st = new DSStudent();
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
        System.out.println("------------------------------------------------------------------");
        System.out.printf("Final Result : %.2f\n", (double) (sum / count));
      }
      break;
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
    System.out.print("Enter class you want view result study :");
    String in = sc.nextLine();
    System.out.printf("%-20s%-15s%-15s%-15s%-15s\n", "ID Student", "Name subject", "Point GK", "Point CK",
        "Point average ");
    DSStudent student = new DSStudent();
    DSSubject sub = new DSSubject();
    for (Student stu : student.is_stuList()) {
      if (in.equals(stu.getStudentClass())) {
        String id = stu.getID_STUDENT();
        for (Subject sb : sub.is_SubList()) {
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
}